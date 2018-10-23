

class zadanie4 {
  
  val sqrList:List[Int] => List[Int] = ( xs:List[Int] ) => 
    if (xs.isEmpty) Nil
    else xs.head*xs.head :: sqrList(xs.tail)
    
sqrList( 1::2::3::(-4)::(-5)::6::Nil )    
    
  
  def sqrList2( xs:List[Int]):List[Int] = 
    if (xs.isEmpty) Nil
    else xs.head*xs.head :: sqrList2(xs.tail)
  
  
  sqrList2( 1::2::3::(-4)::(-5)::6::7::Nil )  
  
  
}