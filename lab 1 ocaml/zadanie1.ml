(*zadanie 1*)
let fun1 (x,y)=
	if x*y < 22 then true
	else false;;


let fun2 (x,y)=
	if x<1.2 then (x,y)
	else  (y,x);;

let rec fun3 (xss,x)=
	if x=0 then []
	else 	xss@List.tl xss@fun3(xss,x-1);; 



