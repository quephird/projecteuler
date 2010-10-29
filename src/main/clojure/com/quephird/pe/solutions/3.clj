(ns com.quephird.pe.solutions.3
  (:use com.quephird.pe.util)
)

(defn answer []
  (apply max (factorize 600851475143))
)

(answer)
