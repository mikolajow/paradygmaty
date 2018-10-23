

let rec quicksort = function
 [] -> []
 | [x] -> [x]
 | xs -> let small = List.filter (fun y -> y < List.hd xs ) xs
 				 and large = List.filter (fun y -> y >= List.hd xs ) xs
				 in quicksort small @ quicksort large;;

quicksort [33;77];;


let rec quicksort' = function
 [] -> []
 | x::xs -> let small = List.filter (fun y -> y < x ) xs
					 	and large = List.filter (fun y -> y >= x ) xs
						in quicksort' small @ (x :: quicksort' large);;


quicksort' [22;33;77;22;22;11;55];;

let xs = [33;22;44;55];;
let small = List.filter (fun y -> y < List.hd xs ) xs
let large = List.filter (fun y -> y >= List.hd xs ) xs



(* ZADANIE 2 CURRY3 I UNCURRY3 *)


let curry3 f x y z = f(x,y,z);;

let add(x,y,z) = x+y+z;;

let funkcja = curry3 add 2 2;;

funkcja 2;;


(* UNCURRY *)

let uncurry3 f (x,y,z) = f x y z ;;

let plus x y z = x+y+z;;

let funkcja1 = uncurry3 plus;;

funkcja1 (1,1,2);;



(* 	ZADANIE 3 *)


let sumProd xs =
	List.fold_left (fun (acc1, acc2) x -> acc1 + x, acc2 * x)  (0,1) xs;;

sumProd [1;2;3;4];;



(* ZADANIE 5 *)

let insertionSort order xs = 
	
	let rec insert acc elem = 
		match acc with
		| [] -> [elem]
		| h::t -> if  order elem h then h::insert t elem else elem::acc 
	
	and sort xs acc =
		match xs with
		| [] -> acc
		| h::t -> sort t (insert acc h)

	in sort xs [];;


    insertionSort (fun x y -> x >= y) [2;5;1;3;9;7;7;3;2];;




let rec mergeSort order xs =
	
	let rec split acc xs n =
		match (xs, n) with
		| (_,0) -> (acc, xs)
		| (_,n) when n<0 -> failwith "cos nie tak"
		| ([], _) -> ([],[])
		| (h::t, _) -> split (h::acc) t (n-1)
	
	and merge xs1 xs2 =
		match (xs1,xs2) with 
		| (xs, []) -> xs
		| ([], xs) -> xs
		| (h1::t1, h2::t2) -> if order h2 h1 then h1::merge xs2 t1 else h2::merge t2 xs1
	
	
	in let n = (List.length xs)/2
	in if n = 0 then xs else 
	 let (xs1, xs2) = split [] xs n
	in merge (mergeSort order xs1) (mergeSort order xs2);; 


mergeSort (fun a b -> a>=b) [2;5;1;3;9;7;7;3];;






























