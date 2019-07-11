(ns hacker-rank.utils-test
  (:require [clojure.test :refer :all])
  (:require [hacker-rank.utils :refer :all]))

(deftest round-test
  (testing ["utility"
            "round"]
    (is (= [0.001 10.1235 9.5556]
           (map (partial round 4) [0.001 10.123456 9.555556])))))

(deftest fact-test
  (testing ["utility"
            "factorial"]
    (is (= [1 2 6 24 120]
           (map fact [1 2 3 4 5])))))

(deftest combination-test
  (testing ["utility"
            "combination"]
    (is (= [10 (combination 5 2)]
           (map (fn [[n k]] (combination n k)) [[5 3] [5 3]])))))
