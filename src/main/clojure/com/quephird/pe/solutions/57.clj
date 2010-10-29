(ns com.quephird.pe.solutions.57
  (:use com.quephird.pe.util)
)

(defn numerator-has-more-digits? [r]
  (> (count (digits (numerator r)))
     (count (digits (denominator r))))
)

;(numerator-has-more-digits? 1234/345)
;(numerator-has-more-digits? 123/345)
;(numerator-has-more-digits? 1234/34567)

(count
  (filter numerator-has-more-digits?
    (map #(- % 1) (nest-list #(+ 2 (/ 1 %)) 2 1000))
  )
)
