let rec count ( x , xs) =
	if xs=[] then 0
	else if List.hd xs = x then 1 + count(x , List.tl xs)
	else count (x,List.tl xs);;

count ('a',['a';'b';'c';'a';'a';'c';'d';'a'])
	
	 