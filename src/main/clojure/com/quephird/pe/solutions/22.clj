(ns com.quephird.pe.solutions.22
  (:require [clojure.string :as str]))

(defn sum [numbers]
  (reduce + 0 numbers))

(defn tokenize-using [pattern text]
  (str/split text pattern))

(defn strip-quotes [token]
  (str/replace token #"\"" ""))

(defn extract-names [text]
  (->> text
    (tokenize-using #",")
    (map strip-quotes)))

(defn letter-value [letter]
  (- (int letter) 64))

(defn word-value [name]
  (->> name
    (map letter-value)
    sum))

(defn score-all [names]
  (->> names
    (map alphabetical-value)
    (map * (range 1 Integer/MAX_VALUE))))

(defn solution [filename]
  (-> filename
    slurp
    extract-names
    sort
    score-all
    sum))
