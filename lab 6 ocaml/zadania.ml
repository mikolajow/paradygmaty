


type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;


let rec lfrom k = 
	let rec help curr podst =
		LCons (curr, function () -> help (curr*podst) podst)
	in help 1 k;;


let rec ltake = function
 (0, _) -> []
 | (_, LNil) -> []
 | (n, LCons(x,xf)) -> x::ltake(n-1, xf())
;;


ltake (10, lfrom 2);;





























