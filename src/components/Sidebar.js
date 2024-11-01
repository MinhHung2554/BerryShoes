// src/components/Sidebar.js
import React, { useEffect, useState } from 'react';
import { Nav } from 'react-bootstrap';
import { FaChartPie, FaCashRegister, FaFileInvoice, FaProductHunt, FaUser, FaTags } from 'react-icons/fa';
import logoImage from '../assets/logo.png'; // Thay đổi đường dẫn tùy vào nơi lưu ảnh logo

function Sidebar({ isOpen, onNavigate }) {
  const [activeKey, setActiveKey] = useState("#thongke");
  const [sidebarStyle, setSidebarStyle] = useState({ width: '250px', transition: 'width 0.3s' });

  useEffect(() => {
    if (isOpen) {
      setSidebarStyle({ width: '250px', transition: 'width 0.3s' });
    } else {
      setSidebarStyle({ width: '60px', transition: 'width 0.3s' });
    }
  }, [isOpen]);

  const handleClick = (key) => {
    setActiveKey(key);
    onNavigate(key);  // Gọi hàm onNavigate từ App.js
  };

  return (
    <div
      className="sidebar p-3 bg-light"
      style={{ ...sidebarStyle, minHeight: '100vh' }}
    >
      {/* Logo */}
      <div className="text-center mb-4">
        <img
          src={logoImage}
          alt="Logo"
          style={{
            width: isOpen ? '150px' : '40px',
            transition: 'width 0.3s',
          }}
        />
      </div>

      {/* Navigation Links */}
      <Nav className="flex-column text-dark">
        <Nav.Item className="mb-3">
          <Nav.Link
            className={`d-flex align-items-center text-dark ${activeKey === "#thongke" ? "fw-bold" : ""}`}
            onClick={() => handleClick("#thongke")}
          >
            <FaChartPie className="me-2" />
            {isOpen && "Thống kê"}
          </Nav.Link>
        </Nav.Item>
        <Nav.Item className="mb-3">
          <Nav.Link
            className={`d-flex align-items-center text-dark ${activeKey === "#banhangtaquay" ? "fw-bold" : ""}`}
            onClick={() => handleClick("#banhangtaquay")}
          >
            <FaCashRegister className="me-2" />
            {isOpen && "Bán Hàng Tại Quầy"}
          </Nav.Link>
        </Nav.Item>
        <Nav.Item className="mb-3">
          <Nav.Link
            className={`d-flex align-items-center text-dark ${activeKey === "#hoadon" ? "fw-bold" : ""}`}
            onClick={() => handleClick("#hoadon")}
          >
            <FaFileInvoice className="me-2" />
            {isOpen && "Quản Lý Hóa Đơn"}
          </Nav.Link>
        </Nav.Item>
        <Nav.Item className="mb-3">
          <Nav.Link
            className={`d-flex align-items-center text-dark ${activeKey === "#sanpham" ? "fw-bold" : ""}`}
            onClick={() => handleClick("#sanpham")}
          >
            <FaProductHunt className="me-2" />
            {isOpen && "Quản Lý Sản Phẩm"}
          </Nav.Link>
        </Nav.Item>
        <Nav.Item className="mb-3">
          <Nav.Link
            className={`d-flex align-items-center text-dark ${activeKey === "#taikhoan" ? "fw-bold" : ""}`}
            onClick={() => handleClick("#taikhoan")}
          >
            <FaUser className="me-2" />
            {isOpen && "Quản Lý Tài Khoản"}
          </Nav.Link>
        </Nav.Item>
        <Nav.Item className="mb-3">
          <Nav.Link
            className={`d-flex align-items-center text-dark ${activeKey === "#giamgia" ? "fw-bold" : ""}`}
            onClick={() => handleClick("#giamgia")}
          >
            <FaTags className="me-2" />
            {isOpen && "Giảm giá"}
          </Nav.Link>
        </Nav.Item>
      </Nav>
    </div>
  );
}

export default Sidebar;
