import Board from "./Board";

const commemts =[
    {
        writer:"홍종각",
        commemt:"금요일 아침",
    },
    {
        writer:"브라운",
        commemt:"여러분의 진행자입니다.",
    }, 
    {
        writer:"김솔음",
        commemt:"퇴사하고 싶습니다.",
    },
    {
        writer:"이자헌",
        commemt:"....",
    }
]
function BoardList(props){
    return(
<>
{
   commemts.map((commemts)=>{
    return(
        <Board writer={commemts.writer} commemt={commemts.commemt}/>
    );
   }) 
}

</>

    )
}
export default BoardList;