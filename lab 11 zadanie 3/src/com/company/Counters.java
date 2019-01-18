package com.company;

public class Counters {

    private  int Acount =0;
    private  boolean AUpdated=true;
    private  boolean BUpdated=true;
    private  int Bcount =0;

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
        BUpdated = true;
        notifyAll();
    }


}//koniec klasy
