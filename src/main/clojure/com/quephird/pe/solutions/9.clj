(ns com.quephird.pe.solutions.9
  (:use com.quephird.pe.util)
)

(defn answer []
  (apply *
    (first-value-of pythagorean-triple?
      (for [c (range 999 1 -1)
            b (range 1 1000)
            :while (< b (- 1000 c))]
        [(- 1000 c b) b c])))
)

(answer)
