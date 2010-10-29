(ns com.quephird.pe.solutions.39
  (:use com.quephird.pe.util)
)

; This function returns the set of all Pythagorean triple
; corresponding with the perimeter p of a right triangle.
(defn all-pythagorean-triples [p]
  (filter pythagorean-triple?
    (for [c (range (dec p) 1 -1)
          b (range 1 p)
          :while (< b (/ (- p c) 2))]  ; This division is to remove duplicates
      [(- p c b) b c]))
)

;(all-pythagorean-triples 12)
;(all-pythagorean-triples 510)
;(all-pythagorean-triples 1000)
;(all-pythagorean-triples 840)

(defn answer []
  (first
    (apply max-key #(second %)
      (map #(vector % (count (all-pythagorean-triples %))) (range 2 1001))))
)

(answer)
