(ns com.quephird.pe.util
)

(defn list-sum [lst]
  (apply + lst)
)

(defn list-prod [lst]
  (apply * lst)
)

(defn first-index-of [pred lst]
  (count (take-while pred lst))
)


(defn digits [n]
  (map #(Integer/parseInt (str %)) (.toCharArray (str n)))
)

(defn digit-sum [n]
  (apply + (digits n))
)

(defn reverse-int [n]
  (BigInteger. (apply str (reverse (digits n))))
)

(defn palindrome? [n]
  (= n (reverse-int n))
)

(defn divides? [n d]
  (zero? (rem n d))
)

; I'm not sure that I like these two implementations;
; they certainly express the problem in an understandable
; way, but they're too deeply recursive, and thus easily
; blow the stack for lists with ~150 elements.

(defn gcd
  ([x y]
    (if (< x y)
      (gcd y x)
      (if (zero? y)
        x
        (gcd y (rem x y))
      )
    ))
  ([x y & more]
      (apply gcd (cons (gcd x y) more)))
)

(defn lcm
  ([x y]
    (/ (* x y) (gcd x y)))
  ([x y & more]
    (apply lcm (cons (lcm x y) more)))
)

(defn power [n e]
  (cond
    (zero? e) 1
    (= 1 e) n
    (even? e) (#(* % %) (power n (/ e 2)))
    :else (* n (power n (dec e))))
)

(defn factorial [n]
  (loop [ctr 1
         retval 1]
    (if (= ctr n)
      retval
      (recur (inc ctr) (* retval (inc ctr)))))
)

(def fibonacci-seq
  ((fn fib-recur [a b]
       (lazy-seq (cons a (fib-recur b (+ a b)))))
    0 1)
)

(defn fibonacci [n]
  (nth fibonacci-seq n)
)
