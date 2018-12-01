public class Test
{

    int zawartość = 0;
    
    static void argNiemodyfikowalny(final Test zmienna)
    {
        zmienna.zawartość = 1;
        //nie mozna modyfikowac zmiennej ustawionej na final
        //trzeba wiec usunac te linijke
        //zmienna = null;
    }
    
    static void argModyfikowalny(Test zmienna)
    {
        zmienna.zawartość = 1;
        zmienna = null;
    }
    
    public static void main(String[] args)
    {
        
        Test modyfikowalna = new Test();
        final Test niemodyfikowalna = new Test();
        
        /*
        argNiemodyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartość); //wynik to 1
        */
        
        /*
       argNiemodyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartość); // wynik to 1
        */
        
        /*
       argModyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartość); //wynik to 1
        */
        
        
       argModyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartość); // wynik to 1 
        
        /*
        java uzywa przekazywania przez wartosc to znaczy ze do funkcji przekazujemy kopje referencji do objektu
        final Test niem = new Test(); tworzy niemodyfikowalna referencje, co nie znaczy jednak ze objekt jest 
        niemodyfikowalny, wrecz przeciwnie, czego jestesmy swiadkami w obecnym zadaniu
        */  
        
    }//koniec main
}//koniec klasy




