(ns com.quephird.pe.solutions.22
  (:require [clojure.string :as str]))

(defn sum [numbers]
  (reduce + 0 numbers))

(defn extract-names [text]
  (as-> text $
    (str/split $ #",")
    (map #(str/replace % #"\"" "") $)))

(defn alphabetical-value [name]
  (->> name
    (map (fn [letter] (- (int letter) 64)))
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
