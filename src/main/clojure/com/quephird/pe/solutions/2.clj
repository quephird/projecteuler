(ns com.quephird.pe.solutions.2
  (:use com.quephird.pe.util)
)

(defn euler-2 []
  (println "The sum of all even Finonacci numbers less than 4 million is: "
    (list-sum (filter #(even? %) (take-while #(< % 4000000) fibonacci-seq)))))

(euler-2)
