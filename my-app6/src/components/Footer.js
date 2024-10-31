import React from 'react';
import styled from 'styled-components';

const StyledFooter =styled.div`
border: 1px solid rebeccapurple;
width: 500px;
margin-left: 400px;
padding-top:20px;
margin-top: 50px;
`



function Footer(props) {
    return (
        <div>
            <StyledFooter>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
            </StyledFooter>
        </div>
    );
}

export default Footer;