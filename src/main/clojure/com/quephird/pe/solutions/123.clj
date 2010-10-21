(ns com.quephird.pe.solutions.123
  (:use com.quephird.pe.util)
)

(defn modulo-power [b e m]
  (cond
    (zero? e) 1
    (= 1 e) (rem b m)
    (even? e) (rem (#(* % %) (modulo-power b (/ e 2) m)) m)
    :else (rem (* b (modulo-power b (dec e) m)) m))
)

;(modulo-power 4 13 497)

(defn prime-power-fn [n]
  (let [p (prime n)
        m (* p p)]
    (rem (+ (modulo-power (dec p) n m) (modulo-power (inc p) n m)) m))
)

;(prime-power-fn 3)

(defn euler-123 []
  (loop [n 1]
    (if (> (prime-power-fn n) (power 10 10))
      n
      (recur (inc n))
    )
  )
)

(euler-123)
