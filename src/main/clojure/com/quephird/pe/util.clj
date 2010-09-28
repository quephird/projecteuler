(ns com.quephird.pe.util
)

(defn divides? [n d]
  (zero? (rem n d))
)

(defn list-sum [lst]
  (apply + lst)
)

(defn list-prod [lst]
  (apply * lst)
)

(defn digits [n]
  (map #(Integer/parseInt (str %)) (.toCharArray (str n)))
)
