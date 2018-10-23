

class zadania {
  
  //ZADANIE 1

  def curry3[A,B,C,D](f:(A, B, C) => D) = (a:A) => (b:B) => (c:C) => f(a,b,c):D
  
  def add (a:Int, b:Int, c:Int):Int = a+b+c
  
  //add(1,2,3)
  
  val funkcja = curry3(add)(1)
  funkcja (2)(3)
  


  
  def uncurry3[A,B,C,D] (f:A=>B=>C=>D) = (a:A, b:B, c:C) => f(a)(b)(c)
  
  def plus(a:Int) (b:Int) (c:Int):Int = a+b+c
  
  val zwin = uncurry3(plus)(1,2,3)


  
  
  
  
  //ZADANIE
  
  def sumProd(xs:List[Int]) = xs.foldLeft(0,1)((acc,i)=>(acc._1 +i, acc._2*i))
  
sumProd(List(1,2,3,4))
  


//INSERTION@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

def insertionSortint(xs:List[Int]):List[Int] = {
    
    def insert(acc:List[Int],elem:Int):List[Int] = {
      acc match {
      case List() => List(elem)
      case h::t => if (elem >= h) h::insert(t,elem) else elem::acc
      }//koniec match
    }//koniec insert
    
    def sort(xs:List[Int],acc:List[Int]):List[Int] = {
      xs match {
      case List() => acc
      case h::t => sort(t,insert(acc,h)) 
      }//koniec match
    }//koniec sort
    
    sort(xs,List())
    
}//koniec insertionsort

  
  insertionSortint(List(2,5,1,3,9,7,7,3))
  
  
  
  
  
  def insertionSort[A](order:(A,A)=>Boolean , xs:List[A]):List[A] = {
    
    def insert(acc:List[A],elem:A):List[A] = {
      acc match {
      case List() => List(elem)
      case h::t => if (  order(elem,h)  /*elem >= h*/  ) h::insert(t,elem) else elem::acc
      }//koniec match
    }//koniec insert
    
    def sort(xs:List[A],acc:List[A]):List[A] = {
      xs match {
      case List() => acc
      case h::t => sort(t,insert(acc,h)) 
      }//koniec match
    }//koniec sort
    
    sort(xs,List())
    
}//koniec insertionsort
  
    insertionSort( (a:Int,b:Int)=> a >= b , List(2,5,1,3,9,7,7,3))
  
  
  
  
  //MERGE SORT
    
    
    def mergeSortint(xs:List[Int]):List[Int] = {
      
      def split(acc:List[Int],xs:List[Int],n:Int):(List[Int],List[Int]) = {  //n jest iloscia elementow w pierwszej czesci
        (xs,n) match {
          case (_,0) => (acc,xs)
          case (_,n) if n<0 => throw new Exception("ujemny index")
          case (List(),_) => (List(),List())
          case (h::t,_) => split(h::acc,t,n-1)
        }//koniec match
      }//koniec split
        
      def merge(xs1:List[Int],xs2:List[Int]):List[Int] = {
        (xs1,xs2) match {
          case (xs,List()) => xs
          case (List(),xs) => xs
          case (h1::t1,h2::t2) => 
            if (h2 < h1) h2::merge(xs1,t2) else h1::merge(t1,xs2) 
        }//koniec match
      }//koniec merge 
        
      val n = xs.length/2
      if (n==0) xs else {  //jak pusta albo 1 element to nie trzeba sortowac
        val (xs1,xs2) = split(List(),xs,n)
        merge(mergeSortint(xs1),mergeSortint(xs2))
        
      }//koniec else
    }//koniec mrgesorta
  
  
    mergeSortint(List(2,5,1,3,9,7,7,3))
  
  
      
    
    
    
    def mergeSortInt[A](order:(A,A)=>Boolean,xs:List[A]):List[A] = {
      
      def split(acc:List[A],xs:List[A],n:Int):(List[A],List[A]) = {  //n jest iloscia elementow w pierwszej czesci
        (xs,n) match {
          case (_,0) => (acc,xs)
          case (_,n) if n<0 => throw new Exception("ujemny index")
          case (List(),_) => (List(),List())
          case (h::t,_) => split(h::acc,t,n-1)
        }//koniec match
      }//koniec split
        
      def merge(xs1:List[A],xs2:List[A]):List[A] = {
        (xs1,xs2) match {
          case (xs,List()) => xs
          case (List(),xs) => xs
          case (h1::t1,h2::t2) => 
            if (  !order(h2,h1)   /*h2 < h1*/) h2::merge(xs1,t2) else h1::merge(t1,xs2) 
        }//koniec match
      }//koniec merge 
        
      val n = xs.length/2
      if (n==0) xs else {  //jak pusta albo 1 element to nie trzeba sortowac
        val (xs1,xs2) = split(List(),xs,n)
        merge( mergeSortInt(order , xs1) , mergeSortInt(order , xs2))
        
      }//koniec else
    }//koniec mrgesorta
  
  
    mergeSortInt((a:Int,b:Int) => a>b,List(2,5,1,3,9,7,7,3))
  
  
  
  
  
    
    def mergeSort[A](order:(A,A)=>Boolean,xs:List[A]):List[A] = {
      
      def split(acc:List[A],xs:List[A],n:Int):(List[A],List[A]) = {  //n jest iloscia elementow w pierwszej czesci
        (xs,n) match {
          case (_,0) => (acc,xs)
          case (_,n) if n<0 => throw new Exception("ujemny index")
          case (List(),_) => (List(),List())
          case (h::t,_) => split(h::acc,t,n-1)
        }//koniec match
      }//koniec split
        
      def merge(xs1:List[A],xs2:List[A]):List[A] = {
        (xs1,xs2) match {
          case (xs,List()) => xs
          case (List(),xs) => xs
          case (h1::t1,h2::t2) => 
            if (  order(h2,h1)   /*h2 < h1*/) h1::merge(xs2,t1) else h2::merge(t2,xs1) 
        }//koniec match
      }//koniec merge 
        
      val n = xs.length/2
      if (n==0) xs else {  //jak pusta albo 1 element to nie trzeba sortowac
        val (xs1,xs2) = split(List(),xs,n)
        merge( mergeSort(order , xs1) , mergeSort(order , xs2))
        
      }//koniec else
    }//koniec mrgesorta

  
  
    mergeSort((a:Int,b:Int) => a>b,List(2,5,1,3,9,7,7,3))
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}//koniec klasy



















