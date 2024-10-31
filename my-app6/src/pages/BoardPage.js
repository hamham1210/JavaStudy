import React from 'react';
import Footer from '../components/Footer'
import Header from '../components/Header'
import Board from '../components/board/Board'

const BoardPage = () => {
    return (
        <div>
            <Footer/>
            <Board/>
            <Header/>
        </div>
    );
};

export default BoardPage;