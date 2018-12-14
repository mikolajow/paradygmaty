class MyStack[+T] private (private val rep: List[T])
{
  
 def push[S >: T](x: S) = new MyStack(x::rep)
 {
   
 }// push: S => MyStack[S]
 
// poprzednio było push: T => MyStack[T]
}