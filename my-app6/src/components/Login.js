import React from 'react';
import { useLocation, useParams } from 'react-router-dom';
import styled from 'styled-components';

//styledLogin component,.,,html custom tag만으로도 css효과 바로 연결
const styledLogin = styled.div`
color: aqua;
padding: 30px 0 30px 0;
`

const Login = () => {
    const param = useParams();
    const location = useLocation();//Link를 통해서 데어틀 받아올때 사용
    const user = location.state.user;
    return (
        <div>
          <styledLogin>
            <h1>로그인 페이지입니다.</h1>
            <h3>USER ID : {param.id}</h3>
            <h3>
              USER : {user.name}, {user.id}, {user.pwd}
            </h3>
          </styledLogin>
        </div>
      );
};
export default Login;