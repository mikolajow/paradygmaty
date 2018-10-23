

class zadanie3 {
  
  
  def dwaRowne[A](xss: List[A]):Boolean=
   if (xss==Nil) false
	 else if (xss.tail == Nil) false
	 else if (xss.head == xss.tail.head ) true 
	 else dwaRowne(xss.tail)

val x1 = 1::2::3::4::Nil
dwaRowne(x1)
  
  
  
  
  
  
  
  
  
  
}