(ns com.quephird.pe.solutions.2
  (:use com.quephird.pe.util)
)

(defn answer []
  (list-sum (filter #(even? %) (take-while #(< % 4000000) fibonacci-seq)))
)

(answer)
