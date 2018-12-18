

class GenericCellImm[T] (val x: T) {
}
//defined class GenericCellImm


/*
class GenericCellImm[+T] (val x: T) {
}
//defined class GenericCellImm

*/


//class GenericCellMut[-T](var x: T) {
//}

/*

Powodem błędu jest pole "x", a mianowicie fakt że jest to pole
var (mutable/modyfikowane)

pola modyfikowane mogą być wyłącznie invariant/nonvariant
więc jedyne co możemy zrobić aby kod się kompilował to 
usunięcie "+" przy typie "T" lub zmienienie pola x na niemodyfikowane val
analogicznie wersja kontrwariantna metody się nie skompiluje

contravariant type T occurs in covariant position in type => T of variable x

fragment wykładu 10:

Rozważmy generyczną kolekcję, w której typ elementów jest jedynym parametrem.
Zwykle taki parametr może być kowariantny tylko wtedy, kiedy kolekcja jest wyłącznie
do odczytu, czyli ma tylko metody
pobierające wartości jej elementów (getters); może on być kontrawarianty tylko wtedy,
kiedy kolekcja jest wyłącznie do zapisu, czyli ma
tylko metody zmieniające wartości jej elementów (setters). Jeśli dopuszczalne są
zarówno operacje odczytu, jak i zapisu, to kolekcja musi być inwariantna.

WIKI : 

Read-only data types (sources) can be covariant; write-only data types (sinks) can be
contravariant. Mutable data types which act as both sources and sinks should be
invariant. To illustrate this general phenomenon, consider the array type.
For the type Animal we can make the type Animal[], which is an "array of animals".
For the purposes of this example, this array supports both reading and writing elements.

We have the option to treat this as either:

Covariant: a Cat[] is an Animal[]
Contravariant: an Animal[] is a Cat[]
Invariant: an Animal[] is not a Cat[] and a Cat[] is not an Animal[]
If we wish to avoid type errors, then only the third choice is safe.
Clearly, not every Animal[] can be treated as if it were a Cat[],
since a client reading from the array will expect a Cat, but an Animal[] may
contain e.g. a Dog. So the contravariant rule is not safe.

Conversely, a Cat[] cannot be treated as an Animal[]. It should always be
possible to put a Dog into an Animal[]. With covariant arrays this cannot be
guaranteed to be safe, since the backing store might actually be an array of
cats. So the covariant rule is also not safe—the array constructor should be
invariant. Note that this is only an issue for mutable arrays; the covariant
rule is safe for immutable (read-only) arrays.


*/











