(ns com.quephird.pe.solutions.35
  (:use com.quephird.pe.util)
)

(defn rotate [lst]
  (concat (rest lst) (list (first lst)))
)

(defn rotate-int [n]
  (BigInteger. (apply str (rotate (digits n))))
)

(defn nest [f expr n]
  (loop [idx n
         tmp expr
         retval '()]
    (if (zero? idx)
      retval
      (recur (dec idx) (f tmp) (conj retval (f tmp)))
    )
  )
)

(defn all-digit-rotations [n]
  (map #(BigInteger. (apply str %)) (nest rotate (digits n) (count (digits n))))
)

(defn euler-35 []
  (count (filter #(every? prime? (all-digit-rotations %)) (range 2 1000000)))
)

(euler-35)
