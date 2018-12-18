package abc;

public class ProdCons
{
   public static void main(String args[])
   {
	   final int P = 3, C = 3;
       BoundedBuffer buf = new BoundedBuffer(5);   
       Producer[] prods = new Producer[P];
       Consumer[] cons = new Consumer[C];
       for (int i=0; i<P; i++)
       {
    	   prods[i] = new Producer("Producer "+(i+1), buf);
    	   prods[i].start();
       }
       for (int i=0; i<C; i++)
       {
    	   cons[i] = new Consumer("Consumer "+(i+1),buf);
    	   cons[i].start();
       }
   }//koniec main
}//koniec klasy

/*
Jak zastąpimy notifyAll() zwykłym notify() to probram się blokuje

We should go for notify() if all your waiting threads are interchangeable - wymmienne
(the order they wake up doesn’t matter). A common example is a thread pool.
But we should use notifyAll() for other cases where the waiting threads may
have different purposes and should be able to run concurrently - współbierznie.

Nie wiemy co zostanie powiadomione, jeśli mamy pusty buffer i powaidomione zostana
po kolei wszystkie objekty konsumentow to program się zablokuje

//przykład blokady
Producer 1 wsadził: 9
5 6 7 8 9 
Producer 1 zrobił 10
Producer 2 notified
Producer 2 czeka z gotowym 5
Producer 3 notified
Producer 3 czeka z gotowym 3
Producer 1 notified
Producer 1 czeka z gotowym 10
Consumer 2 zabrał: 5
0 6 7 8 9 
Consumer 2 notified
Consumer 2 zabrał: 6
0 0 7 8 9 
Consumer 2 notified
Consumer 2 zabrał: 7
0 0 0 8 9 
Consumer 2 notified
Consumer 2 zabrał: 8
0 0 0 0 9 
Consumer 2 notified
Consumer 2 zabrał: 9
0 0 0 0 0 
Consumer 2 notified
Consumer 2 czeka żeby zabrać
Consumer 1 czeka żeby zabrać

*/









































