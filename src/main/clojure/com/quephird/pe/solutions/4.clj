(ns com.quephird.pe.solutions.4
  (:use com.quephird.pe.util)
)

(defn answer []
  (apply max
    (filter palindrome?
      (map #(apply * %)
        (let [three-digit-nums (range 100 1000)]
          (for [x three-digit-nums y three-digit-nums] [x y])
        )
      )
    )
  )
)

(answer)

