(ns com.quephird.pe.solutions.10
  (:use com.quephird.pe.util)
)

<<<<<<< HEAD
(defn answer []
  (apply + (take-while #(< % 2000000) prime-seq))
)

(answer)
=======
(defn euler-10 []
  (reduce + 0 (take-while #(< % 2000000) prime-seq))
)

(euler-10)
>>>>>>> ede01bdbbf99451eb1d138741d0190432f1cd9ab
