











class zadanie3
{
  

  
  class DoubleListQueue[+T](private val queue:(List[T],List[T]))
  {
    
    class Empty extends Exception
    class BadImplementation extends Exception
    
    def isEmpty():Boolean = 
      this.queue match
      {
      case (List(),List()) => true
      case(_, _) => false
      }
    
    def enqueue[U >: T](el:U) =
      this.queue match
      {
        case (List(), _) => new DoubleListQueue(List(el), List())
        case (xs, ys) => new DoubleListQueue(xs, el::ys)
      }
    
    def dequeue() = 
      this.queue match
      {
        case (List(), List()) => empty()
        case (x::Nil, ys) => new DoubleListQueue(ys.reverse,List())
        case (x::xs, ys) => new DoubleListQueue(xs, ys)
        case (_, _) => throw new BadImplementation
      }
    
    def first() =
      this.queue match
      {
        case (x::xs, _) => x
        case (List(), _) => throw new Empty
      }
    
    def empty() = new DoubleListQueue[T](List(), List())
    
  }//koniec kalsy DoubleListQueue

  
    var test = new DoubleListQueue[Int](List(), List());
    
    test.isEmpty()
    
    test = test.enqueue(1)
    test.isEmpty()
    
    test = test.enqueue(2)
    test = test.enqueue(3)
    
    test.first()
    test.first()
    
    test = test.dequeue()
  
    test.first()
    
    test = test.dequeue()
    test = test.dequeue()
    test = test.dequeue()
    
    test.first()
}//koniec zadanie 3



































