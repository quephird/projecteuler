(ns com.quephird.pe.solutions.48
  (:use com.quephird.pe.util)
)

(defn euler-48 []
  (rem (apply + (map #(modulo-power % % (power 10 10)) (range 1 1001))) (power 10 10))
)

(euler-48)
