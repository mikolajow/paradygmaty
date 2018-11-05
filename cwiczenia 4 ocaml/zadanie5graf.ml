 




type 'a graph = Graph of ('a -> 'a list);;


let breadthSearch (Graph succ) startNode =
	let rec search visited queue =
		match queue with
		| [] -> []
		| h::t -> if List.mem h visited then search visited t
							else h::search (h::visited) (t @ succ h)
in search [] [startNode];;









let g = Graph
(function
0 -> [3]
| 1 -> [0;2;4]
| 2 -> [1]
| 3 -> []
| 4 -> [0;2]
| n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist")
);;



breadthSearch g 4;;



let depthSearch (Graph succ) startNode =
	let rec licz visited queue =
		match queue with
		| [] ->[]
		| h::t -> if List.mem h visited then licz visited t
							else h::licz (h::visited) ( succ h @ t)
	in licz [] [startNode];;


depthSearch g 4;;
































