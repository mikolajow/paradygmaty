

class zadania {
  
  
  
  //zadanie 2 
def potegi(pods:Int):Stream[Int] ={
  def inPot (curr:Int, podst:Int):Stream[Int] =
    curr#::inPot (curr*podst, podst)
  inPot(1, pods)
}
  
  
potegi(2).take(10).force
  


//zadanie 3
  
def doModulo (n:Int, s:Stream[Int]):Stream[Int] =
  s match {
  case Stream.Empty => Stream.empty
  case x#::xs => (x%n)#::doModulo(n, xs)
}
  


doModulo(2, Stream.from(0)).take(10).force
  
  
  def onlyModulo (n:Int, s:Stream[Int]):Stream[Int] =
  s match {
  case Stream.Empty => Stream.empty
  case x#::xs if(x%n ==0) => (x)#::onlyModulo(n, xs)
  case x#::xs => onlyModulo(n, xs)
}
  


  onlyModulo(2, Stream.from(0)).take(10).force
  
  
  //zadanie 5
  
  
  def lshuffle (s1:Stream[Int], s2:Stream[Int]):Stream[Int]=
    (s1, s2) match {
    case (Stream.Empty, xs2) => xs2
    case (xs1, Stream.Empty) => xs1
    case (x1#::xs1, x2#::xs2) => x1#::x2#::lshuffle(xs1, xs2)
  }//koniec match
  
  
  lshuffle(Stream.from(0), Stream.from(300)).take(20).force
  
  //zadanie 5 drugi sposób
    
  def lshuffle2 (s1:Stream[Int], s2:Stream[Int]):Stream[Int]=
    s1 match {
    case Stream.Empty => s2
    case x1#::xs1 => x1#::lshuffle(s2, xs1)
  }//koniec match
  
  
    lshuffle2(Stream.from(0), Stream.from(300)).take(20).force
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}//koniec klasy
