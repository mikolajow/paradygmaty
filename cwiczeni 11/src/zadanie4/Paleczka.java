package zadanie4;

import java.util.concurrent.Semaphore;

public class Paleczka
{
    private Semaphore dostepnosc = new Semaphore(1);
    void wezPaleczke() throws InterruptedException
	   { dostepnosc.acquire(); }
    void release() { dostepnosc.release(); }	
}//koniec klasy paleczka






























