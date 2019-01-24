package com.company;

public class A extends Thread
{
    private Counters counters;
    private int[] timeTable;

    public A(Counters c, int[] table)
    {
        this.timeTable = table;
        this.counters = c;
    }

    @Override
    public void run()
    {
        for ( int i : timeTable)
        {
            synchronized (counters)
            {
                if (counters.Acount < counters.Bcount)
                {
                    System.out.println('A');
                    counters.Acount++;
                }//if
            }//koniec synchronized
            try { sleep(i); } catch (Exception e){e.printStackTrace();}
        }//for
    }//koniec run
}//koniec klasy
