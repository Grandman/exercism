(ns beer-song
  (:require [clojure.string :as str]))
(defn verse [number]
  (def lines "Numb of beer on the wall, numb of beer.\nTake it-or-one down and pass it around, left-bottles of beer on the wall.\n")
  (letfn [(num-to-string [x]
                         (cond
                          (= x 0)
                          "no more bottles"
                          (= x 1)
                          "1 bottle"
                          :else
                          (str x " bottles")))
          (it-or-one-replace [x]
                             (if (= x 1) "it" "one"))
          (if-last-line [x number]
                        (if (= number 0)
                          (str/replace x #"\n.*\n" "\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")
                          x))]
    (-> lines
        (str/replace "Numb" (str/capitalize (num-to-string number)))
        (str/replace "numb" (num-to-string number))
        (str/replace "it-or-one" (it-or-one-replace number))
        (str/replace "left-bottles" (num-to-string (- number 1)))
        (if-last-line number))))
(defn sing [& args]
  (let [from (first args)
        to (if (= (first args) (last args))
             0
             (last args))
        range (reverse (range to (+ from 1)))]

    (str/join "\n" (for [x  range
                         :let [y (verse x)]]
                     y))))
