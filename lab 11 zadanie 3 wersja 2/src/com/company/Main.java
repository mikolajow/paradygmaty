package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {

        Random generator = new Random();
        Counters c = new Counters();
        int timesNumber = 10;
        int[] table = new int[timesNumber];

        int Anumber = 40;
        int Bnumber = 40;

        ArrayList<A> Alist = new ArrayList<>();
        ArrayList<B> Blist = new ArrayList<>();

        for(int i = 0; i<Anumber; i++)
        {
            int[] temp = new int[timesNumber];
            for(int j = 0; j< temp.length; j++)
            {
                table[j] = generator.nextInt(100);
            }
            Alist.add(new A(c, temp));
        }


        for(int i = 0; i<Bnumber; i++)
        {
            int[] temp = new int[timesNumber];
            for(int j = 0; j< temp.length; j++)
            {
                table[j] = generator.nextInt(1000000);
            }
            Blist.add(new B(c, temp));
        }

        // for(A a : Alist)
        //     a.start();

        for(B b : Blist)
            b.start();

        for(A a : Alist)
            a.start();

        try
        {
            for(A a : Alist)
                a.join();

            for(B b : Blist)
                b.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("liczba A = " + c.Acount + " liczba B = " + c.Bcount);



    }//koniec maina
}//koniec klasy
