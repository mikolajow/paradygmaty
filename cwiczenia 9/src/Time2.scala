class main2{


  class IllegalArgumentException extends Exception{  }
  
//zadanie 2 a
class Time2 (var hour:Int, var minute:Int ) {
  if (hour<0 || hour > 24 || minute < 0 || minute > 60) throw new IllegalArgumentException
  
  def changeTime (h:Int, m:Int) =
    if (h<0 || h>24 || m<0|| m>60)  throw new IllegalArgumentException
    else {hour = h; minute = m}
  
  def before(other:Time2):Boolean = 
    if (other.hour > hour) true
    else if (other.hour == hour && other.minute > minute) true
    else false
    
  override def toString = "jest godzina " + hour +" " + minute
}

object Time2 {
  def apply (h:Int, m:Int) = new Time2(h, m)
}

 Time2(24, 22).before(Time2(0, 33))

 
 
 



}//koniec klasy main
















