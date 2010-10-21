(ns com.quephird.pe.solutions.46
  (:use com.quephird.pe.util)
)

(defn twice-a-square? [n]
  (if (odd? n)
    false
    (let [half-n (/ n 2)]
      (= half-n (#(* % %) (Math/floor (Math/sqrt half-n))))
    )
  )
)

(defn sum-of-prime-and-twice-a-square? [n]
  (not (not-any? #(twice-a-square? %) (map #(- n %) (take-while #(< % n) prime-seq))))
)

(defn euler-46 []
  ; The choice of 10000 was arbitrary; I just kept going up by a factor of ten
  ; until something returned
  (first (drop-while sum-of-prime-and-twice-a-square? (filter #(not (prime? %)) (range 3 10000 2))))
)

(euler-46)
