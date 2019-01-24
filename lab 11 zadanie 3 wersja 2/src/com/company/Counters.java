package com.company;

public class Counters
{


    public int Acount = 0;
    public int Bcount = 0;

    /*
    private  boolean AUpdated=true;
    private  boolean BUpdated=true;

    /*
    public synchronized int getAcount()
    {
        while (!AUpdated)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        check();
        AUpdated = false;
        notifyAll();
        return Acount;
    }

    public synchronized int getBcount()
    {
        while (!BUpdated)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        check();
        BUpdated = false;
        notifyAll();
        return Bcount;
    }

    public synchronized void incrementBcount()
    {
        while (BUpdated)
        {
            try
            {
                System.out.println();
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        Bcount++;
        check();
        BUpdated = true;
        notifyAll();
    }

    public synchronized void incrementAcount()
    {
        while (AUpdated)
        {
            try
            {
                System.out.println();
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        Acount++;
        check();
        AUpdated = true;
        notifyAll();
    }

    public synchronized void releaseAcount()
    {
        while (AUpdated)
        {
            try
            {
                System.out.println();
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        check();
        AUpdated = true;
        notifyAll();
    }

    public synchronized void releaseBcount()
    {
        while (BUpdated)
        {
            try
            {
                System.out.println();
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        check();
        BUpdated = true;
        notifyAll();
    }

    private void check()
    {
        if(Acount > Bcount)
        {
            System.out.println("BŁĄD");
        }
    }
    */


}//koniec klasy
