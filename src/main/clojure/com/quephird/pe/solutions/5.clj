(ns com.quephird.pe.solutions.5
  (:use com.quephird.pe.util)
)

(defn answer []
  (apply lcm (range 1 21))
)

(answer)
