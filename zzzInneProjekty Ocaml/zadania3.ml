



let moduloList xs a =
	List.filter (fun x -> x mod a = 0) xs;;


moduloList[1;10;7;8;15] 5;;






let (+++) x y = 
	let rec licz x y =
		match (x,y) with
		| (0, _) -> failwith "zero"
		| (_, 0) -> failwith "zero"
		| (x, y) when x=y -> x
		| (_, _) -> if x>y then licz (x-y) y else licz x (y-x)
	in licz x y;;



16+++88;;




































