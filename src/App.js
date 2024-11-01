// src/App.js
import React, { useState } from 'react';
import Sidebar from './components/Sidebar';
import AppNavbar from './components/AppNavbar';
import PosPage from './pages/PosPage'; // Đảm bảo đường dẫn chính xác
import PosOrderPage from './pages/PosOrderPage';  // Đổi tên thành PosOrderPage
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const [currentPage, setCurrentPage] = useState('#thongke'); // Trạng thái để theo dõi trang hiện tại

  // Hàm để thu gọn/mở rộng sidebar
  const toggleSidebar = () => {
    setIsSidebarOpen(prev => !prev);
  };

  // Hàm để chuyển trang
  const handleNavigate = (page) => {
    setCurrentPage(page);
  };

  return (
    <div className="d-flex">
      {/* Sidebar cố định bên trái, truyền trạng thái isOpen */}
      <Sidebar isOpen={isSidebarOpen} onNavigate={handleNavigate} />

      {/* Khu vực nội dung chính */}
      <div style={{ flex: 1 }}>
        {/* Navbar ở phía trên, truyền hàm toggleSidebar */}
        <AppNavbar onToggleSidebar={toggleSidebar} />
        
        {/* Nội dung của trang hiện tại */}
        <div className="p-4">
          {currentPage === '#banhangtaquay' && <PosPage />}
          {currentPage === '#hoadon' && <PosOrderPage />}
          {currentPage === '#sanpham' && <div>Quản Lý Sản Phẩm</div>}
          {currentPage === '#taikhoan' && <div>Quản Lý Tài Khoản</div>}
          {currentPage === '#giamgia' && <div>Giảm giá</div>}
          {currentPage === '#thongke' && <div>Thống kê</div>}
        </div>
      </div>
    </div>
  );
}

export default App;
