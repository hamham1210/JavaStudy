import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListPage from "./pages/ListPage";
import WritePage from "./pages/WritePage";
import Navigate from "./Navigate";
import axios from "axios";
//react-axios보다 axios를 더 많이 씀 (근데 자동완성이 안됨)

function App() {
  const selectAll = () => {
    axios
      .get("https://jsonplaceholder.typicode.com/posts") //요청을보내고
      //성공했다면 이 곳으로 데이터가 반환됨
      .then((result) => {
        // console.log(result);
        // console.log(result.data); //data만 받아오기
        result.data.map((item) => {
          console.log(item.id + "," + item.title);
        });
      })
      //실패했다면 이 곳으로 옴
      .catch((err) => {
        console.error(err);
      });
  };

  const selectById = () => {
    axios({
      //요청 진행
      url: "https://jsonplaceholder.typicode.com/posts/1",
      method: "get",
      //data:
    })
      .then((result) => {
        console.log(result.data);
      })
      .then(() => {
        //이런 부분이 CallBack Hell을 만나지 않게 하는 중요한 부분이 됨
        console.log("성공한 후에 할 일은 여기서도 계속됨");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="App">
      {/* <BrowserRouter>
        <Navigate />
        <Routes>
          <Route path="/" element={<ListPage />} />
          <Route path="/write" element={<WritePage />} />
        </Routes>
      </BrowserRouter> */}

      {/* <ListPage /> */}

      <button onClick={selectAll}>get-selectAll</button>
      <button onClick={selectById}>get-selectById</button>
    </div>
  );
}

export default App;
