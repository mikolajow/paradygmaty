
(*PIERWSZE*)
type numerek = I of int | F of float;;

let makeInt = fun x -> I x;;
let makeFloat = fun x -> F x;;

let intList = [1;2;3;4;5];;
let floatList = [6.;7.;8.;9.];;

let heteroList = (List.map makeInt intList) @ (List.map makeFloat floatList) ;;


let rozdziel xs = 
	let rec help xs acc =
		match xs with 
		| []-> (List.rev (fst(acc)), List.rev (snd(acc)) )
		| h::t -> match (h, acc) with
							| (I intt, (inty, floaty) ) -> help t (intt::inty, floaty)
							| (F floa, (inty, floaty)) -> help t (inty, floa::floaty)
		in help xs ([], []);;


rozdziel heteroList;;



(*DRUGIE*)

type product = { nazwa : string; cena : float; ilosc : int };;

let banan = { nazwa= "banan"; cena=1.2; ilosc=100 };;
let truskawka ={ nazwa="truskawka"; cena=0.2; ilosc=1000 };;
let gruszka ={ nazwa="gruszka"; cena=5.0; ilosc=60 };;
let kiwi={ nazwa="kiwi"; cena=1.5; ilosc=30 };;
let pomarancza={ nazwa="pomarancza"; cena=2.0; ilosc=150 };;


let lista = [banan; truskawka; gruszka; kiwi; pomarancza ];;



(* PREDYKAT  *)
let drozszeNiz = fun nizIle x -> if x.cena > nizIle then true else false;;
let drozszeNiz1 = drozszeNiz 1.;;




let czyJest xs =
	let list = List.filter drozszeNiz1 xs in
	match list with
	| [] -> failwith "nie ma"
	| h::t -> h;;

let wyswietlJesliJest xs =
	match xs with
	| [] -> "nie ma takiego"
	| h::t -> h.nazwa;;


wyswietlJesliJest lista;;


















