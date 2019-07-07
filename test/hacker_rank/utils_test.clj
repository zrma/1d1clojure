(ns hacker-rank.utils-test
  (:require [clojure.test :refer :all])
  (:require [hacker-rank.utils :refer :all]))

(deftest round-test
  (testing ["utility"
            "round"]
    (is (= [0.001 10.1235 9.5556]
           (map (partial round 4) [0.001 10.123456 9.555556])))))
