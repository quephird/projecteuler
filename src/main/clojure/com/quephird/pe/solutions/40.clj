(ns com.quephird.pe.solutions.40
  (:use com.quephird.pe.util)
)

; Note that my primary list starts with 0 below to make(fake)
; the index of the digits to the right of the decimal point start at 1.
(defn euler-40 []
  (let [foo (apply concat (map digits (range 0 1000000)))]
     (apply * (map #(nth foo %) (map #(power 10 %) (range 0 7))))
  )
)

(euler-40)
