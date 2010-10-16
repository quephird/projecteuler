(ns com.quephird.pe.solutions.52
  (:use com.quephird.pe.util)
)

(defn permutations? [lsts]
  (apply = (map #(sort %) lsts))
)

(defn first-satisfies [pred lst]
  (first (filter pred lst))
)

;(first-satisfies odd? (list 1 1 1 1 1 1 1 1 1 1 1 2 3 3 3 3 3 3 ))

(defn multiples [n]
  (map #(% n) (map #(fn [x] (* % x)) (range 2 7)))
)

(defn digits-of-multiples [n]
  (map #(digits %) (multiples n))
)

(defn euler-52 []
  (first-satisfies #(permutations? (digits-of-multiples %)) (range 10 1000000))
)

(euler-52)
