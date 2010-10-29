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

(defn first-value-of [pred lst]
  (first (drop-while #(not (pred %)) lst))
)

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

(defn pandigital? [n]
  (= (set (digits n)) (set (list 1 2 3 4 5 6 7 8 9)))
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

(defn pythagorean-triple? [v]
  (let [a (first v)
        b (second v)
        c (last v)]
    (= (+ (* a a) (* b b)) (* c c)))
)

;(pythagorean-triple? [3 4 5])
;(pythagorean-triple? [5 12 13])
;(pythagorean-triple? [3 4 6])

(defn power [n e]
  (cond
    (zero? e) 1
    (= 1 e) n
    (even? e) (#(* % %) (power n (/ e 2)))
    :else (* n (power n (dec e))))
)

(defn modulo-power [b e m]
  (cond
    (zero? e) 1
    (= 1 e) (rem b m)
    (even? e) (rem (#(* % %) (modulo-power b (/ e 2) m)) m)
    :else (rem (* b (modulo-power b (dec e) m)) m))
)

;(modulo-power 4 13 497)

(defn factorial [n]
  (loop [i n
         retval 1]
    (if (or (= i 1) (=  i 0))
      retval
      (recur (dec i) (* retval i))))
)

;(factorial 10)

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
  (if (< n 2)
    false
    (every? #(not (divides? n %)) (take-while #(<= (* % %) n) prime-seq)))
)

(def prime? (memoize prime?))

(def prime-seq
  (concat '(2 3 5 7)
    (filter #(prime? %) (map #(+ (* 2 %) 7) (iterate inc 1))))
)

(defn prime [n]
  (nth prime-seq (dec n))
)

;(defn factorize [n]
;  (loop [test-primes (take-while #(<= (* % %) n) prime-seq)
;         tmp n
;         retval '()]
;    (if (prime? tmp)
;      (concat retval (list tmp))
;      (let [p (first test-primes)]
;        (if (divides? tmp p)
;          (recur test-primes (quot tmp p) (concat retval (list p)))
;          (recur (rest test-primes) tmp retval)))))
;)

(defn factorize [n]
  (loop [test-primes prime-seq
         tmp n
         retval '()]
    (if (= 1 tmp)
      retval
      (if (prime? tmp)
        (concat retval (list tmp))
        (let [p (first test-primes)]
          (if (divides? tmp p)
            (recur test-primes (quot tmp p) (concat retval (list p)))
            (recur (rest test-primes) tmp retval))))))
)

(defn find-prime-divisor [n]
  (if (prime? n)
    n
    (first-value-of #(divides? n %) (take-while #(<= (* % %) n) prime-seq)))
)

(defn nest-list [f expr n]
  (loop [i n
         retval [(f expr)]]
    (if (= i 1)
      (seq retval)
      (recur (dec i) (conj retval (f (last retval))))
    )
  )
)

(defn nest [f expr n]
  (loop [i n
         retval (f expr)]
    (if (= i 1)
      retval
      (recur (dec i) (f retval))
    )
  )
)

