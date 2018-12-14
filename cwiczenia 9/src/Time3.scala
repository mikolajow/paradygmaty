class main3{


  class IllegalArgumentException extends Exception{  }
  
//zadanie 2 b
class Time3 (hour:Int, minute:Int ) {
  if (hour<0 || hour > 24 || minute < 0 || minute > 60) throw new IllegalArgumentException
  
  private var minutes = 60*hour + minute
  
  def changeTime (h:Int, m:Int) =
    if (h<0 || h>24 || m<0|| m>60)  throw new IllegalArgumentException
    else minutes =h*60 + m
  
  def before(other:Time3):Boolean = 
    if (other.minutes > minutes) true
    else false
    
  override def toString = "jest godzina "  + minutes
}

object Time3 {
  def apply (h:Int, m:Int) = new Time3(h, m)
}

 Time3(0, 22).before(Time3(0, 33))

 
 
 



}//koniec klasy main























