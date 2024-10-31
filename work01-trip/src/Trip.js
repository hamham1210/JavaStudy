import Img1 from "./assets/1.jpg";
import Img3 from "./assets/3.jpg";
import Img4 from "./assets/5.jpg";
import './App.css';
function Trip(){
    return(
        <>
       
        <img className="img" src={Img1} width={300} height={300}/>
        <img  className="img2" src={Img3} width={300} height={300}/>
        <img className="img" src={Img4} width={300} height={300}/>
    
        </>
    )
}

export default Trip;