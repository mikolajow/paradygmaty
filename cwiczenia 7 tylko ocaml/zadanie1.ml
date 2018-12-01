

(*	SYGNATURA KOLEJKI CZYSTO FUNKCYJNEJ - DANA	*)
module type QUEUE_FUN =
sig
 type 'a t
 exception Empty of string
 val empty: unit -> 'a t
 val enqueue: 'a * 'a t -> 'a t
 val dequeue: 'a t -> 'a t
 val first: 'a t -> 'a
 val isEmpty: 'a t -> bool
end;;

(* ZADANIE 1 A *)
module QueueList : QUEUE_FUN = 
struct
  type 'a t = 'a list
  exception Empty of string
  let empty() = [] 		(* empty = fun () -> [] *)
  let rec enqueue (el, l) = l@[el]
  let dequeue = function
    | _::t -> t
    | [] -> []
  let first = function
    | h::_ -> h
    | [] -> raise (Empty "module QueueList: first - list is empty")
  let isEmpty l = l = []
end;;

let q = QueueList.empty();;
let q1 = QueueList.enqueue(1, q);;
let q2 = QueueList.enqueue(2, q1);;
QueueList.dequeue q2;; (* [2] tak naprawde to zwracane jest abstr w tych trzech linijkach przez sygnature *)
QueueList.dequeue q2;; (* [2] - bo nie zapisuje zmiany z linijki wyzej wiec nie zmieniam q2 na stale *)
QueueList.dequeue (QueueList.dequeue q2);; (* [] *)
QueueList.first(q2);;	(* 1 *)
QueueList.first(QueueList.dequeue q2);; (* 2 *)
QueueList.isEmpty q2;; (* false *)
QueueList.isEmpty(QueueList.dequeue(QueueList.dequeue q2));; (* true *)
QueueList.first(QueueList.dequeue(QueueList.dequeue q2));; (* error *)



(* ZADANIE 1 B *)

module QueueDoubleList  = 
struct
  type 'a t = 'a list * 'a list
  exception Empty of string
  let empty() = ([], []) 		(* empty = fun () -> ([], []) *)
  let rec enqueue (el, l) = 
		match l with
		| ([], _) -> ([el], [])
		| (xs, ys) -> (xs, el::ys)
  let dequeue = function
		| ([], []) -> ([], [])
    | ([x], ys) -> (List.rev ys, [])
    | (x::xs, y) -> (xs, y)
    | ([], ys) -> failwith "module QueueList: dequeue - bad implementation"
  let first = function
    | (x::xs, _) -> x
    | ([], _) -> raise (Empty "module QueueList: first - list is empty")
  let isEmpty l = l = ([], [])
end;;



let q = QueueDoubleList.empty();;
let q1 = QueueDoubleList.enqueue(1, q);;
let q2 = QueueDoubleList.enqueue(2, q1);;
QueueDoubleList.first(q2);;
QueueDoubleList.dequeue q2;;
QueueDoubleList.first(QueueDoubleList.dequeue q2);;
QueueDoubleList.isEmpty q2;;
QueueDoubleList.isEmpty(QueueDoubleList.dequeue(QueueDoubleList.dequeue q2));;
QueueDoubleList.first(QueueDoubleList.dequeue(QueueDoubleList.dequeue q2));;


























