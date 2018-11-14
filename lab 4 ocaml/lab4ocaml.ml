
(* LISTA 4 ZADANIE 1 *)

let f = fun (xss, (xs, last)) elem -> if elem >= last then (xss, (xs@[elem], elem))
	else (xss @ [xs], ([elem], elem));;


let result =  f ([], ([1;2;3], 3)) 2;;


let listyNiemalejace lista = 
	let result = List.fold_left f ([], ([], 0)) lista
	in fst(result) @ [fst (snd(result))];;


listyNiemalejace [1;4;3;2;5;6];;



(* LISTA 4 ZADANIE 2 *)

let rec dodaj elem ileRazy xs =
	match ileRazy with
	| 0 -> xs
	| _ -> elem::dodaj elem (ileRazy-1) xs;;

dodaj 2 3 [5;5;5];;


let f = fun (xs, ile) nominal ->
	match ile with
	| 0 -> (xs, ile)
	| _-> (dodaj nominal (ile/nominal) xs, ile - (ile/nominal)*nominal );;
	 


let wydaj ile nominaly =
	let result = List.fold_left f ([], ile) nominaly
	in List.rev (fst(result));;


wydaj 69 [50;20;10;5;2;1];;

















