









let moduloList xs n =
	List.filter	(fun x -> (x mod n) = 0) xs;;



moduloList[1;2;3;4;5;6;7;8;9] 3;;


let (+++) a b =
	let rec licz a b =
		match (a,b) with
		| (0, _) -> failwith "zero"
		| (_, 0) -> failwith "zero"
		| (a,b) when a=b -> a
		| (_, _) -> if a>b then licz(a-b) b else licz a (b-a)
	in licz a b;;

22+++11;;


















