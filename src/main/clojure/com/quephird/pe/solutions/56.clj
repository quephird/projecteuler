(ns com.quephird.pe.solutions.56
  (:use com.quephird.pe.util)
)

(apply max
  (for [x (range 1 100)
        y (range 1 100)]
    (digit-sum (power x y))))
