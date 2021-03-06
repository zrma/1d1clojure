(ns hacker-rank.tutorials.tutorial-10days-of-statistics-test
  (:require [clojure.test :refer :all])
  (:require [hacker-rank.utils :refer :all])
  (:require [hacker-rank.tutorials.tutorial-10days-of-statistics :refer :all]))

(deftest mean-test
  (testing ["utility"
            "mean"])
  (is (= [0.0 43900.6]
         (map mean [[] [64630 11735 14216 99233 14470 4978 73429 38120 51135 67060]]))))

(deftest median-test
  (is (= [0.0 38120 44627.5]
         (map median [[]
                      [64630 11735 14216 99233 14470 4978 73429 38120 51135]
                      [64630 11735 14216 99233 14470 4978 73429 38120 51135 67060]]))))

(deftest mean-median-mode-test
  (testing ["Day 0: Mean, Median, and Mode"
            "https://www.hackerrank.com/challenges/s10-basic-statistics/problem"])
  (is (= [43900.6 44627.5 4978]
         (let [arr [64630 11735 14216 99233 14470 4978 73429 38120 51135 67060]]
           [(mean arr) (median arr) (mode arr)]))))

(deftest weighted-mean-test
  (testing ["Day 0: Weighted Mean"
            "https://www.hackerrank.com/challenges/s10-weighted-mean/problem"]
    (is (= [32.0 0.0]
           (map (fn [[nums weights]] (weighted-mean nums weights))
                [[[10 40 30 50 20] [1 2 3 4 5]] [[] []]])))))

(deftest quartiles-test
  (testing ["Day 1: Quartiles"
            "https://www.hackerrank.com/challenges/s10-quartiles/problem"]
    (is (= [[6 12 16] [7 13 15] [4 11 15]]
           (map #(quartiles % int) [[3 7 8 5 12 14 21 13 18]
                                    [3 7 8 5 12 14 21 15 18 14]
                                    [4 17 7 14 18 12 3 16 10 4 4 12]])))))

(deftest inter-quartile-range-test
  (testing ["Day 1: Inter-quartile Range"
            "https://www.hackerrank.com/challenges/s10-interquartile-range/problem"]
    (is (= [9.0 5.0 20.0 8.0]
           (map (fn [[num-coll frequency-coll]] (inter-quartile-range num-coll frequency-coll))
                [[[6 12 8 10 20 16]
                  [5 4 3 2 1 5]]
                 [[10 40 30 50 20 10 40 30 50 20 1 2 3 4 5 6 7 8 9 10]
                  [1 2 3 4 5 6 7 8 9 10 10 40 30 50 20 10 40 30 50 20]]
                 [[10 40 30 50 20 10 40 30 50 20]
                  [1 2 3 4 5 6 7 8 9 10]]
                 [[6 12 8 10 20 16]
                  [5 6 7 8 9 10]]])))))

(deftest std-dev-test
  (testing ["Day 1: Standard Deviation"
            "https://www.hackerrank.com/challenges/s10-standard-deviation/problem"]
    (is (= 14.1
           (std-dev [10 40 30 50 20])))))

(deftest binomial-distribution1-test
  (testing ["Day 4: Binomial Distribution I"
            "https://www.hackerrank.com/challenges/s10-binomial-distribution-1/problem"]
    (is (= 0.696
           (binomial-distribution1 1.09 1)))))

(deftest binomial-distribution2-test
  (testing ["Day 4: Binomial Distribution II"
            "https://www.hackerrank.com/challenges/s10-binomial-distribution-2/problem"]
    (is (= [0.891 0.342]
           (binomial-distribution2 12 10)))))

(deftest geometric-distribution1-test
  (testing ["Day 4: Geometric Distribution I"
            "https://www.hackerrank.com/challenges/s10-geometric-distribution-1/problem"]
    (is (= 0.066
           (geometric-distribution1 1 3 5)))))

(deftest geometric-distribution2-test
  (testing ["Day 4: Geometric Distribution II"
            "https://www.hackerrank.com/challenges/s10-geometric-distribution-2/problem"]
    (is (= 0.868
           (geometric-distribution2 1 3 5)))))

(deftest poisson-distribution1-test
  (testing ["Day 5: Poisson Distribution II"
            "https://www.hackerrank.com/challenges/s10-poisson-distribution-1/problem"]
    (is (= 0.067
           (poisson-distribution1 5 2.5)))))

(deftest poisson-distribution2-test
  (testing ["Day 5: Poisson Distribution II"
            "https://www.hackerrank.com/challenges/s10-poisson-distribution-2/problem"]
    (is (= [226.176 286.100]
           (poisson-distribution2 0.88 1.55)))))

(deftest probability-density-function-test
  (testing ["utility" "pdf"]
    (is (= (round 10 (/ 1 (* (Math/sqrt 2) (Math/sqrt Math/PI))))
           (probability-density-function 0 1 0)))))

(deftest normal-distribution1-test
  (testing ["Day 5: Normal Distribution I"
            "https://www.hackerrank.com/challenges/s10-normal-distribution-1/problem"]
    (is (= [0.401 0.341]
           (normal-distribution1 20 2 19.5 20 22)))))

(deftest normal-distribution2-test
  (testing ["Day 5: Normal Distribution II"
            "https://www.hackerrank.com/challenges/s10-normal-distribution-2/problem"]
    (is (= [15.87 84.13 15.87]
           (normal-distribution2 70 10 80 60)))))

(deftest the-central-limit-theorem-1-test
  (testing ["Day 6: The Central Limit Theorem I"
            "https://www.hackerrank.com/challenges/s10-the-central-limit-theorem-1/problem"]
    (is (= 0.0098
           (the-central-limit-theorem-1 9800 49 205 15)))))

(deftest the-central-limit-theorem-2-test
  (testing ["Day 6: The Central Limit Theorem II"
            "https://www.hackerrank.com/challenges/s10-the-central-limit-theorem-2/problem"]
    (is (= 0.6915
           (the-central-limit-theorem-2 250 100 2.4 2.0)))))

(deftest the-central-limit-theorem-3-test
  (testing ["Day 6: The Central Limit Theorem III"
            "https://www.hackerrank.com/challenges/s10-the-central-limit-theorem-3/problem"]
    (is (= [484.32 515.68]
           (the-central-limit-theorem-3 100 500 80 1.96)))))
