

class zadanie2 {
  
  
  def twoLast[A](xss:List[A]):(A,A)=
    		if (xss==Nil) throw new Exception("pusta")
		else if (xss.tail == Nil) throw new Exception("tylko jeden")
		else if ( xss.tail.tail == Nil) (xss.head , xss.tail.head )
		else twoLast(xss.tail)
	
twoLast(List(1,2,3,4,5,6,7))
  
  
  
  
  
  
  
  
  
}