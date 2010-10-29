(ns com.quephird.pe.tests.test-solutions
  (:use [clojure.test :only (deftest testing is run-tests)])
  (:require [com.quephird.pe.solutions.1 :as s1])
  (:require [com.quephird.pe.solutions.2 :as s2])
  (:require [com.quephird.pe.solutions.3 :as s3])
  (:require [com.quephird.pe.solutions.4 :as s4])
  (:require [com.quephird.pe.solutions.5 :as s5])
  (:require [com.quephird.pe.solutions.6 :as s6])
  (:require [com.quephird.pe.solutions.7 :as s7])
  (:require [com.quephird.pe.solutions.8 :as s8])
  (:require [com.quephird.pe.solutions.9 :as s9])
  (:require [com.quephird.pe.solutions.10 :as s10])
)

(deftest testing-solution-1
  (testing "The sum of all numbers below 1000 divisible by 3 or 5 should be 233168."
    (is (= 233168 (s1/answer))))
)

(deftest testing-solution-2
  (testing "The sum of all even Finonacci numbers less than 4 million should be 4613732."
    (is (= 4613732 (s2/answer))))
)

(deftest testing-solution-3
  (testing "The largest prime factor of 600851475143 is 6857."
    (is (= 6857 (s3/answer))))
)

(deftest testing-solution-4
  (testing "The largest palindrome made from the product of two 3-digit numbers should be 906609."
    (is (= 906609 (s4/answer))))
)

(deftest testing-solution-5
  (testing "The least common multiple of the numbers 1 through 20 should be 232792560."
    (is (= 232792560 (s5/answer))))
)

(deftest testing-solution-6
  (testing "The difference between the sum of the squares of the first one hundred natural numbers and the square of their sum should be 25164150."
    (is (= 25164150 (s6/answer))))
)

(deftest testing-solution-7
  (testing "The 10001st prime should be 10743."
    (is (= 104743 (s7/answer))))
)

(deftest testing-solution-8
  (testing "The greatest product of five consecutive digits in the 1000-digit number should be 40824."
    (is (= 40824 (s8/answer))))
)

(deftest testing-solution-9
  (testing "The product of the only Pythagorean triple whose sum is 1000 should be 31875000."
    (is (= 31875000 (s9/answer))))
)

(deftest testing-solution-10
  (testing "The sum of all primes below 2000000 should be 142913828922."
    (is (= 142913828922 (s10/answer))))
)


(run-tests)