package abc;

import java.util.ArrayList;


public class FiniteStack<T> implements MyStack<T>
{
	
	private T[] a;
	private int size;
	private int currentIndex;
	
	public FiniteStack(int size)
	{
		this.currentIndex = 0;
		this.size = size;
		this.a = (T[]) new Object[size];
	}

	
	public void push(T elem) throws Full
	{
		if(currentIndex == size)
			throw new Full();
		else
		{
			a[currentIndex] = elem;
			currentIndex++;
		}
	}//koniec push

	public T pop() throws Empty
	{
		if(currentIndex == 0)
			throw new Empty();
		currentIndex--;
		return a[currentIndex];
	}

	public T top()
	{
		return a[currentIndex-1];
	}
	
	public String toString()
	{
		String result = "";
		
		for(int i=0;i<size;i++)
			result = result + size + ",";
		
		return result;
	}
	
}

































