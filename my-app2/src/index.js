import React, { Fragment } from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import PMS from './phones/PMService';
import Clock from './time/Clock';
// 1. const, function 사용해서 ui 요소 구성하기
// const member ={
//   id:"Kosta",
//   pwd:"1234",
//   name:"홍종각",
//   adress:"종각",
// }
// function getMember(member){
//   return member.id+" "+member.name
// }
// const uielement =(
//   <h1>Heollo, {getMember(member)}</h1>
// )
const root = ReactDOM.createRoot(document.getElementById('root'));
setInterval(()=>{
  root.render(
    <>
    
     <PMS/>

      <Clock/>
   
    </>
  )
},1000);




