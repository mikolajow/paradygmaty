package com.company;

public class B extends Thread
{
    private Counters counters;
    private int[] timeTable;

    public B(Counters c, int[] table)
    {
        this.timeTable = table;
        this.counters = c;
    }

    @Override
    public void run()
    {
        for ( int i : timeTable)
        {
            counters.getAcount();
            counters.getBcount();
            System.out.println('B');
            counters.releaseAcount();
            counters.incrementBcount();
            try { sleep(i); } catch (Exception e){e.printStackTrace();}
        }//for
    }//koniec run

}//koniec klasy