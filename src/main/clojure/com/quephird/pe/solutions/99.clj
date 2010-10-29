(ns com.quephird.pe.solutions.99
  (:import (java.io BufferedReader FileReader))
)

(defn buffered-reader [filename]
  (BufferedReader. (FileReader. filename))
)

(defn split-line [line]
  (let [[a b] (re-seq #"\w+" line)]
    [(bigint a) (bigint b)])
)

; Ugh... messy... but it works
(defn max-index-of [f lst]
  (loop [tmp lst
         max-f-x (bigint Integer/MIN_VALUE)
         i 0
         retval nil]
    (if (empty? tmp)
      retval
      (if (> (f (first tmp)) max-f-x)
        (recur (rest tmp) (f (first tmp)) (inc i) i)
        (recur (rest tmp) max-f-x (inc i) retval)
      )
    )
  )
)

(max-index-of #(* (second %) (Math/log (first %)))
  (map split-line
    (line-seq (buffered-reader "./src/main/clojure/com/quephird/pe/solutions/99.txt")))
)

