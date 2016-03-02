(ns phone-number
  (:require [clojure.string :refer [join]]))

(defn validate-number [number]
  (def not-valid "0000000000")
  (def length-number (count number))

  (cond
   (and (= length-number 11) (= (first number) \1))
     (subs number 1 length-number)
   (= length-number 10)
     number
   :else not-valid))

(defn number [number]
  (validate-number (join (re-seq #"\d+" number))))

(defn area-code [number]
  (subs (validate-number number) 0 3))

(defn pretty-print [number]
  (let [validated-number (validate-number number)
        length-number (count validated-number)
        area (subs validated-number 0 3)
        prefix (subs validated-number 3 6)
        line (subs validated-number 6 length-number)]
    (str "(" area ") " prefix "-" line)))
