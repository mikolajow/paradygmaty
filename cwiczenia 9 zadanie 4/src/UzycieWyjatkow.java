












// Demonstracja wykorzystania metod getMessage i printStackTrace,
// dziedziczonych przez wszystkie klasy wyjatkow.

public class UzycieWyjatkow
{
 
	public static void main( String args[] )
	{
		try
		{
			metoda1();
		} 
		catch ( Exception e ) {
			System.err.println( e.getMessage() + "\n" );
			e.printStackTrace();
		}
	}//koniec main
 
 
 public static void metoda1() throws Exception
 {
	 metoda2();
 }
 
 
 public static void metoda2() throws Exception
 {
	 metoda3();
 }
 
 
 public static void metoda3() throws Exception
 {
	 throw new Exception( "Wyjatek zgloszony w metoda3" );
 }
 
 
 
 
}//koniec klasy














