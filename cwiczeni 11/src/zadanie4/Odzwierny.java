package zadanie4;

import java.util.concurrent.Semaphore;

public class Odzwierny
{
    private Semaphore available; 
	public Odzwierny(int ileMiejsc)
	{ this.available = new Semaphore(ileMiejsc, true); }
	public void acquire() { try{available.acquire();} catch(Exception e){e.printStackTrace();}}
	public void release() {available.release();}
}//koniec klasy odzwierny
































