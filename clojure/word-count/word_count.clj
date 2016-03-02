(ns word-count)
(defn word-count [text]
  (frequencies
   (re-seq #"[\w]+" (clojure.string/lower-case text))))
