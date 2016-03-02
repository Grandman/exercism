(ns grade-school)
(defn add [db student grade]
  (let [students (conj (vec (filter #(not= nil %) (get db grade))) student)]
  (merge db {grade students})))
(defn grade [db grade]
  (get db grade []))
(defn sorted [db]
  (reduce #{%1 (sort %2)} (keys db) (vals db)))
  ;(sort (map vector (#(sort (val %)) db))))
