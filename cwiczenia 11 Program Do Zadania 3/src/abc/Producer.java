package abc;

public class Producer extends Thread
{
    final private Produce buf;

    public Producer(String name, Produce buf)
    {
    	super(name);
    	this.buf = buf; 
    }

    @Override public void run()
    {
      for (int i = 1; i <= 20; i++)
      {
         System.out.println(getName()+" zrobił "+i);
         buf.put(i);
      }
    }//koniec run
}//koniec metody

