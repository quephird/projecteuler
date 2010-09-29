(ns com.quephird.pe.solutions.25
  (:use com.quephird.pe.util)
)

(defn euler-25 []
  (first-index-of #(< % (power 10 999)) fibonacci-seq)
)

(euler-25)
