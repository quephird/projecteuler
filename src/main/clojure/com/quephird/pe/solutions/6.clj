(ns com.quephird.pe.solutions.6
  (:use com.quephird.pe.util)
)

(defn euler-6 []
  (let [first-100-ints (range 1 101)
        square (fn [n] (* n n))]
    (- (square (list-sum first-100-ints))
       (list-sum (map square first-100-ints)))
  )
)

(euler-6)
