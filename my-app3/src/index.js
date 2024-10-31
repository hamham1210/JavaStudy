import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Form from './form/Form';
import Movie from './reservation/Movie';

const element = <h1>안녕 리액트</h1>;
const url ="https://contents.pauline.or.kr/data/editor/1705/92e3df299e496a5cef491bf57c5db680_1494403184_05.JPG";
console.log("element",element);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  //HTML의 div영역에 들어가는 UI내용이 들어온다.
  //1.JSX문법으로 작성
  // element,
    // <App />
//  <Form />
 <Movie/>
);
