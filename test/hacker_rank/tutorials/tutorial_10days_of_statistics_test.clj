(ns hacker-rank.tutorials.tutorial-10days-of-statistics-test
  (:require [clojure.test :refer :all])
  (:require [hacker-rank.tutorials.tutorial-10days-of-statistics :refer :all]))

(deftest mean-test
  (testing ["utility"
            "mean"])
  (is (= [0.0 43900.6]
         (map mean [[] [64630 11735 14216 99233 14470 4978 73429 38120 51135 67060]]))))

(deftest mean-median-mode-test
  (testing ["Day 0: Mean, Median, and Mode"
            "https://www.hackerrank.com/challenges/s10-basic-statistics/problem"])
  (is (= [43900.6 44627.5 4978]
         (let [arr [64630 11735 14216 99233 14470 4978 73429 38120 51135 67060]]
           [(mean arr) (median arr) (mode arr)]))))

(deftest weighted-mean-test
  (testing ["Day 0: Weighted Mean"
            "https://www.hackerrank.com/challenges/s10-weighted-mean/problem"]
    (is (= 32.0
           (weighted-mean [10 40 30 50 20] [1 2 3 4 5])))))
