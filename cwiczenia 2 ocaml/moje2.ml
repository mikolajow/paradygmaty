


let rec fibbo n =
	match n with
	| 0 -> 0
	| 1-> 1
	| _->fibbo(n-1) + fibbo(n-2);;


fibbo 9;;


let fibo n =
	let rec licz nn p pp =
		if nn==0 then 0
		else if nn == 1 then 1
		else if nn==n then p+pp
		else licz (nn+1) (p + pp) p
	in licz 2 1 0 ;;


fibo 9;;



(* ZADANIE 3 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   *)


let root3 a = 
	let rec licz x =
		if abs_float( x**3. -. a ) <= abs_float a *. 10.**(-15.) then x
		else licz (x +. ( a/. x**2.  -. x ) /. 3.)
	in licz( if a > 1. then a/.3. else a );;


root3 28. ;;


(*  	ZADANIE 4  @@@@@@@@@@@@@@@@@@@@@@@@@@@@ *)


let xs = [-2;-1;0;1;2];;
let [_;_;x;_;_] = xs;;

let xss = [(1,2);(0,1)];;
let [(_,_);(x1,_)] = xss;;



(* ZADANIE 5 @@@@@@@@@@@@@@@@@@@@@@@@@*)


let rec initSegment (lista1,lista2) = 
	match (lista1,lista2) with
	| ([],_) -> true
	| (_,[]) -> false
	| (h1::t1,h2::t2) -> if h1=h2 then initSegment(t1,t2) else false;;












let rec replaceNth (xs,n,e) =
	match (xs,n) with
	| (_,n) when n<0 -> xs
	| ([],_) -> []
	| (h::t,0) -> e::t
	| (h::t,_)-> h::replaceNth(t,n-1,e);;


  
  replaceNth([1;2;3;4],3,9);;



















