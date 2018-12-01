
type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons (k, function () -> lfrom (k+1));;

let rec ltake = function
| (0, _) -> []
| (_, LNil) -> []
| (n, LCons(x,xf)) -> x::ltake(n-1, xf());;



(* ZADANIE 1 *)
let lSpec lxs =
  let rec inLRepeat = function
    | (_, LNil) -> LNil
    | (0, LCons(x, xs)) -> inLRepeat (x+1, xs())
    | (n, (LCons(x, xs) as original)) -> LCons(x, function () -> inLRepeat (n-1, original))
  in inLRepeat(1, lxs);;

ltake (20,  lSpec (lfrom 1));;





type 'a lSpe = LNi | LCon of int * int* (unit -> 'a lSpe);;


let rec lfro k n = LCon (k, n, function () -> match n with
| 0 -> lfro (k+1) (k)
| _ -> lfro k (n-1));;


let rec ltak = function
| (0, _) -> []
| (_, LNi) -> []
| (n, LCon(x,a,xf)) -> x::ltak(n-1, xf());;



ltak (20, lfro 1 0);;










