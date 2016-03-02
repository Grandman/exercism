(ns point-mutations)
(use 'clojure.data)
(defn hamming-distance [x y]
  (let [min-vector (if (< (count x) (count y))
                     first
                     second)
        diff-vector (diff (clojure.string/split x #"")
                          (clojure.string/split y #""))]
    (-> diff-vector
        min-vector
        (#(filter (fn[x](not= nil x)) %))
        count)))
