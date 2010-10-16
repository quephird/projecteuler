(ns com.quephird.pe.solutions.97
  (:use com.quephird.pe.util)
)

(defn last-n-digits [n d]
  (rem n (power 10 d))
)

; Ugh... this is _really_ noisy... but it works.
; There's gotta be a way to take advantage of macros here.
(defn last-n-digits-power [n e d]
  (cond
    (= 1 e) (last-n-digits n d)
    (even? e) (last-n-digits (#(* % %) (last-n-digits-power n (/ e 2) d)) d)
    :else (last-n-digits (* n (last-n-digits-power n (dec e) d)) d))
)

(defn euler-97 []
  (last-n-digits (+ (* 28433 (last-n-digits-power 2 7830457 10)) 1) 10)
)

(euler-97)
