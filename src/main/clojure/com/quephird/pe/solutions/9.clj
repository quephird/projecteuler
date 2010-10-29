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

(defn pythagorean-triple? [v]
  (let [a (first v)
        b (second v)
        c (last v)]
    (= (+ (* a a) (* b b)) (* c c)))
)

;(pythagorean-triple? [3 4 5])
;(pythagorean-triple? [5 12 13])
;(pythagorean-triple? [3 4 6])

(defn answer []
  (apply *
    (first-value-of pythagorean-triple?
      (for [c (range 999 1 -1)
            b (range 1 1000)
            :while (< b (- 1000 c))]
        [(- 1000 c b) b c])))
)

(answer)
