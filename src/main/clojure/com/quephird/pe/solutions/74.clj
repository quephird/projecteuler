(ns com.quephird.pe.solutions.74
  (:use com.quephird.pe.util)
)

; I created this because there is not any? in the Clojure libraries
; and some works with keys or indices.
(defn exists? [elt lst]
  (let [result (some #(= % elt) lst)]
    (if (nil? result)
      false
      result))
)

(defn sum-factorial-digit [n]
  (apply + (map factorial (digits n)))
)

;(sum-factorial-digit 145)
;(sum-factorial-digit 169)

; TODO - this needs to be memoized somehow
(defn sum-factorial-digit-seq [n]
  (loop [tmp (sum-factorial-digit n)
         retval (list n)]
    (if (exists? tmp retval)
      retval
      (recur (sum-factorial-digit tmp) (concat retval (list tmp))))
  )
)

;(sum-factorial-digit-seq 145)
;(sum-factorial-digit-seq 169)
;(sum-factorial-digit-seq 871)
;(sum-factorial-digit-seq 872)
;(sum-factorial-digit-seq 69)

(defn answer []
  (count
    (filter #(= 60 (count %))
      (map sum-factorial-digit-seq (range 1 1000000))))
)

(answer)
