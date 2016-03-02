-module(rna_transcription).
-export([to_rna/1]).

to_rna(Line) ->
  [convert(H) || H <- Line].

convert($G) ->
  $C;
convert($C) ->
  $G;
convert($T) ->
  $A;
convert($A) -> 
  $U.
 
