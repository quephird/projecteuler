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

(deftest testing-digits
  (testing "The digits of a single digit number should simply be that number"
    (is (= (digits 4) '(4))))
  (testing "The digits of 42 should be the list (4 2)"
    (is (= (digits 42) '(4 2))))
  (testing "The digits of 42222 should be (4 2 2 2 2), no duplicates removed"
    (is (= (digits 42222) '(4 2 2 2 2))))
)

(deftest testing-reverse-int
  (testing "The reverse of a single digit number should simply be that number"
    (is (= (reverse-int 4) 4)))
  (testing "The reverse of 123456789 should be 987654321"
    (is (= (reverse-int 123456789) 987654321)))
  (testing "The reverse of 1223322244 should be 4422233221, no duplicates removed"
    (is (= (reverse-int 1223322244) 4422233221)))
)

(deftest testing-palindrome?
  (testing "Single-digit numbers should be considered palindromes"
    (is (true? (palindrome? 4))))
  (testing "42 is not a palindrome"
    (is (false? (palindrome? 42))))
  (testing "123454321 is a palindrome"
    (is (true? (palindrome? 123454321))))
)
