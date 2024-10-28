import { useEffect, useState } from "react";
import User, { id, name } from "./user/User";


function App() {
 //let count = 0; 변수로 저장하지 않음
//  let [a,b] =[100,200];//배열 변수
//  console.log('a==>',a,'b==>',b);
 const [count,setCount] = useState(0);
 const [search,setSearch] = useState(0);

  // const add=()=>{
  //   setCount(count+1);
  //   console.log("count ----------->"+count)
  // }
  // function add(){//선언적 함수 정의 | 익명함수 정의 

  // }
  // 3. 서버에서 클라이언트의 요청을 수행한 후 데이터를 반환... 
  // 10을 리턴
  //2번에서는 버튼을 클릭해서 상태값 count를 변경했지만 실질적으로 서버에서
  //받은 데이터 할당
  const ajaxData=()=>{
    let serverCount=10;
    setCount(serverCount);
  }
  //3. useEffect(()=>{},[])[]은 어떤 상태값에도 의존하지 않겠다는 의미
  useEffect(()=>{
    console.log("useEffect App실행됨....");
    ajaxData();
    //화면이 먼저 렌더링 된 후에 서버의 데이터를 받아온다.
  },[search]);
  return (
    <>
    {/* 1. 증가된 조회수가 화면에 반영될려면 변수를 상태값 state로 변경!! useState()사용
    <h2>조회수 : {count}</h2>
    <User/>
    Member ID : {id}<br/>
    Member Name : {name}
    <br/><b>----------------------------------------</b>
    <button onClick={add}>조회수 증가하기</button> */}
    {/* 2. 버튼 누를 때마다 useEffect가 실행된다.
        상태값이 바뀔 때..setCount가 호출될때 App의 return이 동작하는데
        리액트 엔진은 이전화면과 비교해서 변경된 부분만을 다시 랜더링한다.
    */}
    <h2>Hello React... useEffect!!</h2>
    <h2>조회수 증가하기{count}</h2>
    <h2>검색 아이디 :{search}</h2>
    <button onClick={()=>{
      setCount(count+1)
    }}>증가하기</button> 
    <button onClick={()=>{
      setSearch(100)
    }}>조회하기</button> 
    </>
  );
}

export default App;
