

class zadanie3 {
  
  
  def replicate[A]( x:A , n:Int ):List[A]=
    if (n==0) Nil
    else x :: replicate( x , n-1 )
  
  replicate("la", 4)
  
  
  
  
  
  
}