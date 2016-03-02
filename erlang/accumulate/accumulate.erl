-module(accumulate).
-export([accumulate/2]).

accumulate(Fn, List) ->
  [Fn(H) || H <- List].
