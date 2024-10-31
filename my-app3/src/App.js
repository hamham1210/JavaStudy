import logo from './logo.svg';
import './App.css';
//const, let, var는 거의 사용하지 않는다.

const a ="Hello";
let b ="100";

function App() {
  return (
    <>
    <div>
      <h1 className='box-style'>{a ==="Hi" || "안녕"} 리액트</h1>
      <h2>React 공부한지 {b == 100? "100일" : "3일"}</h2>
    </div>
    </>
  );
}

export default App;
