(ns com.quephird.pe.solutions.104
  (:use com.quephird.pe.util)
)

(defn pandigital? [n]
  (= (set (digits n)) (set (list 1 2 3 4 5 6 7 8 9)))
)

(defn first-9-digits [n]
  (bigint (apply str (take 9 (digits n))))
)

(defn last-9-digits [n]
  (rem n 1000000000)
)

; Note that we don't simply use an external Fibonacci call here
; and instead embed the pandigital tests right in the recursion.
; We're not interested in caching intermediate values, nor do
; we want to risk blowing the heap; we test values
; and upon failure throw them away.

; Note also that it is _hugely_ advantageous to test the
; last 9 digits first in the "and" below. The modulo operation is far
; less expensive than the list and cast operations
; involved in testing the first 9 digits, and so because
; and short-circuits, we can skip the latter test entirely
; if the former fails.

(defn euler-104 []
  (loop [a 0
         b 1
         n 1]
    (if
      (and
        (pandigital? (last-9-digits b))
        (pandigital? (first-9-digits b)))
      n
      (recur b (+ a b) (inc n))
    )
  )
)

(euler-104)
