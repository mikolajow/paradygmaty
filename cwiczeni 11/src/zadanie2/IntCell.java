package zadanie2;

import java.util.concurrent.Semaphore;

/*		ZADANIE 2 NA SEMAFORACH

class IntCell
{
	 private int n = 0;
	 private Semaphore available = new Semaphore(1);
	 public synchronized int getN()
	 {
		 try{ available.acquire();}
		 catch (Exception e) {e.printStackTrace();}

		 return getIfPossible();
	 }
	 private int getIfPossible() { return n; }
	 public void setN(int n)
	 {
		 this.n = n;
		 available.release();
	 }
}//koniec klasy
*/




//		ZADANIE 2 NA MONITORACH


class IntCell
{
	 private int n = 0;
	 private boolean isUpdate = true;
	 
	 public synchronized int getN()
	 {
		 while(!isUpdate)
			 try { wait(); } catch (Exception e) {e.printStackTrace();}
		 isUpdate = false;
		 //notifyAll(); zbędne 
		 return n;
	 }
	 public synchronized void setN(int n)
	 {
		 while(isUpdate)
			 try
		 {	//nigy nie wchodze w tego try`a
			System.out.println("nigdy tu nie zawitam");
			wait(); 
		 } catch (Exception e) {e.printStackTrace();}
		 this.n = n;
		 isUpdate = true;
		 notifyAll();
	 }
	 
}//koniec klasy



class Count extends Thread
{
	private static IntCell n = new IntCell();
	
	 @Override public void run()
	 {
		int temp;
	 	for (int i = 0; i < 200000; i++)
	 	{
	 		temp = n.getN();
	 		n.setN(temp + 1);
	 	}
	 }//koniec run
	 
	 public static void main(String[] args)
	 {
		Count p = new Count();
		Count q = new Count();
		p.start();
		q.start();
		try
		{
			p.join();
			q.join();
		}
		catch (InterruptedException e)
		{ 
			e.printStackTrace();
		}
		
		System.out.println("The value of n is " + n.getN());
	 }//koniec main
	 
}//koniec klasy count

//przykladowe wyniki przed poprawą : 312569, 235468, 327321






































