
module type QUEUE_MUT =
sig
 type 'a t
 (* The type of queues containing elements of type ['a]. *)
 exception Empty of string
 (* Raised when [first q] is applied to an empty queue [q]. *)
 exception Full of string
 (* Raised when [enqueue(x,q)] is applied to a full queue [q]. *)
 val empty: int -> 'a t
 (* [empty n] returns a new queue of length [n], initially empty. *)
 val enqueue: 'a * 'a t -> unit
 (* [enqueue (x,q)] adds the element [x] at the end of a queue [q]. *)
 val dequeue: 'a t -> unit
 (* [dequeue q] removes the first element in queue [q] *)
 val first: 'a t -> 'a
 (* [first q] returns the first element in queue [q] without removing
 it from the queue, or raises [Empty] if the queue is empty. *)
 val isEmpty: 'a t -> bool
 (* [isEmpty q] returns [true] if queue [q] is empty,
 otherwise returns [false]. *)
 val isFull: 'a t -> bool
 (* [isFull q] returns [true] if queue [q] is full,
 otherwise returns [false]. *)
end;;


module CyclicalMutableQ : QUEUE_MUT = 
struct
  type 'a t = { mutable f: int; mutable r: int; size: int; mutable a: 'a option array }
  exception Empty of string
  exception Full of string
	
  let empty n = { f = 0; r = 0; size = n+1; a = Array.make (n+1) None }
	
  let enqueue (el, array) =
    if (array.r +1) mod array.size = array.f then raise (Full "module CyclicalMutableQ : enqueue")
    else array.a.(array.r) <- Some el; array.r <- (array.r +1) mod array.size
		
  let dequeue array =
    if array.r != array.f then array.f <- (array.f +1) mod array.size
		
  let first array =
    if array.f = array.r then raise (Empty "module CyclicalMutableQ: first")
    else match array.a.(array.f) with
      | Some e -> e
      | None -> failwith "module CyclicalMutableQ : first - bad implementation"
			
  let isEmpty array = array.f = array.r
	
  let isFull array = (array.r +1) mod array.size = array.f
end;;



let q = CyclicalMutableQ.empty 3;;
CyclicalMutableQ.enqueue(1, q);;
CyclicalMutableQ.enqueue(2, q);;
CyclicalMutableQ.enqueue(3, q);;
q;;
CyclicalMutableQ.dequeue q;;
CyclicalMutableQ.enqueue(4, q);;
q;;
CyclicalMutableQ.dequeue q;;
CyclicalMutableQ.enqueue(5, q);;
q;;

CyclicalMutableQ.isFull q;;
CyclicalMutableQ.first q;;
CyclicalMutableQ.dequeue q;;
CyclicalMutableQ.first q;;
CyclicalMutableQ.dequeue q;;
CyclicalMutableQ.first q;;
CyclicalMutableQ.dequeue q;;
CyclicalMutableQ.first q;;
CyclicalMutableQ.dequeue q;;
CyclicalMutableQ.isEmpty q;;



































