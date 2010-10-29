(ns com.quephird.pe.solutions.53
  (:use com.quephird.pe.util)
)

(defn c [n r]
  (/ (factorial n) (factorial r) (factorial (- n r)))
)

;(c 23 10) should be 1144066

(count
  (filter #(> % 1000000)
    (apply concat
      (for [n (range 23 101)]
        (for [r (range 0 n)]
          (c n r)
        )
      )
    )
  )
)