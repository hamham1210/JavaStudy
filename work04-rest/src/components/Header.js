
import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';


const Header = () => {
    return (
        <div>
           <Navbar bg="primary" data-bs-theme="dark">
        <Container>
            {/* .을 -로 바꾸고 전부 소문자로 변경...className */}
            <Link to="/" className='navbar-brand'>Home</Link>
            <Nav to="/" className="me-auto">
            <Link  to="/saveForm" className='nav-link'>글쓰기</Link>
            <Link to="/LoginForm" className='nav-link'>로그인</Link>
            <Link to="/JoinForm" className='nav-link'>회원가입</Link>
          </Nav>
        </Container>
      </Navbar>
        </div>
    );
};

export default Header;