import './App.css';
import Footer from './components/Footer';
import Header from './components/Header';
import Login from './components/Login';
import { Title,T } from './css/MyTitle';
import BoardPage from './pages/BoardPage';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import{BrowserRouter, Link, NavLink, Route, Routes} from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <nav>
        <NavLink to="/">Home</NavLink>
        <Link to="loginPage">Login</Link>
        <Link to="board">Board</Link>
      </nav>
      <Routes>
        <Route>
          <Route path='/' element={<HomePage/>}/>
          <Route path='/login/:id' element={<Login/>}/>
          <Route path='/loginPage' element={<LoginPage/>}/>
          <Route path='/board' element={<BoardPage/>}/>
        </Route>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
