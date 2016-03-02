(ns rna-transcription)
(defn to-rna [dna]
  (if (re-find #"[^GCTA]" dna)
    (throw (AssertionError."invalid dna"))
    (clojure.string/replace
      (str dna) #"G|C|T|A" {"G" "C" "C" "G" "T" "A" "A" "U"})))
