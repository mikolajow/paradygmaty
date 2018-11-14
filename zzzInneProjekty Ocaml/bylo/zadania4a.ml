





let rec pred = function 
	| [] -> true
	| h::t -> if t==[] then true else if h <= (List.hd t) then pred t else false;;






let podziel xs =
	List.filter pred xs;;











podziel [[1;1;3]; [2]; [3;4;1]; []];;


















