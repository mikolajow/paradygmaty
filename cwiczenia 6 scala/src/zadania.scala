class zadania {
  
  
def whileLoop(warunek: =>Boolean) (wyrazenie: =>Unit): Unit =
  if (warunek) {
    wyrazenie
    whileLoop(warunek) (wyrazenie)
  }

var i = 0
whileLoop(i < 5) {
  println(i)
  i = i + 1
}

  
  // QUICKSORT


def swap (tab:Array[Int], i:Int, j:Int) = {
  val temp = tab(i); tab(i) = tab(j); tab(j) = temp
}
  
  
  def partition (tab:Array[Int], l:Int, r:Int) ={
    var i = l
    var j = r
    var pivot = tab((l+r)/2)
    while (i <= j)
    {
      while (tab(i) < pivot) i=i+1
      while (pivot < tab(j)) j=j-1;
      if (i <= j) swap (tab, i, j); i=i+1; j=j-1
    }
  (i,j)
  }//koniec partition
  
  
  def quick (tab:Array[Int], l:Int, r:Int):Unit =
{
  if (l < r)
  {
    val (i, j) = partition(tab, l, r)
    if (j - l < r - i)
    {
      val _ = quick(tab, l, j)
      quick(tab, i, r)
    }
    else
    {
      val _ = quick(tab, i, r)
      quick(tab, l, j)
    }
  }
}//koniec metody  
  
  def quicksort (tab:Array[Int]) = quick (tab, 0, tab.length-1)
  
  
  
  val a = Array(3,2,8,1,9,5,33)
  quicksort (a)
  a


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}