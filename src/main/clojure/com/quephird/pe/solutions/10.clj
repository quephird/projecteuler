(ns com.quephird.pe.solutions.10
  (:use com.quephird.pe.util)
)

(defn euler-10 []
  (reduce + 0 (take-while #(< % 2000000) prime-seq))
)

(euler-10)
