-module(leap).
-export([leap_year/1]).

leap_year(Year) ->
	case Year rem 4 of
		    0 -> Year rem 100 =/= 0 orelse Year rem 400 =:= 0;
		    _ -> false
    end.
