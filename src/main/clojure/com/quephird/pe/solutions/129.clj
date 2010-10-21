(ns com.quephird.pe.solutions.129
  (:use com.quephird.pe.util)
)

(def repunit-seq
  ((fn r [n]
       (lazy-seq (cons n (r (+ (* 10 n) 1)))))
    1)
)

(defn a [n]
  (loop [r 11
         retval 2]
    (if (divides? r n)
      retval
      (recur (+ (* 10 r) 1) (inc retval)))
  )
;  (+ (first-index-of #(divides? % n) repunit-seq) 1)
)

;(a 7)
;(a 41)


(defn euler-129 []
  (first-value-of #(> (a %) 1000000) (filter #(= 1 (gcd % 10)) (range 1000001 9999999)))
)

(euler-129)

