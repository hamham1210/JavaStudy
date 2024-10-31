import{useState} from 'react'
import logo from './logo.svg';
import './App.css';
//서버에서 받아온 데이터 비동기 통신
//let location ="인도"
function location(){
  return "인도";
}
const styles={color:'blue',fontSize:'30px'}


function App() {
  //여행지가 변경되면 그때마다 화면의 내용이 변경....상태값으로 처리해야한다...
  //useState
  let locations = ['인도','라오스','마다가스카르','스페인','하와이']
  let [loc,setLoc]= useState(['Best Like Trip',locations])
  const [likes, setLikes] = useState(Array(locations.length).fill(0));
  const handleLike = (index) => {
    setLikes((prevLikes) => {
      const newLikes = [...prevLikes];
      newLikes[index] += 1;
      return newLikes;
    });
  };
  return (
    <div className="App">
      <div className="nav">
        태어난 김에 세계일주
      </div>
      {/* getElementById("h3").innerHTML = location; */}
      {/* <h3 style={styles}>{location()} 여행 Blog 작성</h3> */}
  {
  locations.map((location,index)=>(
    <div className='list'>
    <h3>{location}{" "} <span onClick={() => handleLike(index)}>🚗</span>
    </h3>
    <p>{loc[0]}~~~~~~~~~{likes[index]}</p><hr/>
    </div>
  ))
  }
    </div>
  );
}

export default App;
