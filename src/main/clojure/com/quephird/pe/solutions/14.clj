(ns com.quephird.pe.solutions.14
  (:use com.quephird.pe.util)
)

(defn collatz [n]
  (if (even? n)
    (/ n 2)
    (+ (* 3 n) 1)
  )
)

(defn collatz-seq [n]
  (if (= n 1)
    (list n)
    (cons n (collatz-seq (collatz n)))
  )
)

; Ugh... this is horribly slow
; I'd use memoize above, but I kept blowing up the heap
; with an OutOfMemoryError, even with a max setting of 1024MB (!!!)

(defn euler-14 []
  (apply max-key #(count (collatz-seq %)) (range 1 1000000))
)

(euler-14)
