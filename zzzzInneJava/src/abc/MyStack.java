package abc;

public interface MyStack<T>
{
	public void push(T elem) throws Full;
	public T pop() throws Empty;
	public T top();
}
