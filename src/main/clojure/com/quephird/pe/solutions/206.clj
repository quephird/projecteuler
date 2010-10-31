(ns com.quephird.pe.solutions.206
  (:use com.quephird.pe.util)
)

; We only consider the range of numbers whose minimum square is just below
; 1020304050607080900 and whose maximum is just over 192939495969798990.
; This is only a small optimization over simply computing the set of all
; possible combinations of numbers with this same pattern, but it is much
; easier to produce a comparable set of test cases.
;
; Note that our range only includes multiples of ten since its square must end in 0.
(defn answer []
  (first-value-of
    #(= (take-nth 2 (digits (* % %))) (list 1 2 3 4 5 6 7 8 9 0))
    (range 1010101010 1389026630 10))
)

(answer)
