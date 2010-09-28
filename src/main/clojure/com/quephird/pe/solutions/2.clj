(ns com.quephird.pe.solutions.2
  (:use com.quephird.pe.util)
)

(def fibonacci-seq 
  ((fn fib-recur [a b]
       (lazy-seq (cons a (fib-recur b (+ a b)))))
    0 1)
)

(defn fibonacci [n]
  (nth fibonacci-seq n)
)

(defn euler-2 []
  (println "The sum of all even Finonacci numbers less than 4 million is: "
    (list-sum (filter #(even? %) (take-while #(< % 4000000) fibonacci-seq)))))

(euler-2)
