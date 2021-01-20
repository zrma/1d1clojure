(ns le_et_code.lv0easy-test
  (:require [clojure.test :refer :all])
  (:require [le_et_code.lv0easy :refer :all]))

(deftest two-sum-test
  (testing ["Two Sum"
            "https://leetcode.com/problems/two-sum/"])
  (is (= (two-sum [2 7 11 15] 9)
         [0 1])))
