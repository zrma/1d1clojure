(ns hacker-rank.fp-test
  (:require [clojure.test :refer :all]
            [hacker-rank.fp :refer :all]))

(deftest hello-world-test
  (testing ["Hello World"
            "https://www.hackerrank.com/challenges/fp-hello-world/problem"])
  (is (= "Hello World"
         (with-out-str (hello-world)))))

(deftest solve-me-first-test
  (testing ["Solve Me First FP"
            "https://www.hackerrank.com/challenges/fp-solve-me-first/problem"]
    (is (= (+ 3 5)
           (solve-me-first 3 5)))))

(deftest hello-word-n-times-test
  (testing ["Hello World N Times"
            "https://www.hackerrank.com/challenges/fp-hello-world-n-times/problem"]
    (is (= (with-out-str (dorun
                          (for [_ (range 3)]
                            (println "Hello World"))))
           (with-out-str (hello-word-n-times 3))))))

(deftest list-replication-test
  (testing ["List Replication"
            "https://www.hackerrank.com/challenges/fp-list-replication/problem"]
    (is (= (with-out-str (doseq
                          [x (mapcat (partial repeat 3) [1 2 3])]
                           (println x)))
           (with-out-str (doseq
                          [x (list-replication 3 [1 2 3])]
                           (println x)))))))

(deftest filter-array-test
  (testing ["Filter Array"
            "https://www.hackerrank.com/challenges/fp-filter-array/problem"]
    (is (= [2 1 0]
           (filter-array 3 [10 9 8 2 7 5 1 3 0])))))

(deftest filter-positions-in-a-list-test
  (testing ["Filter Positions in a List"
            "https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem"]
    (is (= [5 4 7 8]
           (filter-positions-in-a-list [2 5 3 4 6 7 9 8])))))

(deftest array-of-n-elements-test
  (testing ["Array Of N Elements"
            "https://www.hackerrank.com/challenges/fp-array-of-n-elements/problem"]
    (is (= [0 1 2 3]
           (array-of-n-elements 4)))))

(deftest reverse-a-list-test
  (testing ["Reverse a List"
            "https://www.hackerrank.com/challenges/fp-reverse-a-list/problem"]
    (is (= [0 28 4 18 17 26 28 3 22 19]
           (reverse-a-list [19 22 3 28 26 17 18 4 28 0])))))

(deftest sum-of-odd-elements-test
  (testing ["Sum of Odd Elements"
            "https://www.hackerrank.com/challenges/fp-sum-of-odd-elements/problem"]
    (is (= 16
           (sum-of-odd-elements [3 2 4 6 5 7 8 0 1])))))

(deftest list-length-test
  (testing ["List Length"
            "https://www.hackerrank.com/challenges/fp-list-length/problem"]
    (is (= 10
           (list-length [2 5 1 4 3 7 8 6 0 9])))))

(deftest update-list-test
  (testing ["Update List"
            "https://www.hackerrank.com/challenges/fp-update-list/problem"]
    (is (= [2 4 3 1 23 4 54]
           (update-list [2 -4 3 -1 23 -4 -54])))))

(deftest fact-test
  (testing ["utility - factorial"]
    (is (= [1 2 6 24 120]
           (map fact [1 2 3 4 5])))))

(deftest round-test
  (testing ["utility - round"]
    (is (= [0.001 10.1235 9.5556]
           (map (partial round 4) [0.001 10.123456 9.555556])))))

(deftest evaluating-exponential-test
  (testing ["Evaluating e^x"
            "https://www.hackerrank.com/challenges/eval-ex/problem"]
    (is (= [2423600.1887 143.6895 1.6487 0.6065]
           (map evaluating-exponential [20.0000 5.0000 0.5000 -0.5000])))))

(deftest algebraic-expr-test
  (testing ["utility"
            "algebraic-expr"]
    (is (= [15.0 6524928.0]
           (map #(algebraic-expr [1 2 3 4 5] [6 7 8 9 10] %) [1 4])))))

(deftest area-under-curves-and-volume-of-revolving-a-curve-test
  (testing ["Area Under Curves and Volume of Revolving a Curve"
            "https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv/problem"]
    (is (= [414.02299999997854 36024.18118228868]
           (area-under-curves-and-volume-of-revolving-a-curve [1 2] [0 1] [2 20])))))
