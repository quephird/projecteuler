(ns com.quephird.pe.solutions.1
  (:use com.quephird.pe.util)
)

(defn euler-1 []
  (list-sum (filter #(or (divides? % 3) (divides? % 5)) (range 1 1000)))
)

(euler-1)