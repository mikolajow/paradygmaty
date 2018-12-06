



let matrix columsNumber rowLength=
  Array.init columsNumber (function i -> Array.make rowLength 0);;

let m = matrix 4 6;;


let wypisz a = 
	let columsNumber = Array.length(a)-1
	and rowLength = Array.length(a.(0))-1 in
	print_endline "";
	for i=0 to columsNumber do
		for j=0 to rowLength do print_int a.(i).(j); print_string "," done;
		print_endline "" done;;


let wypelnij m = 
	let columsNumber = Array.length(m)-1
	and rowLength = Array.length(m.(0))-1 in
	for i=0 to rowLength do m.(0).(i) <- 1 done;
	for i=0 to rowLength do m.(columsNumber).(i) <- 1 done;
	for i=0 to columsNumber do m.(i).(0) <- 1 done;
	for i=0 to columsNumber do m.(i).(rowLength) <- 1 done;;

wypelnij m;;

wypisz m;;
























