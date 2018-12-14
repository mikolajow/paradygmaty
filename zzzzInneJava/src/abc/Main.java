package abc;

public class Main
{
	
	static void append(MyStack<Integer> destination, MyStack<Integer> source)
	{
		InfiniteStack<Integer> temp = new InfiniteStack<>();
		try
		{
			while(true)
				temp.push(source.pop());
		}
		catch (Exception e) {}
		
		try
		{
			while(true)
				destination.push(temp.pop());
		} catch (Exception e) {}
		
	}//koniec append
	
	public static void main(String[] args)
	{
		
		
		InfiniteStack<Integer> inf = new InfiniteStack<>();
		FiniteStack<Integer> fin = new FiniteStack<>(3);
		
		inf.push(1);
		inf.push(2);
		inf.push(3);
		System.out.println(inf.toString());
		
		try
		{
			fin.push(4);
			fin.push(5);
			fin.push(6);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		Main.append(inf, fin);
		
		System.out.println(inf.toString());
		
	}//koniec main
}//koniec klasy




































