import scala.annotation.tailrec
// ZADANIE 2






class ww {
  
  
  
def fibo(n:Int):Int={
  if(n==0){0}
  else{
    if(n==1){1}
    else{
      fibo(n-2)+fibo(n-1)
    }
  }
}


fibo(5)




def fibo2(n:Int):Int={
       
      @tailrec
      def fibT(n:Int,pn:Int,ppn:Int):Int= n match{
        case 0 => ppn
       // case 1 =>pn
        case _ => fibT(n-1,pn+ppn,pn)


      }
      fibT(n,1,0)
}

// TRZEBA POMYSLEC


fibo2(9)







//ZADANIE 3

def newton(a:Double):Double={

  def newton2(wynik:Double): Double ={
    if(math.abs(math.pow(wynik,3)-a)<=math.pow(10,-15)*math.abs(a)){wynik}
    else{
      newton2(wynik+((a/math.pow(wynik,2))-wynik)/3)
    }


  }
  if(a>1){newton2(a/3)        // W SUMIE to pierwsze a niepotrzebne
  }
  else{
    newton2(a)
  }
  
}
newton(28.0)







// ZADANIE 4


val List(_,_,x,_,_)=List(-2,-1,0,1,2)

val List((_,_),(x1,_))=List((1,2),(0,1))

//TAK też można
val xs=List(1,2,3)

val List(_,x3,_)=xs








// ZADANIE 5


def initSegment[A](list:List[A],list2:List[A]):Boolean= (list,list2) match{
   case (List(),_) => true
   case ((h1::t1),List())=>false
   case ((h1::t1),(h2::t2))=>if(h1==h2){initSegment(t1,t2)}else{false}


}


initSegment(List(1,2,3,4),List(1,2,3,4,5))
initSegment(List(1,2,4),List(1,2))
initSegment(List(),List(1,2,3,4,5))
initSegment(List(1,2,3),List())
initSegment(List(1),List(1,2))
initSegment(List(1,2,3),List(1,2,3))











//ZADANIE 6
def replaceNth[A](list:List[A],position:Int,elem:A):List[A]= (list,position) match {
  case (List(),_) => List()
  case (hd::tl,0) => elem::tl
  case (hd::tl,_)=> hd::replaceNth(tl,position-1,elem)
}


replaceNth(List('o','l','a'),4,'s')

replaceNth(List('o','l','a'),1,'s')












}