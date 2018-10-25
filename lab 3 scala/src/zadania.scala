

class zadania {
  
  
  
  def potega ( x:Float, n:Int ):Float = 
      n match {
      case 0 => 1
      case n => { val acc = potega (x, n/2)
        if (n%2==0) acc*acc else x*acc*acc
      }
    }//koniec match
  potega (3, 4)
  
  
  
  
  
  
  def potega1 ( x:Float, n:Int ):Float ={
    def licz(wynik:Float,  podstawa:Float, n:Int):Float =
      n match {
      case 0 => wynik
      case n => {if (n%2==1) licz(wynik*podstawa, podstawa*podstawa, n/2 ) 
      else licz(wynik, podstawa*podstawa, n/2 ) 
      }
    }//koniec match
    licz (1, x, n)
  }//koniec potega1
  
  
    potega1 (2, 12)
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}//koniec klasy





















