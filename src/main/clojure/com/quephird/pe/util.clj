(ns com.quephird.pe.util
)

(defn list-sum [lst]
  (apply + lst)
)

(defn list-prod [lst]
  (apply * lst)
)

(defn first-index-of [pred lst]
  (count (take-while #(not (pred %)) lst))
)

;(defn first-index-of [pred lst]
;  (loop [retval 0
;         tmp lst]
;    (if (empty? tmp)
;      nil
;     (if (pred (first lst))
;       recur (inc retval) (rest lst))
;    )
;  )
;)

;(first-index-of even? (list 1 1 1 1 1 1 1 1 1 2 3 3 3 3))

(defn first-value-of [pred lst]
  (first (drop-while #(not (pred %)) lst))
)

;(first-value-of even? (list 1 1 1 1 1 1 1 1 1 2 3 3 3 3))

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

(defn divides? [n d]
  (zero? (rem n d))
)

(declare prime? prime-seq)

(defn prime? [n]
  (every? #(not (divides? n %)) (take-while #(<= (* % %) n) prime-seq))
)

(def prime? (memoize prime?))

(def prime-seq
  (concat '(2 3 5 7)
    (filter #(prime? %) (map #(+ (* 2 %) 7) (iterate inc 1))))
)

(defn prime [n]
  (nth prime-seq (dec n))
)

(defn factorize [n]
  (loop [test-primes (take-while #(<= (* % %) n) prime-seq)
         tmp n
         retval '()]
    (if (prime? tmp)
      (concat retval (list tmp))
      (let [p (first test-primes)]
        (if (divides? tmp p)
          (recur test-primes (quot tmp p) (concat retval (list p)))
          (recur (rest test-primes) tmp retval)))))
)
