import React from "react";
import Footer from "../components/commons/Footer";

const WritePage = () => {
  const handleWriter = () => {
    //게시글 하나가 생성
    let board = { id: 6, title: "폼 입력값" };
  };

  return (
    <div>
      <h1>WritePage</h1>
      <form>
        <input type="text" placeholder="제목을 입력하세요" />
        <button type="button" onClick={handleWriter}>
          글쓰기
        </button>
      </form>
      <Footer />
    </div>
  );
};

export default WritePage;
