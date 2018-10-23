

class zadanie2 {
  
  
  def count [A] ( x:A , xs:List[A] ):Int =
    if (xs.isEmpty) 0
    else if ( xs.head == x ) 1 + count( x, xs.tail )
    else count( x, xs.tail )
  
  
  count ( 'a' , 'a'::'b'::'a'::Nil )
  
  
  
  
  
  
}