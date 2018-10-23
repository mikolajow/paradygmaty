let rec flatten xss = 
	if xss = [] then []
	else List.hd xss @ flatten(List.tl xss);; 
let x1 = [[5;6] ; [1;2;3] ; [9;9] ; [22] ];;
flatten x1;;
	
	
	
	
	
	
	(*
	let xs = [ [1;2] ; [3;4]; [5;6] ];;
List.hd xs;;
List.hd(List.tl xs);;
*)