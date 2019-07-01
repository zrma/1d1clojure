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
