// src/pages/PosOrderPage.js
import React from 'react';
import { FaFilter, FaEdit, FaTrashAlt } from 'react-icons/fa';

function PosOrderPage() {
  return (
    <div style={{ padding: '20px' }}>
      <h2 style={{ fontSize: '24px', fontWeight: 'bold', marginBottom: '20px' }}>Quản lý hóa đơn</h2>

      {/* Bộ lọc và Tạo mới */}
      <div style={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        marginBottom: '10px'
      }}>
        <div style={{ display: 'flex', alignItems: 'center' }}>
          <FaFilter style={{ marginRight: '8px' }} />
          <span style={{ fontSize: '16px', fontWeight: 'bold' }}>Bộ lọc</span>
        </div>
        <button style={{
          backgroundColor: '#4CAF50', color: 'white', padding: '8px 16px', borderRadius: '4px', border: 'none', fontSize: '16px'
        }}>+ Tạo mới</button>
      </div>
      
      <hr style={{ margin: '20px 0', borderColor: '#ddd' }} />

      {/* Bộ lọc chi tiết */}
      <div style={{
        display: 'grid',
        gridTemplateColumns: '1fr 1fr',
        gap: '20px',
        padding: '20px',
        backgroundColor: '#f9f9f9',
        borderRadius: '8px',
        marginBottom: '20px',
        boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
      }}>
        <div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
          <label style={{ fontSize: '14px' }}>Tìm kiếm</label>
          <input type="text" placeholder="Tất cả" style={{
            padding: '8px', border: '1px solid #ccc', borderRadius: '4px'
          }} />
          <label style={{ fontSize: '14px', marginTop: '10px' }}>Ngày bắt đầu</label>
          <input type="date" style={{
            padding: '8px', border: '1px solid #ccc', borderRadius: '4px'
          }} />
        </div>

        <div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
          <label style={{ fontSize: '14px' }}>Loại hóa đơn</label>
          <input type="text" placeholder="Tất cả" style={{
            padding: '8px', border: '1px solid #ccc', borderRadius: '4px'
          }} />
          <label style={{ fontSize: '14px', marginTop: '10px' }}>Ngày kết thúc</label>
          <input type="date" style={{
            padding: '8px', border: '1px solid #ccc', borderRadius: '4px'
          }} />
        </div>

        <div style={{
          gridColumn: '1 / span 2',
          display: 'flex',
          justifyContent: 'center',
          gap: '10px',
          marginTop: '20px'
        }}>
          <button style={{
            backgroundColor: '#4CAF50', color: 'white', padding: '8px 16px', borderRadius: '4px', border: 'none', fontSize: '16px'
          }}>Tìm kiếm</button>
          <button style={{
            backgroundColor: '#f0f0f0', color: 'black', padding: '8px 16px', borderRadius: '4px', border: '1px solid #ccc', fontSize: '16px'
          }}>Làm mới</button>
        </div>
      </div>

      {/* Danh sách hóa đơn */}
      <div style={{
        display: 'flex',
        alignItems: 'center',
        marginBottom: '10px'
      }}>
        <FaFilter style={{ marginRight: '8px' }} />
        <span style={{ fontSize: '16px', fontWeight: 'bold' }}>Danh sách hóa đơn</span>
      </div>

      <div style={{
        overflowX: 'auto',
        backgroundColor: '#ffffff',
        padding: '20px',
        borderRadius: '8px',
        boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
      }}>
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr>
              <th colSpan="10" style={{ textAlign: 'center', padding: '10px', borderBottom: '1px solid #ddd' }}>
                <div style={{ display: 'flex', gap: '10px', justifyContent: 'center' }}>
                  {["Tất cả", "Chờ xác nhận", "Đã xác nhận", "Chờ giao hàng", "Đang giao hàng", "Đã thanh toán", "Đã hủy"].map((status, index) => (
                    <button key={index} style={{
                      backgroundColor: '#f0f0f0',
                      color: 'black',
                      padding: '8px 12px',
                      borderRadius: '4px',
                      border: '1px solid #ccc',
                      fontSize: '14px'
                    }}>{status}</button>
                  ))}
                </div>
              </th>
            </tr>
            <tr style={{ backgroundColor: '#F8E7CA' }}>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>STT</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Mã hóa đơn</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Mã nhân viên</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Tên khách hàng</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>SDT khách hàng</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Loại HD</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Tổng tiền</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Ngày tạo</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Trạng thái</th>
              <th style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Thao tác</th>
            </tr>
          </thead>
          <tbody>
            {Array.from({ length: 10 }).map((_, index) => (
              <tr key={index}>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>{index + 1}</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>VNA26354897</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>2411362</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Nguyễn Văn Nam</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>0982666999</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Điện tử</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>920.000 VND</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>22/06/2024</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>Đã bán</td>
                <td style={{ padding: '10px', borderBottom: '1px solid #ddd' }}>
                  <button style={{ color: '#007bff', background: 'none', border: 'none', padding: '5px' }}>
                    <FaEdit />
                  </button>
                  <button style={{ color: 'red', background: 'none', border: 'none', padding: '5px' }}>
                    <FaTrashAlt />
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default PosOrderPage;
