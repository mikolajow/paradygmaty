package abc;

import java.util.ArrayList;

public class InfiniteStack<T> implements MyStack<T>
{

	private ArrayList<T> a;
	
	public InfiniteStack()
	{
		this.a = new ArrayList<T>();
	}
	
	
	public void push(T elem)
	{
		a.add(elem);
	}

	public T pop() throws Empty
	{
		if(a.size() == 0)
			throw new Empty();
		T current = a.get(a.size()-1);
		a.remove(a.size()-1);
		return current;
	}

	public T top()
	{
		return a.get(a.size()-1);
	}

	public String toString()
	{
		String result = "";
		
		for(int i=0;i<a.size();i++)
			result = result + a.get(i) + ",";
		
		return result;
	}
}//koniec klasy













