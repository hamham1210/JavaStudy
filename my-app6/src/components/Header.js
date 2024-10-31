import React from 'react';
import styled from 'styled-components';

const StyledHeader = styled.div`
border: 1px solid rebeccapurple;
height: 100px;
width: 500px;
display: flex;
justify-content: space-around;
list-style: none;
width: 500px;
margin-left: 400px;
padding-top:20px;
margin-top: 30px;
`
function Header(props) {
    return (
        <div>
            <StyledHeader>
                <h3>{props.id}</h3>
                <li>오시는 길 : 서울 종로구 우정국로 대왕빌딩 7F</li>
                <li>전화번호 : 02-111-1234</li>
            </StyledHeader>
        </div>
    );
};

export default Header;