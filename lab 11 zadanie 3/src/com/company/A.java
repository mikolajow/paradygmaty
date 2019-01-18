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
            if (counters.getAcount() < counters.getBcount())
            {
                System.out.println('A');
                counters.incrementAcount();
                counters.releaseBcount();
            }//if
            else
            {
                counters.releaseAcount();
                counters.releaseBcount();
            }
            try { sleep(i); } catch (Exception e){e.printStackTrace();}
        }//for
    }//koniec run

}//koniec klasy
