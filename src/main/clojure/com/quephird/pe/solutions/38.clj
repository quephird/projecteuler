(ns com.quephird.pe.solutions.38
  (:use com.quephird.pe.util)
)

; Possible solutions involve four cases
;
; Case 1:
; 1-digit seed -> 1 2 2 2 2
;
;   For this to be satisfied, 2s >= 10, which means that s must be at least 5.
;   So this set of test cases translates to: 5 <= s <= 9, 1 <= n <= 5.
;
; Case 2:
; 2-digit seed -> 2 2 2 3
;
;   For this to be satisfied, 4s >= 100, which means that s must be at least 25,
;   but 3s < 100, so s must be less than 34. So this set of test cases translates
;   to: 25 <= s <= 33, 1 <= n <= 4.
;
; Case 3:
; 3-digit seed -> 3 3 3
;
;   For this to be satisfied, 3s < 1000, which means that s must be less than 334.
;   So this set of test cases translates to: 100 <= s <= 333, 1 <= n <= 3.
;
; Case 3:
; 4-digit seed -> 4 5
;
;   For this to be satisfied, 2s >= 10000, which means that s must be at least 5000.
;   So this set of test cases translates to: 5000 <= s <= 9999, 1 <= n <= 2.

;(apply str (map #(% 9) (map #(fn [n] (* % n)) (range 1 6))))

(defn concatenate-product [s n]
  (bigint (apply str
    (map #(% s) (map #(fn [n] (* % n)) (range 1 (inc n))))))
)

(defn answer []
  (apply max
    (filter pandigital?
      (concat
        (map #(concatenate-product % 5) (range 5 10))
        (map #(concatenate-product % 4) (range 25 34))
        (map #(concatenate-product % 3) (range 100 334))
        (map #(concatenate-product % 2) (range 5000 9999))
      )
    )
  )
)

(answer)
