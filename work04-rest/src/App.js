import container from 'react-bootstrap'
import './App.css';
import Header from './components/Header';
import Navirouter from './Navirouter';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
 
        <Header/>
 
     <Navirouter/>
    </div>
  );
}

export default App;
