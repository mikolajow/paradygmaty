


(* ZADANIE 1 *)

let modulo (xs,n)=
	let rec licz(main, lista1, lista2, nn)=
		match (main,nn) with
		| ([],_) -> (List.rev lista1,List.rev lista2)
		| (h::t,_) -> if (h mod n) = 0 then licz(t,h::lista1,lista2,nn) else licz(t,lista1,h::lista2,nn)
	in licz(xs,[],[],n);;




modulo([1;8;9;5;12;2],3);;



(* ZADANIE 2 *)


let coNty (xs,n) =
	let rec licz(xs,n,index)=
		match (xs,n) with
		| ([],_) -> []
		| (h::t,_) -> if (index mod n) = 0 then h::licz(t,n,index+1) else licz(t,n,index+1)
		in licz(xs,n,1);;
		

coNty([1;3;5;7;0;2;4],2)









































