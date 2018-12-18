package zadanie4;
import java.util.Random;


class Uczta
{	
    public static void main(String[] args)
    {
    	int liczbaFilozofow = 5;
    	Random generator = new Random();
    	Odzwierny odzwierny = new Odzwierny(liczbaFilozofow);
    	Paleczka[] paleczki = new Paleczka[liczbaFilozofow];
        for (int i = 0; i < liczbaFilozofow; i++)
            paleczki[i] = new Paleczka();
        Filozof[] filozofowie = new Filozof[liczbaFilozofow];
        for (int i = 0; i < liczbaFilozofow; i++)
        {
            filozofowie[i] = new Filozof(i, paleczki, liczbaFilozofow, generator, odzwierny);
            filozofowie[i].start();
        }
    }//koniec maina
}//koniec klasy uczta












































