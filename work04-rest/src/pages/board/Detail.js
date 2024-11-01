import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';

const Detail = () => {
    const {id} = useParams();
    const navigate = useNavigate();
    //비동기로 id에 해당하는 Board를 받아올것이다.
    //그 값을 상태값으로 저장...
    const [board, setBoard] = useState({
        id:0,
        title:'',
        author:'',

    });

    useEffect(()=>{
        axios({
            url:'http://localhost:9000/boards/'+id,
            method:'get',

        })
        .then((res)=>{
            console.log(res.data);
            setBoard(res.data);
        })
        .catch((err)=>{
            console.log(err);
        })
    },[id]);

    const deleteBoard=()=>{
        axios({
            url:'http://localhost:9000/boards/'+id,
            method:'delete',
        })
        .then((res)=>{
            if(res.status===200){
                navigate("/");
            }
            else{
                alert("삭제 실패~~!!")
            }
        })
    }
    const updateBoard=()=>{
        alert("이동!")
        navigate("/updateForm/"+id);
    }
    return (
        <div>
            <h1>글 상세보기</h1>
            <hr/>
            <button variant="primary" onClick={updateBoard}>수정</button>
            {''}
            <button variant="primary" onClick={deleteBoard}>삭제</button>
            <hr/>
            <h3>{board.id}</h3>
            <h3>{board.title}</h3>
            <h3>{board.author}</h3>

        </div>
    );
};

export default Detail;