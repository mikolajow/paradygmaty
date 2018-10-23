import scala.annotation.tailrec



class moje {
  
  
  def fibbo1 (n:Int):Int = 
    if (n==0) 0
    else if (n==1) 1
    else fibbo1(n-1) + fibbo1(n-2)
    
  fibbo1(60)
  
  
  
  
  def fibo2 (n:Int):Int = {
      
      
    def licz (nn:Int , poprzednia:Int, poprzedniejsza:Int):Int =
      if (nn==0) 0
      else if(nn==1) 1
      else if (nn==n) poprzednia + poprzedniejsza
      else licz(nn+1, poprzednia+poprzedniejsza, poprzednia)
      
    licz(2,1,0)
    
  }
  
  
  
  fibo2(60)
  
  
  
  /*
  def fibbo(n:Int):Int = {
    def licz(nn:Int, poprzednia:Int, poprzedniejsza:Int):Int =
      nn match{
      case 0 => poprzedniejsza
      case _ => licz(nn-1,poprzednia+poprzedniejsza, poprzednia)
    }//match
    licz(n,1,0)
    
  }
  
  
  fibbo(1)
  
  
  */
  
  //ZADANIE 3 @@@@@@@@@@@@@@@@@@@@@@@
  

  def root3(a:Double):Double = {
    def licz(wynik:Double):Double =
      if ( Math.abs( Math.pow(wynik, 3) - a ) <= Math.pow(10, -15)* Math.abs(a) ) wynik
      else licz( wynik + ( a/Math.pow(wynik, 2) - wynik )/3 )
    if(a>1) licz(a/3)
    else licz(a)
  }//koniec root3
  
  root3(28)
  
  
//ZADANIE 4 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  
  val xs = List(-2,-1,0,1,2)
  val List(_,_,x,_,_) = xs;
  
  val xss = List((1,2),(0,1))
  val List((_,_),(x1,_)) = xss
  
  
  
  //ZADANIE 5 @@@@@@@@@@@@@@@@@@@@
  
  
//  val list = List(1,2,3,4)
//  val h::t = list
  
  def initSegment[A](lista1:List[A], lista2:List[A] ):Boolean =
    (lista1,lista2) match {
    case (List(),_) => true
    case ( _ ,List() ) => false
    case (( h1::t1 ),( h2::t2 )) => if (h1==h2) initSegment(t1,t2) else false
  }//koniec match
  

//ZADANIE 6 @@@@@@@@@@@@@@@@@@@@@@@
  
  def replaceNth[A](xs:List[A], n:Int, e:A):List[A] =
    (xs,n) match {
    case (_,x) if(x<0) => xs
    case (List(),_) => List()
    case (h::t,0) => e::t 
    case (h::t,_) => h::replaceNth(t,n-1,e)
  }//koniec match
  
  
  replaceNth(List(1,2,3,4),3,9)
  
  
  
  
  
}//koniec klasy











































