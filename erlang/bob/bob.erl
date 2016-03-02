-module(bob).
-export([response_for/1]).

response_for(Question) when length(Question) == 0 -> "Fine. Be that way!";
response_for(Question) ->
  StripQuestion = string:strip(Question),
  UpperQuestion = string:to_upper(Question),
  LowerQuestion = string:to_lower(Question),
  [LastSymbol | _] = lists:reverse(Question),
  case StripQuestion of
    [] -> "Fine. Be that way!";
    UpperQuestion  when UpperQuestion /= LowerQuestion -> "Whoa, chill out!";
    _ when LastSymbol == $? -> "Sure.";
    _ -> "Whatever."
  end.
