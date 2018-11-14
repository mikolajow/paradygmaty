

class zadania3 {
  
  
 
 //potegowanie efektywne 
  
  def potega2 (x:Float, n:Int) = {
    
    def licz(acc:Float, podstawa:Float, n:Int):Float =
      n match {
      case 0 => acc
      case _ => if(n%2 == 0) licz(acc, podstawa*podstawa, n/2)
      else licz(acc*podstawa, podstawa*podstawa, n/2)
    }//koniec match
        
     licz(1, x, n)   
        
  }//koniec potega2
  
  potega2(3, 4)
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}//koniec klasy
















