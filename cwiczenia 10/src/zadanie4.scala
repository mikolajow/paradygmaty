

class zadanie4
{
  
  
// Sequences are special cases of iterable collections of class Iterable. 
  import scala.collection.mutable
  
  def copy[T](dest: mutable.Seq[T], src: Seq[T]):Unit =
  {
    if(dest.length >= src.length)
    {
      var i=0
      src.foreach(e =>
        {
          dest.update(i, e)
          i = i+1
        })
    }//koniec if
  }//koniec copy
  
  val testDest = mutable.ListBuffer(1,2,3)
  testDest
  val testSrc = List(4,5,6)
  copy(testDest, testSrc)
  testDest
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}