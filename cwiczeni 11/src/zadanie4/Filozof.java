package zadanie4;

import java.util.Random;

public class Filozof extends Thread
{
        private Paleczka lewaPaleczka;
        private Paleczka prawaPaleczka;
        private Random generator;
        private Odzwierny odzwierny;
        
        Filozof(int numer, Paleczka[] paleczki, int liczbaFilozofow, Random generator, Odzwierny odzwierny)
        {
            super("Filozof " + numer);
            this.odzwierny = odzwierny;
            this.generator = generator;
            prawaPaleczka = paleczki[numer];
            lewaPaleczka = paleczki[(numer + 1) % liczbaFilozofow];
        }
        void medytuj() throws InterruptedException
        {
            System.out.println(getName() + " medytuje");
            sleep(generator.nextInt(100));
            System.out.println(getName() + " skonczyl medytowac");
            jedz();
        }
        void jedz() throws InterruptedException
        {
            odzwierny.acquire();
            lewaPaleczka.wezPaleczke();
            prawaPaleczka.wezPaleczke();
            System.out.println(getName() + " zaczyna jesc");
            sleep(generator.nextInt(10000));
            lewaPaleczka.release();
            prawaPaleczka.release();
            odzwierny.release();
            System.out.println(getName() + " skonczyl jesc");
            medytuj();
        }
        @Override
        public void run()
        {
            try { medytuj(); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
}//koniec klasy filozof
