(ns com.quephird.pe.solutions.5
  (:use com.quephird.pe.util)
)

(defn euler-5 []
  (apply lcm (range 1 21))
)

(euler-5)
