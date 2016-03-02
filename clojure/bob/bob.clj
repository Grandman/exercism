(ns bob)
(defn response-for [text]
  (cond
    (clojure.string/blank? text)
    "Fine. Be that way!"
    (=
      (=
        (str text)
        (clojure.string/upper-case (str text)))
      (not=
        (str text)
        (clojure.string/lower-case (str text))))
    "Woah, chill out!"
    (=
      \?
        (last (str text)))
   "Sure."
    :else    "Whatever."))
