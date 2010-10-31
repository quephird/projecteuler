(ns com.quephird.pe.solutions.206
  (:use com.quephird.pe.util)
)

; Note that our range only includes multiples of ten since its square must end in 0.
(defn answer []
  (first-value-of
    #(= (take-nth 2 (digits (* % %))) (list 1 2 3 4 5 6 7 8 9 0))
    (range 1010101010 1389026630 10))
)

(answer)
