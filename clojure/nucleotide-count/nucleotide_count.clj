(ns nucleotide-count)
(defn count [symbol string]
  (if(not (.contains "ATCGU" (str symbol)))
    (throw (Exception. "invalid nucleotide")))
  (-> string
      frequencies
      (get symbol 0)))
(defn nucleotide-counts [string]
  (let [default {\A 0, \T 0, \C 0, \G 0}]
    (-> string
        frequencies
        (#(merge default %)))))
