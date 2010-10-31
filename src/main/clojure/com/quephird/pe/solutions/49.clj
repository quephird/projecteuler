(ns com.quephird.pe.solutions.49
  (:use com.quephird.pe.util)
)

(defn answer []
  (bigint (apply str
    (first-value-of #(and (prime? (last %))
                          (permutations? (map digits %)))
      (let [four-digit-primes (take-while #(< % 10000) (drop-while #(< % 1000) prime-seq))]
        (for [p1 four-digit-primes
              p2 four-digit-primes
              :when (and (not (= p1 1487)) (< p1 p2))]
          [p1 p2 (+ p2 (- p2 p1))])))))
)

(answer)
