
//zadanie 3
class Pojazd (val producent:String, val model:String, val rok:Int = -1, var numerR:String = ""){
  
  def this (prod:String, mod:String, r:Int) = this(prod, mod, r, "")
  def this (prod:String, mod:String, numer:String) = this(prod, mod, -1, numer)
  
  
  object Test extends App {
  new Pojazd("Fiat", "126p", 2016, "ESI123")
  new Pojazd("Fiat", "126p", 2016)
  new Pojazd("Fiat", "126p", "ESI123")
  new Pojazd("Fiat", "126p")
  }

}







































