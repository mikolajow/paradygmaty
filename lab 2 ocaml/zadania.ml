


(* ZADANIE 1 ------------------------------------ *)


let podzielWgMod(xs,n)=
	let rec licz(main, lista1,lista2,n)=
		match (main,n) with
		| ([],_) -> (List.rev lista1,List.rev lista2)
		| (_,x) when x<=1 -> failwith "wyjatek"
		| (h::t,_) -> if (h mod n) = 0 then licz(t,h::lista1,lista2,n) else licz(t,lista1,h::lista2,n)
	in licz(xs,[],[],n);;

podzielWgMod([1;8;9;5;12;2],3);;




(* ZADANIE 2 -------------------------------------- *)


let coNty ( xs, n ) =
	let rec licz (xs,index, lista, n) =
		if n <= 0 then []
		else
		match (xs,n) with
		| ([],_) -> List.rev lista
		| (h::t,_) -> if (index mod n) = 0 then licz(t,index+1,h::lista, n) else licz(t,index+1,lista, n)
 in licz(xs,1,[],n);;

coNty([1;3;5;7;0;2;4],2);;












