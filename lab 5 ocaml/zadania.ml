
(*  ZADANIE 1   *)
type heteroList = I of int | F of float;;

let intList = [1;2;3;4];;

let floatList = [5.;6.;7.;8.];;

let heteroList = (List.map (function x -> I x) intList) @ (List.map (function x -> F x) floatList);;

let listt = [I 1; F 2.; I 3; F 4.]

let rozdziel xs = 
	let rec help xs acc =
		match xs with 
		| []-> (List.rev (fst(acc)), List.rev (snd(acc)) )
		| h::t -> match (h, acc) with
							| (I intt, (inty, floaty) ) -> help t (intt::inty, floaty)
							| (F floa, (inty, floaty)) -> help t (inty, floa::floaty)
		in help xs ([], []);;


rozdziel heteroList;;
rozdziel listt;;




(*  ZADANIE 2   *)


exception Brak_towaru;;

type product = { nazwa : string; cena : float; ilosc : int };;

let banan = { nazwa= "banan"; cena=1.2; ilosc=100 };;
let truskawka ={ nazwa="truskawka"; cena=0.2; ilosc=1000 };;
let gruszka ={ nazwa="gruszka"; cena=5.0; ilosc=60 };;
let kiwi={ nazwa="kiwi"; cena=1.5; ilosc=30 };;
let pomarancza={ nazwa="pomarancza"; cena=2.0; ilosc=150 };;


let lista = [banan; truskawka; gruszka; kiwi; pomarancza ];;


(* PREDYKAT  *)
let drozszeNiz = fun nizIle x -> if x.cena > nizIle then true else false;;
let drozszeNiz1 = drozszeNiz 2.5 ;;


let czyJest xs =
	let list = List.filter drozszeNiz1 xs in
	match list with
	| [] -> raise Brak_towaru
	| h::t -> h;;


czyJest lista;;


let pokazJesliJest xs =
	try (czyJest xs).nazwa with
	| Brak_towaru -> "nie ma towaru";;


pokazJesliJest lista;


















