class main{
  
//zadanie 1 a
class Time (var h:Int ) {
  if (h<0) h=0
  def changeH (n:Int) = if (n<0) h=0 else h=n
  override def toString = "jest godzina " + h
}
//b
object Time {
  def apply (h:Int) = new Time(h)
}

 Time(44)

 
 
 



}//koniec klasy main































