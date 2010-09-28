(ns com.quephird.pe.tests.test-divutils
  (:use clojure.test com.quephird.pe.util)
)

(deftest testing-divides?
  (testing "5 should not be divisible by 2"
    (is (false? (divides? 5 2))))
  (testing "18 should be divisible by 3"
    (is (true? (divides? 18 3))))
)

(deftest testing-list-sum
  (testing "Sum of elements of (1 2 3 4) should be 10"
    (is (= (list-sum '(1 2 3 4)) 10)))
)

(deftest testing-list-prod
  (testing "Product of elements of (1 2 3 4) should be 24"
    (is (= (list-prod '(1 2 3 4)) 24)))
)
