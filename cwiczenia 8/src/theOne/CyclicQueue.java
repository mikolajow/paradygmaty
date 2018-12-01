package theOne;

import java.util.ArrayList;

public class CyclicQueue<E> implements MyQueue<E>{
	
	private int f;
	private int r;
	private int size;
	private ArrayList<E> lista;

    public CyclicQueue(int s) {
        f = 0;
        r = 0;
        size = s + 1;
        lista = new ArrayList<>(size + 1);
        for (int i = 0; i < size; i++)
        	lista.add(null);
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull())
            throw new FullException();
        else 
        {
        	lista.set(r, x);
            r = (r+1)%size;
        }
    }

    @Override
    public void dequeue() {
        if (f != r) 
            f = (f+1)%size;
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty())
            throw new EmptyException();
        else 
            return lista.get(f);
    }

    @Override
    public boolean isEmpty() {
        return (f == r);
    }

    @Override
    public boolean isFull() {
        return (r+1)%size == f;
    }


}//end of class
