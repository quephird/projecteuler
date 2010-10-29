(ns com.quephird.pe.solutions.45
  (:use com.quephird.pe.util)
)

(def triangle-seq
  (map #(/ (* % (- % 1)) 2) (iterate inc 2))
)

;(take 5 triangle-seq)

;Pentagonal 	  	P_(n)=n(3n?1)/2 	  	1, 5, 12, 22, 35, ...
;Hexagonal 	  	H_(n)=n(2n?1) 	  	1, 6, 15, 28, 45, ...

;3n^2 - n - 2x = 0
;2n^2 - n - x = 0

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

