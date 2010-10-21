(ns com.quephird.pe.solutions.3
  (:use com.quephird.pe.util)
)

(defn euler-3 []
  (apply max (factorize 600851475143))
)

(euler-3)
