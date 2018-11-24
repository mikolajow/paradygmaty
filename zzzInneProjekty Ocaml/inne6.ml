
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



























