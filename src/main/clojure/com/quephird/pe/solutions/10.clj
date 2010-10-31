(ns com.quephird.pe.solutions.10
  (:use com.quephird.pe.util)
)

(defn answer []
  (apply + (take-while #(< % 2000000) prime-seq))
)

(answer)
