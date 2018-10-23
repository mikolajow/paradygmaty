

class zadanie6 {
  
  def listLength[A] ( xs:List[A] ):Int =
    if (xs.isEmpty) 0
    else 1 + listLength ( xs.tail )
  
 
 listLength ( 'k'::1::2::3::1::2::3::Nil )
  
  
  
  
  
  
  
  
  
  
  
}