(ns hacker-rank.fp-test
  (:require [clojure.test :refer :all]
            [hacker-rank.fp :refer :all]))


(deftest hello-world-test
  (testing ["Hello World"
            "https://www.hackerrank.com/challenges/fp-hello-world/problem"])
  (is (= "Hello World" (with-out-str (hello-world)))))


(deftest solve-me-first-test
  (testing ["Solve Me First FP"
            "https://www.hackerrank.com/challenges/fp-solve-me-first/problem"]
    (is (= (+ 3 5) (solve-me-first 3 5)))))

(deftest hello-word-n-times-test
  (testing ["Hello World N Times"
            "https://www.hackerrank.com/challenges/fp-hello-world-n-times/problem"]
    (is (= (with-out-str (dorun (for [_ (range 3)] (println "Hello World"))))
           (with-out-str (hello-word-n-times 3))))))
