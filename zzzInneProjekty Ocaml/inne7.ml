









let m = Array.init 4 (function i -> Array.make 4 0);;


let wypelnij a = 
	let aLength = Array.length(a)-1
	and iLength = Array.length(a.(0))-1 in
	for i=0 to iLength do a.(0).(i) <- 1 done;
	for i=1 to aLength-1 do a.(i).(0) <- 1; a.(i).(iLength) <- 1 done; 
	for i=0 to iLength do a.(aLength).(i) <- 1 done;;


wypelnij m;;

m;;


let wypisz a = 
	let aLength = Array.length(a)-1
	and iLength = Array.length(a.(0))-1 in
	print_endline "";
	for i=0 to aLength do
		for j=0 to iLength do print_int a.(i).(j); print_string "," done;
		print_endline "" done;;




wypisz m;;


























