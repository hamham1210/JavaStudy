import React from 'react';

const Home = (props) => {
    const {boards,setBoards} = props;// 구조분할할당
    return (
        <div>
            <h1>Home Page...</h1>
            <button onClick={()=>setBoards([])}>전체 삭제</button>
            {boards.map((board)=>(
            <h3>
                Title :{board.title} &nbsp;&nbsp;
                Content : {board.content}
            </h3>
            ))
}
        </div>
    );
};

export default Home;