import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Container } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [board, setBoard] = useState({
        id: 0,
        title: '',
        author: '',
    });

    useEffect(() => {
        axios({
            url: 'http://localhost:9000/boards/' + id, // URL 수정
            method: 'get',
        })
        .then((res) => {
            setBoard(res.data);
        })
        .catch((err) => {
            console.log("Error fetching board:", err);
        });
    }, [id]);

    const changeForm = (e) => {
        setBoard({
            ...board,
            [e.target.name]: e.target.value,
        });
    };

    const submitBoard = (e) => {
        e.preventDefault();

        axios({
            url: 'http://localhost:9000/boards/' + id, // URL 수정
            method: 'put',
            data: board,
        })
        .then((res) => {
            if (res.status === 200) { // 상태 코드 수정
                navigate("/board/" + id);
            }
        })
        .catch((err) => {
            console.log("Error updating board:", err);
        });
    };

    return (
        <div>
            <h1>글 수정하기</h1>
            <Container style={{ marginTop: '100px' }}>
                <Form onSubmit={submitBoard}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Title</Form.Label>
                        <Form.Control type="text" name="title" value={board.title} onChange={changeForm} />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Author</Form.Label>
                        <Form.Control type="text" name="author" value={board.author} onChange={changeForm} />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </div>
    );
};

export default UpdateForm;
