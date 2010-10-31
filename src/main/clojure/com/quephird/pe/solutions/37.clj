(ns com.quephird.pe.solutions.37
  (:use com.quephird.pe.util)
)

(defn truncate-left [n]
  (rem n (power 10 (dec (count (digits n)))))
)

(defn truncate-right [n]
  (quot n 10)
)

;(truncate-left 786378162)
;(nest-list truncate-left 83781237 (dec (count (digits 83781237))))
;(truncate-right 786378162)
;(nest-list truncate-right 83781237 (dec (count (digits 83781237))))


(defn truncatable-prime? [n]
  (if (< n 10)
    false
    (let [m (dec (count (digits n)))]
      (every? prime?
         (concat (list n)
                 (nest-list truncate-left n m)
                 (nest-list truncate-right n m)))
    )
  )
)

;(truncatable-prime? 2)
;(truncatable-prime? 3)
;(truncatable-prime? 12)
;(truncatable-prime? 3797)

(defn answer []
  (apply + (take 11 (filter truncatable-prime? prime-seq)))
)

(answer)
