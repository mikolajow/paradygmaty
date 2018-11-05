






type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;


let tt = 
Node(1,
		Node(2,
				Node(4,
						Empty,
						Empty
				),
				Empty
		),
		Node(3,
				Node(5,
						Empty,
						Node(6,
								Empty,
								Empty
						)
				),
				Empty
		)
);; 




let rec nodes = function
|Empty -> 0
| Node(_,t1,t2) -> 1 + nodes t1 + nodes t2;;






let bfs tree = 
	let rec helper list=
		match list with
		| [] -> []
		| Empty::tail ->helper tail
		| Node(x, left, right)::tail -> x::helper( tail@[left;right] )
	in helper [tree];;



bfs tt;;



let dlugoscWewnetrznej tree =
	let rec licz tree glebokosc  =
		match tree with
		| Empty -> 0
		| Node(root, l, r) -> glebokosc + licz l (glebokosc+1) + licz r (glebokosc+1)
	in licz tree 0 ;;


dlugoscWewnetrznej tt;;



let dlugoscZew tree =
	let rec licz tree glebokosc =
		match tree with
		| Empty -> glebokosc
		| Node(root, l, r) ->  licz l (glebokosc+1) + licz r (glebokosc+1)
	in licz tree 0 ;;


dlugoscZew tt;;





















