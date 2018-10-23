(*zadanie 2*)
let rec twoLast xss=
		if xss=[] then failwith "pusta"
		else if List.tl xss = [] then failwith "tylko jeden"
		else if  List.tl(List.tl xss) = [] then (List.hd xss , List.hd(List.tl xss) )
		else twoLast (List.tl xss);;
	
twoLast[1;3;4;5;7]