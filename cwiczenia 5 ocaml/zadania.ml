



type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons (k, function () -> lfrom (k+1));;

let rec ltake = function
| (0, _) -> []
| (_, LNil) -> []
| (n, LCons(x,xf)) -> x::ltake(n-1, xf());;


(* ZADANIE 1 *)
let lrepeat k lxs =
  let rec inLRepeat = function
    | (_, LNil) -> LNil
    | (0, LCons(x, xs)) -> inLRepeat (k, xs())
    | (n, (LCons(x, xs) as original)) -> LCons(x, function () -> inLRepeat (n-1, original))
  in inLRepeat(k, lxs);;


ltake (11,  lrepeat 2 (lfrom 0));;


(* ZADANIE 2 *)

let lfib =
  let rec inFib = function
      (pp, p) -> LCons(pp+p, fun () -> inFib (p, pp+p))
  in LCons(0, fun () -> LCons(1, fun () -> inFib (0, 1)));;

ltake (11,  lfib );;


(* ZADANIE 3 *)

type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;

let rec ltree n = LNode (n, (fun () -> ltree (2*n)), (fun () -> ltree (2*n + 1)));;

let breadthBT lTree = 
	let rec helper list=
		match list with
		| [] -> LNil
		| LEmpty::lTail -> helper lTail
		| LNode(x, lLeft, lRight)::lTail -> LCons(x, fun() -> helper(lTail@[lLeft();lRight()]) )
	in helper [lTree];;

ltake (20, breadthBT (ltree 1));;





















