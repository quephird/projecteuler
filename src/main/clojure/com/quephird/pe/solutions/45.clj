(ns com.quephird.pe.solutions.45
  (:use com.quephird.pe.util)
)

(def triangle-seq
  (map #(/ (* % (- % 1)) 2) (iterate inc 2))
)

;(take 5 triangle-seq)

; Pentagonal and hexagonal numbers are of the forms n(3n-1)/2 and n(2n-1),
; respectively. If a number x is a pentagonal number, then 3n^2 - n - 2x = 0
; and solving for n,
;             _______
;    n = 1 + /1 + 24x
;        ------------
;             6
;
; Thus, in order to test that a given x is pentagonal, corresponding to an index n,
; the discriminant must be a perfect square and the entire result must be divisible
; by 6. In an similar fashion, a given x can only be hexagonal according to the
; equation 2n^2 - n - x = 0 yielding the following solution:
;             ______
;    n = 1 + /1 + 8x
;        ------------
;             4

(defn pentagonal? [n]
  (let [discriminant (+ 1 (* 24 n))]
    (and (square? discriminant) (divides? (+ 1 (int (Math/sqrt discriminant))) 6)))
)

;(map #(vector % (pentagonal? %)) (range 1 36))

(defn hexagonal? [n]
  (let [discriminant (+ 1 (* 8 n))]
    (and (square? discriminant) (divides? (+ 1 (int (Math/sqrt discriminant))) 4)))
)

;(map #(vector % (hexagonal? %)) (range 1 45))

(defn answer []
  (first-value-of #(and (pentagonal? %) (hexagonal? %))
    (drop-while #(<= % 40755) triangle-seq))
)

(answer)

