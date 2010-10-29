(ns com.quephird.pe.solutions.30
  (:use com.quephird.pe.util)
)

(defn power-digits [n e]
  (map #(power % e) (digits n))
)

(defn euler-30 []
  ; We can stop at 6-digit numbers since the maximum value of the sum of the
  ; fifth powers of the digits of a 7-digit number (all 9's) is 413343.
  (apply + (filter #(= % (apply + (power-digits % 5))) (range 2 1000000)))
)

(euler-30)
