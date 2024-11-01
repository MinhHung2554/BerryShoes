// src/components/ProductTable.js
import React, { useState } from 'react';
import { Button, Row, Col } from 'react-bootstrap';

// Nhập hình ảnh từ thư mục assets
import shoeImage from '../assets/logo.png';

function ProductTable() {
  const [products, setProducts] = useState([
    { id: 1, name: 'Giày BerryShoes', price: 1200000, size: 38, quantity: 2 },
    { id: 2, name: 'Giày BerryShoes', price: 1200000, size: 38, quantity: 2 },
    { id: 3, name: 'Giày BerryShoes', price: 1200000, size: 38, quantity: 2 },
    { id: 4, name: 'Giày BerryShoes', price: 1200000, size: 38, quantity: 2 },
  ]);

  const handleIncrement = (id) => {
    setProducts(products.map(product => 
      product.id === id ? { ...product, quantity: product.quantity + 1 } : product
    ));
  };

  const handleDecrement = (id) => {
    setProducts(products.map(product => 
      product.id === id && product.quantity > 0 ? { ...product, quantity: product.quantity - 1 } : product
    ));
  };

  const handleDelete = (id) => {
    setProducts(products.filter(product => product.id !== id));
  };

  // Tính tổng tiền
  const totalAmount = products.reduce((sum, product) => sum + product.price * product.quantity, 0);

  return (
    <div style={{ padding: '20px', backgroundColor: '#ffffff', borderRadius: '8px', boxShadow: '0 2px 4px rgba(0,0,0,0.1)' }}>
      {/* Hàng chứa mã hóa đơn và các nút điều khiển */}
      <Row className="mb-3">
        <Col md={6}>
          <div><strong>Hóa đơn:</strong> SBSHOES6668892</div>
        </Col>
        <Col md={6} className="text-end">
          <Button variant="secondary" className="me-2">Thêm sản phẩm</Button>
          <Button variant="secondary">Danh sách hóa đơn</Button>
        </Col>
      </Row>

      {/* Bảng sản phẩm */}
      <table className="table mt-3" style={{ borderCollapse: 'separate', borderSpacing: '0 10px' }}>
        <thead>
          <tr style={{ backgroundColor: '#F8E7CA', borderTopLeftRadius: '8px', borderTopRightRadius: '8px' }}>
            <th style={{ padding: '12px', borderTopLeftRadius: '8px' }}>STT</th>
            <th style={{ padding: '12px' }}>Ảnh</th>
            <th style={{ padding: '12px' }}>Sản phẩm</th>
            <th style={{ padding: '12px' }}>Số lượng</th>
            <th style={{ padding: '12px' }}>Tổng tiền</th>
            <th style={{ padding: '12px', borderTopRightRadius: '8px' }}>Thao tác</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={product.id} >
              <td style={{ padding: '10px' }}>{index + 1}</td>
              <td style={{ padding: '10px' }}>
                <img src={shoeImage} alt={product.name} style={{ width: '50px', borderRadius: '4px' }} />
              </td>
              <td style={{ padding: '10px' }}>
                {product.name}<br />
                {product.price.toLocaleString()} đ<br />
                Size: {product.size}
              </td>
              <td style={{ padding: '10px' }}>
                <button className="btn btn-light btn-sm me-1" onClick={() => handleDecrement(product.id)}>-</button>
                {product.quantity}
                <button className="btn btn-light btn-sm ms-1" onClick={() => handleIncrement(product.id)}>+</button>
              </td>
              <td style={{ padding: '10px' }}>{(product.price * product.quantity).toLocaleString()} đ</td>
              <td style={{ padding: '10px' }}>
                <button className="btn btn-danger btn-sm" onClick={() => handleDelete(product.id)}>
                  <i className="fas fa-trash"></i>
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Hiển thị tổng tiền */}
      <div className="text-end">
        <h5><strong>Tổng tiền: {totalAmount.toLocaleString()} đ</strong></h5>
      </div>
    </div>
  );
}

export default ProductTable;
