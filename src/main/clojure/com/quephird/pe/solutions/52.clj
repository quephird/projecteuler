(ns com.quephird.pe.solutions.52
  (:use com.quephird.pe.util)
)

(defn multiples [n]
  (map #(% n) (map #(fn [x] (* % x)) (range 2 7)))
)

(defn digits-of-multiples [n]
  (map #(digits %) (multiples n))
)

(defn euler-52 []
  (first-value-of #(permutations? (digits-of-multiples %)) (range 10 1000000))
)

(euler-52)
