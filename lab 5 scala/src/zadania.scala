

class zadania {
  
  
  
sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val tt = 
Node(1,
      Node(2,
            Node(4,
                  Empty,
                  Empty
                ),
            Empty
          ),
      Node(3,
            Node(5,
                   Empty,
                   Node(6,
                          Empty,
                          Empty
                       )
                 ),
             Empty
           )
     ) 
  
  
  def withOneChild [A](bt:BT[A]):Int = {
    bt match 
    {
      case Empty => 0
      case Node(e, l, r) => (l, r) match{
                                      case (Empty, Node(_,_,_)) => 1 + withOneChild (r)
                                      case (Node(_,_,_), Empty) => 1 + withOneChild (l)
                                      case (Empty, Empty) => 0
                                      case (_, _) => withOneChild (l) + withOneChild (r)
                                    }//drugie match
      
    }//koniec match 
}//koniec metody
  
  
  withOneChild (tt)
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}