import './Movie.css';

const movie ="듄 파트2";
const header="100만관객 동원"
const element = <h1>안녕 리액트</h1>;
const url ="https://i.namu.wiki/i/EBnXxQjDFnQRItujvTQ61BBkgCb5-rqskUO9uhVXncxZU_I_gkzd3FBN2VDwCYo637zDjzJtdmdAHj_g7l9mow.webp";
function Movie(){
    return(
        <>
        <div className="movie-box">
        <h2>{movie}</h2>
        <h2>{header}</h2>
        <img src={url} width={300} height={300}/>
        <button className="btm" onClick={reservation}>영화예매하기</button>
        </div>
        </>  
    )
}
export default Movie;
function reservation(){
    alert("영화 예매 확인되었습니다.~~")
  }