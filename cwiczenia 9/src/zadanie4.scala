

class zadanie4
{
  

    def metoda1()= metoda2
    def metoda2() = metoda3
    def metoda3() = throw new Exception("Wyjatek zgloszony w metoda3")

    metoda1()
    
      /*
 java.lang.Exception: Wyjatek zgloszony w metoda3
  at .metoda3(<console>:19)
  at .metoda2(<console>:18)
  at .metoda1(<console>:17)
  ... 48 elided
    */

}