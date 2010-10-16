(ns com.quephird.pe.solutions.55
  (:use com.quephird.pe.util)
)

(defn lychrel? [n]
  (loop [ctr 1
         tmp (+ n (reverse-int n))]
    (if (= ctr 50)
      true
      (if (palindrome? tmp)
        false
        (recur (inc ctr) (+ tmp (reverse-int tmp)))
      )
    )
  )
)

(defn euler-55 []
  (count (filter #(lychrel? %) (range 1 10000)))
)

(euler-55)
