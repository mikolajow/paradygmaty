

class zadania {
  

  
  
  sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

  
  
val t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty)


def nodes[A](bt:BT[A]):Int = bt match {
case Empty => 0
case Node(_, tl, tr) => 1 + nodes(tl) + nodes(tr)
}

  
  
nodes(t)

  
  
  
  
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
  


  nodes(tt)
  
  
  
  
  
 def breadthBT [A](tree:BT[A]):List[A] = {
   def helper(list:List[BT[A]]):List[A] =
     list match {
     case List() => List()
     case Empty::tail => helper(tail)
     case Node(x, left, right)::tail => x::helper( tail:::List(left, right) )
    }//koniec match
  
  helper(List(tree))
  
}//koniec metody
  
  
  breadthBT (tt)
  
  
  
  
  def dlugoscWewnetrznej [A](tree:BT[A]) ={
    
    def licz (tree:BT[A], glebokosc:Int):Int =
      tree match {
      case Empty => 0
      case Node(root, left, right) => glebokosc + licz(left, glebokosc+1) + licz(right, glebokosc+1)
    }//koniec match
    
    licz (tree, 0)
    
  }//koniec metody
    
  
  dlugoscWewnetrznej(tt)
  
  
  
  
  
  def dlugoscZew [A](tree:BT[A]) = {
	 def licz (tree:BT[A], glebokosc:Int):Int =
		tree match {
	   case Empty => glebokosc
	   case Node(root, l, r) =>  licz (l, glebokosc+1) + licz (r, glebokosc+1)
	 }//koniec match
	licz (tree, 0)
  }//koniec metody

dlugoscZew (tt);;



  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}//koniec klasy

















