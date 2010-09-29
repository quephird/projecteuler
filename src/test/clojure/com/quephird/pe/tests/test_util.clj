(ns com.quephird.pe.tests.test-util
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

(deftest testing-digit-sum
  (testing "The sum of the digits of a single digit number should simply be that number"
    (is (= (digit-sum 4) 4)))
  (testing "The sum of the digits of 1234 should be 10"
    (is (= (digit-sum 1234) 10)))
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

(deftest testing-gcd
  (testing "The GCD of any number and 1 should be 1"
    (is (= (gcd 42 1) 1)))
  (testing "The GCD of any list of numbers containing 1 should be 1"
    (is (= (gcd 42 13 5 1 31415) 1)))
  (testing "The GCD of two relatively prime numbers should be 1"
    (is (= (gcd 9 4) 1)))
  (testing "The GCD of a list of pairwise relatively prime numbers should be 1"
    (is (= (gcd 3 7 8 55) 1)))
  (testing "The GCD of a number and a multiple of that number should be that number"
    (is (= (gcd 7 42) 7)))
)

(deftest testing-lcm
  (testing "The LCM of any number and 1 should be that number"
    (is (= (lcm 42 1) 42)))
  (testing "The LCM of two relatively prime numbers should be their product"
    (is (= (lcm 9 4) 36)))
  (testing "The LCM of a list of pairwise relatively prime numbers should be their product"
    (is (= (lcm 3 7 8 55) (* 3 7 8 55))))
)

(deftest testing-power
  (testing "A number raised to the zeroth power is simply 1"
    (is (= (power 3 0) 1)))
)

(run-tests)
