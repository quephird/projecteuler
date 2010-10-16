(ns com.quephird.pe.solutions.29
  (:use com.quephird.pe.util)
)

(defn euler-29 []
  (count (set
    (let [nums (range 2 101)]
      (for [a nums b nums] (power a b)))))
)

(euler-29)
