(ns com.quephird.pe.solutions.9
  (:use com.quephird.pe.util)
)

(defn square? [n]
  (let [sqrt-n (Math/floor (Math/sqrt n))]
    (= n (* sqrt-n sqrt-n)))
)

;(square? 25)
;(square? 4)
;(square? 5)
;(square? 26)
;(square? 1000001)
;(square? 1000000)

(defn answer []
  (apply *
    (first-value-of pythagorean-triple?
      (for [c (range 999 1 -1)
            b (range 1 1000)
            :while (< b (- 1000 c))]
        [(- 1000 c b) b c])))
)

(answer)
