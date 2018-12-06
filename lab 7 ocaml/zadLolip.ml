

type day = { lizaki:int; delay:int };;

let day1 = { lizaki= 5 ; delay= 3  };;
let day2 = { lizaki= 7 ; delay= 2  };;
let day3 = { lizaki= 4 ; delay= 3  };;
let day4 = { lizaki= 6 ; delay= 5  };;
let day5 = { lizaki= 1 ; delay= 1  };;
let day6 = { lizaki= 1 ; delay= 2  };;
let day7 = { lizaki= 2 ; delay= 5  };;


let data = [| day1; day2; day3; day4; day5; day6; day7 |];;


let szukaj d =
	let len = Array.length d in
	let w = Array.make (len) 0 in
	begin
	w.(len -1) <- d.(len -1).lizaki ;
	for i = (len -2) downto 0 do
		if (i+d.(i).delay) >= len then
			if (d.(i).lizaki) > w.(i+1) then w.(i) <- d.(i).lizaki
			else w.(i) <- w.(i+1)
		else
				if (d.(i).lizaki) + w.(i+ d.(i).delay) > w.(i+1) then w.(i) <- d.(i).lizaki + w.(i+d.(i).delay)
				else w.(i) <- w.(i+1)
		done;
		w
		end;;
		

	
	
szukaj data;;
	

























