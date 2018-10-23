

class zadania_2 {
  
  
  
  def modulo(xs:List[Int], n:Int):(List[Int],List[Int])={
    def dziel(xs:List[Int], lista1:List[Int], lista2:List[Int], n:Int ):(List[Int],List[Int])=
      (xs,n) match{
      case (List(),_) => (lista1.reverse,lista2.reverse)
      case ((h::t),_) => if (h%n == 0) dziel(t,h::lista1,lista2,n) else dziel(t,lista1,h::lista2,n)
    }//koiec match
    dziel(xs,List(),List(),n)
      
      
  }//koniec modulo
  
  modulo(List(1,8,9,5,12,2),3)
  
  
  def CoNty[A](xs:List[A], n:Int):List[A]={
    def licz[A](xs:List[A],index:Int,lista:List[A],n:Int):List[A]=
      (xs,n) match{
      case (List(),_) => lista.reverse
      case (_,x) if x<=0 => xs
      case (h::t, _) => if(index%n == 0) licz(t,index+1,h::lista,n) else licz(t,index+1,lista,n)
    }//koniec match
  licz(xs,1,List(),n)
  }//koniec conety
  
  CoNty(List(1,3,5,7,0,2,4),2)
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}//koniec klasy





























