import axios from 'axios';
import React, { useState } from 'react';
import { Container } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Navigate, useNavigate } from 'react-router-dom';

const SaveForm = () => {
    const navigate = useNavigate();
    const [board,setBoard] = useState({
        title:'',
        author:'',
    })
    const changeForm=(e)=>{
        //setBoard...board를 새로 만들고 폼에 입력된 값으로 그 객체를 채운다.
        setBoard({
            ...board,
            [e.target.name]:e.target.value
        })

    }

    const submitBoard =(e)=>{
        //form에 걸린 action으로 가는 걸 막고axios비동기 통신을 탄다.
        e.preventDefault();

        //비동기 통신으로 폼에 입력된 값으로 board를 생성... 이걸 서버에 전달...디비에 입력
        axios({
            url:'http://localhost:9000/boards',
            method:'post',
            data:board

        })
        .then((res)=>{
            console.log(res);
            if(res.status===201){
                navigate("/");
            }
        })
        .catch((err)=>{
            console.log(err)
        })

    }
    return (
        <div>
            <h1>글 저정하기</h1>
            <Container style={{marginTop:'100px'}}>
            <Form onSubmit={submitBoard}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Title</Form.Label>
        <Form.Control type="text" name='title' onChange={changeForm}/>
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Author</Form.Label>
        <Form.Control type="text" name='author' onChange={changeForm}/>
      </Form.Group>
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
    </Container>
        </div>
    );
};

export default SaveForm;