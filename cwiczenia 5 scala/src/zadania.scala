

class zadania {
  
  
  
  // ZADANIE 1
  
def lrepeat (m:Int, ss:Stream[Int]):Stream[Int] = {
  def inRepeat (n:Int, s:Stream[Int]):Stream[Int]=
    (n,s) match {
    case (0, x#::xs) => inRepeat (m, xs)
    case (_, Stream.Empty) => Stream.Empty
    case (n, stream@x#::xs) => x#::inRepeat(n-1, stream)
  }//koniec match
  inRepeat (m, ss)
}//koniec metody
  
  val a = Stream(1,2,3)
  
  (lrepeat(3, Stream.from(4))).take(11).toList
  
  
  
  // ZADANIE 2
  
  def lfib = {
    def inFib (pp:Int, p:Int):Stream[Int] = (pp+p)#::inFib(p, pp+p)
    0#::1#::inFib(0,1)
  }
  
  lfib.take(10).toList
  
  //ZADANIE 3
  
  
 sealed trait lBT[+A]
 case object LEmpty extends lBT[Nothing]
 case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]

  
  def ltree (n:Int):lBT[Int] = LNode(n, () => ltree(2*n), () => ltree(2*n+1))
  
  def breadthBT (lbt:lBT[Int]):Stream[Int] = {
    def helper (list:List[lBT[Int]]):Stream[Int] = 
      list match {
      case List() => Stream.Empty
      case LEmpty::t => helper (t)
      case LNode(x, lf, rf)::t => x#::helper(t:::List(lf(), rf()))
    }//koniec match
    helper (List(lbt))
  }//koniec searcha
  
  
  
  breadthBT(ltree(1)).take(11).toList
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}