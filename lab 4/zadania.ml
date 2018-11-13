

	






let rec funkcjonal = function (ile, xs) ->
	if xs = [] then [] 
	else if ile >= List.hd xs then generuj(List.hd xs)::funkcjonal(ile-(List.hd xs), xs) 
	else funkcjonal (ile, List.tl xs);;

funkcjonal (69,[50;20;10;5;2;1]);;








let wydaj ile xs = List.fold_left (function (ile, xs) ->
	if ile >= List.hd xs then (List.hd xs)
	else funkcjonal (ile, List.tl xs) ) [] ;;

wydaj (69,[50;20;10;5;2;1]);;








