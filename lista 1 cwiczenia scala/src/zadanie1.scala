class zadanie1 {

  
  
  def flatten[A](xss: List[ List[A] ]):List[A] =
    if ( xss.isEmpty   ) Nil
    else xss.head ::: flatten( xss.tail )
  
 // val x1 = 5::6::Nil
 // val x2 = 1::2::3::Nil
  
  flatten ( (5::6::Nil) :: (1::2::3::Nil)::Nil )
  
  
  
  
  
  
  
  
  
}