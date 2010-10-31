(ns com.quephird.pe.solutions.27
  (:use com.quephird.pe.util)
)

(defn max-consec-primes-from-quadratic [a b]
  (loop [n 0]
    (if (not (prime? (+ (* n n) (* a n) b)))
      n
      (recur (inc n))))
)

;(max-consec-primes-from-quadratic 1 41)
;(max-consec-primes-from-quadratic -79 1601)

(defn answer []
  (apply *
    (take 2
      (apply max-key #(last %)
        (for [a (range -999 1000)
              b (take-while #(< % 1000) prime-seq)]
          [a b (max-consec-primes-from-quadratic a b)]))))
)

(answer)
