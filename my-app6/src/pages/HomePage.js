import React, { useEffect, useState } from 'react';
import Footer from '../components/Footer';
import Header from '../components/Header';
import Home from '../components/home/Home'

const HomePage = (props) => {
    const [boards, setBoards] =useState([]);
    useEffect(()=>{
        //디비에서 데이터 받아오는 비동기 통신... 데이터 받아왔다 치고
        let datas=[
            {id:1, title:'첫 번째글',content:"첫번째 내용"},
            {id:2, title:'두 번째글',content:"두번째 내용"},
            {id:3, title:'세 번째글',content:"세번째 내용"},
        ];
//setBoards()는 안에서 해줘야한다.
setBoards(datas);
    },[]);
    
    return (
        <div>
            <Footer/>
            <Home boards={boards} setBoards={setBoards}/>
            <Header/>
        </div>
    );
};

export default HomePage;