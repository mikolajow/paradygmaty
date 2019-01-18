package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

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

        System.out.println("liczba A = " + c.getAcount() + " liczba B = " + c.getBcount());



        /* TEST 1
        for (int i=0; i<table.length; i++)
        {
            table[i] = 1;
        }

        A watek1 = new A(c, table);
        A watek3 = new A(c, table);
        B watek2 = new B(c, table);

        watek1.start();
        watek2.start();
        watek3.start();

        try
        {
            watek1.join();
            watek2.join();
            watek3.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("liczba A = " + c.getAcount() + " liczba B = " + c.getBcount());
        */
    }//koniec maina
}//koniec klasy
