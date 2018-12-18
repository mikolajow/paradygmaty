package abc;

public class BoundedBuffer implements Produce, Consume
{
	
    final private int N;
    private int in = 0;		//index pod ktory wpiszemy nastepny
    private int	out = 0;	//index nastepnego do pobrania
    private int	n = 0;		//ile jest obecnie w buforze
    private int[] elems;

    public BoundedBuffer(int N)
    {
        this.N = N;
        elems = new int[N]; 
    }

    public synchronized void put(int x)
    {
    	
        //System.out.println(Thread.currentThread().getName()+" notified");
        
        while (n >= N)
        {
        	try
        	{
        		System.out.println(Thread.currentThread().getName()+" czeka z gotowym " + x); 
        	  	wait(); 
        	}
        	catch (InterruptedException e) {System.out.println(e);}
        }
        elems[in] = x;
        in = (in + 1) % N ;
        n += 1;
        System.out.println(Thread.currentThread().getName()+" wsadził: " + x  + "\n" + toString());
        if (n == 1)
        	//notify();
        	notifyAll();
    }

    public synchronized int take()
    {
    	
       // System.out.println(Thread.currentThread().getName()+" notified");
    	
        while (n == 0)
        {
          try
          {
        	  System.out.println(Thread.currentThread().getName()+" czeka żeby zabrać"); 
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}
        }
        
        
        int x = elems[out];
        elems[out] = 0;
        out = (out + 1) % N;
        n -= 1;
        System.out.println(Thread.currentThread().getName()+" zabrał: " + x + "\n" + toString());
        if (n == N-1)
        	//notify();
        	notifyAll();
        return x;
    }
    
    public String toString()
    {
    	String resoult = "";
    	
    	for (int e : elems)
    		resoult += e + " ";
    	
    	return resoult;
    }
    
}//koniec klasy









































