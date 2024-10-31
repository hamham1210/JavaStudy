import React from 'react';
import Footer from '../components/Footer';
import Login from '../components/Login';
import Header from '../components/Header';
import{BrowserRouter, Link, NavLink, Route, Routes, useNavigate} from 'react-router-dom';
//비동기 통신ㄷ으로 서버에서 로그인된 모든 정보를 받아온다.
const users =[
    {id:"kosta",pwd:"1234",name:"김솔음"},
    {id:"brown",pwd:"4321",name:"브라운"},
    {id:"admin",pwd:"1234",name:"admin"},
]

const LoginPage = (props) => {
 const navigate = useNavigate();
 const goBack=()=>{
    navigate(-1);
 };
 const goHome=()=>{
    navigate("/");
 }
    return (
        <div>
           <Footer/>
           <h3>Login Members</h3>
           <ul style={{'textAlign':'center','color':'burlywood','fontSize':'1.4em','padding':'3em'}}>
{   
      users.map((user) => (
        <li key={user.id} style={{'padding':'2em'}}>
            {/* <Link to={{
                pathname: `/login/${user.id}`,
                 state: { user: user } // 사용자 객체를 state에 전달
            }}>
                 {user.name}
            </Link> */}
            <span onClick={()=>{navigate(`/login/${user.id}`,{state:{user}})}}>{user.name}</span>
        </li>
    ))
}
<div>
 <button onClick={goBack}>goBack</button>
 <button onClick={goHome}>goHome</button>
</div>
           </ul>
           <Header id="여기는 헤더 일까요?"/> 
        </div>
    );
};

export default LoginPage;