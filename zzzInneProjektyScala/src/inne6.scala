class inne6 {
  

    // ZADANIE 2
  
def lrepeat (ss:Stream[Int]):Stream[Int] = {
  def inRepeat (n:Int, s:Stream[Int]):Stream[Int]=
    (n,s) match {
    case (0, x#::xs) => inRepeat (x+1, xs)
    case (_, Stream.Empty) => Stream.Empty
    case (n, stream@x#::xs) => x#::inRepeat(n-1, stream)
  }//koniec match
  inRepeat (1, ss)
}//koniec metody
  
(lrepeat(Stream.from(1))).take(11).toList
  
  
  
 // ZADANIE 3

def doModulo (n:Int, s:Stream[Int]):Stream[Int] =
  s match {
  case Stream.Empty => Stream.empty
  case x#::xs => (x%n)#::doModulo(n, xs)
}
  
  (doModulo (2, Stream.from(0))).take(10).force
  
  
  // ZADANIE 4
  
  def nextDifferent (st:Stream[Int]) ={
    def helper (la:Int, s:Stream[Int]):Stream[Int] =
      (la, s) match {
      case (_, Stream.Empty) => Stream.empty
      case (last, x#::xs) => if(last == x) helper(x, xs)
                             else x#::helper(x, xs)
    }//koniec match
    helper (0, st)
}
  
  (nextDifferent ((lrepeat(Stream.from(1))))).take(20).force
  

  // ZADANIE 5
  
  def lSegments [A](toDo:Stream[Int], s:Stream[A]):Stream[A] =
    (toDo, s) match {
    case (_, Stream.Empty) => Stream.empty
    case (Stream.Empty, _) => Stream.empty
    case (wez#::Stream.Empty, original) => original.take(wez)
    case (wez#::pomin#::t, original) => original.take(wez)#:::lSegments(t, original.drop(wez+pomin))
  }//koniec match
  
  
  (lSegments (Stream(1,2,2,1,1), Stream.from(1))).take(10).force
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}