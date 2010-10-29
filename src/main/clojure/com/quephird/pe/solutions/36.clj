(ns com.quephird.pe.solutions.36
  (:use com.quephird.pe.util)
)

; This function returns a vector whose first item is the list of digits
; representing the number n in base b and whose second item is b itself.
(defn to-base [n b]
  (loop [tmp n
         retval '()]
    (if (< tmp b)
      [(conj retval tmp) b]
      (recur (quot tmp b) (conj retval (rem tmp b)))
    )
  )
)

;(to-base 2 3)
;(to-base 7 3)
;(to-base 7 2)


; Note that for now we are cheating by treating the base 2 representation
; of n as a base 10 one on order to pass it on to palindrome?.
(defn answer []
  (apply +
    (map first
      (filter #(and (palindrome? (first %))
                    (palindrome? (second %)))
        (map #(vector (first %) (bigint (apply str (first (second %)))))
          (map #(vector % (to-base % 2)) (range 1 1000000))
        )
      )
    )
  )
)

(answer)
