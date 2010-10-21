(ns com.quephird.pe.solutions.92
  (:use com.quephird.pe.util)
)

(defn sum-square-digits [n]
  (apply + (map #(* % %) (digits n)))
)

(defn happy-sad-seq [n]
  (cond
    (= n 1) (list n)
    (= n 89) (list n)
    :else (cons n (happy-sad-seq (sum-square-digits n)))
  )
)

(defn happy? [n]
  (= (last (happy-sad-seq n)) 1)
)

(defn sad? [n]
  (not (happy? n))
)

(defn euler-92 []
  (count (filter sad? (range 1 10000000)))
)

(time (euler-92))
