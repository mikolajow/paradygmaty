(*zadanie 3*)
let rec dwaRowne xss=
	if xss=[] then false
	else if List.tl xss = [] then false
	else if List.hd xss = List.hd(List.tl xss) then true 
	else dwaRowne (List.tl xss);;


dwaRowne[1;2;3;4];;
	
	