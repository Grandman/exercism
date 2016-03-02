(ns anagram
  (:require [clojure.string :refer [lower-case]]))
(defn anagrams-for [word words]
  (let [low-word (lower-case word)
        sorted-low-word (sort low-word)]
    (defn find-not-equals [item]
      (-> item
          lower-case
          (not= low-word)))
    (defn find-anagrams [item]
      (-> item
          lower-case
          sort
          (= sorted-low-word)))
    (-> words
        (#(filter find-not-equals %))
        (#(filter find-anagrams %)))))
