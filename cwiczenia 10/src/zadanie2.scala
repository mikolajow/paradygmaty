




//2. Poniższa definicja powoduje błąd kompilacji.
abstract class Sequence[+A] {
 def append[ASub >: A](x: Sequence[ASub]): Sequence[ASub]
}
// <console>:14: error: covariant type A occurs in contravariant position in type
// Sequence[A] of value x


//Wyjaśnij przyczynę tego błędu. Czy można się go pozbyć?.

/*



Wykład:

Operator G jest kowariantny (ang. covariant), jeśli S<:T
implikuje G[S] <: G[T]

znaczy to że funkcja append (skoro jest kowariantna) musi zadziałać dla każdego
nadtypu typu A ( ASub >: A ), jeśli podamy jako argument metody nadtyp typu A
to zwrócona sekwencja musi być podanego nadtypu (ASub) np.
mamy sekwencje kotów (A) i do sekwencji dodajemy zwierze (ASub),
otrzymana sekwencja musi wiec byc typu zwierze (ASub)
(nie chcemy kupic kota a na drugi dzień dostać w twarz od szympansa xD)

Jak się pozbyć? :

abstract class Sequence[+A] {
 def append[ASub >: A](x: Sequence[ASub]): Sequence[ASub]
}



*/






































