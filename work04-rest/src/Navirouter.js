import React from 'react';

import { Route, Routes} from 'react-router-dom';
import Home from './pages/board/Home';
import SaveForm from './pages/board/SaveForm';
import Detail from './pages/board/Detail';
import LoginForm from './pages/user/LoginForm';
import JoinForm from './pages/user/JoinForm';
import UpdateForm from'./pages/board/UpdateForm';


const Navirouter = () => {
    return (
        <div>
          
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/saveForm' element={<SaveForm/>}/>
                <Route path='/LoginForm' element={<LoginForm/>}/>
                <Route path='/JoinForm' element={<JoinForm/>}/>
                <Route path='/board/:id' element={<Detail/>}/>
                <Route path='/updateForm/:id' element={<UpdateForm/>}/>
            </Routes>
        
        </div>
    );
};

export default Navirouter;