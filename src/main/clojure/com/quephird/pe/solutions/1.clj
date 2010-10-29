(ns com.quephird.pe.solutions.1
  (:use com.quephird.pe.util)
)

(defn answer []
  (list-sum (filter #(or (divides? % 3) (divides? % 5)) (range 1 1000)))
)

(answer)