(ns com.quephird.pe.solutions.34
  (:use com.quephird.pe.util)
)


(defn curious? [n]
  (= n (apply + (map factorial (digits n))))
)

;(curious? 145)
;(curious? 12)
;(curious? 50)

; We only go to ten million; 9! is 362880, and so if we consider
; 9999999, the sum of the factorials is 7*9!=2540160, already much
; less than the number itself.
(defn euler-34 []
  (apply + (filter curious? (range 10 10000000)))
)

(euler-34)
