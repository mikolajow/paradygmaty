

class zadania {
  
  
  //ZADANIE 1 -------------------------
  
  def podzielWgMod(xs:List[Int],n:Int):(List[Int],List[Int])={
    def licz(main:List[Int],lista1:List[Int],lista2:List[Int],n:Int):(List[Int],List[Int])=
      (main,n) match{
      case (List(),_) => (lista1.reverse,lista2.reverse)
      case (_,n) if(n<=1) => throw new Exception("wyjatek")
      case (h::t,_) => if(h%n == 0) licz(t,h::lista1,lista2,n) else licz(t,lista1,h::lista2,n)
    }//koniec match
    licz(xs,List(),List(),n)
  }//koniec metody 
    
  
  podzielWgMod(List(1,8,9,5,12,2),-2)
  
  
  //ZADANIE 2 --------------------------------------
  
  
  
  def coNty[A](xs:List[A], n:Int):List[A] ={
    def licz[A](xs:List[A],index:Int,lista:List[A], n:Int):List[A] =
      if (n<=0) List()
      else
        xs match {
        case List() => lista.reverse
        case h::t => if (index%n==0) licz(t,index+1,h::lista, n) else licz(t,index+1,lista, n)
      }//koniec match
    licz(xs,1,List(),n)
  }//koniec metody
  
  
  coNty(List(1,3,5,7,0,2,4),2)
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}//koniec klasy