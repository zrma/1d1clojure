(ns hacker-rank.tutorials.tutorial-10days-of-statistics
  (:require [hacker-rank.utils :refer :all]))

(defn mean [coll]
  (let [sum (float (apply + coll))
        cnt (count coll)]
    (if (pos? cnt)
      (/ sum cnt)
      (float 0))))

(defn median [coll]
  (let [sorted (sort coll)
        cnt (count sorted)
        half (quot cnt 2)]
    (if (pos? cnt)
      (if (odd? cnt)
        (nth sorted half)
        (let [bottom (dec half)
              bottom-val (nth sorted bottom)
              top-val (nth sorted half)]
          (mean [bottom-val top-val])))
      (float 0))))

(defn mode [coll]
  (let [freq (frequencies coll)
        occur (group-by val freq)
        modes (last (sort occur))
        modes (->> modes
                   val
                   (map key))]
    (first (sort modes))))

(defn weighted-mean [nums weights]
  (let [weighted-sum (apply + weights)
        weighted-num (apply + (map (fn [[num weight]] (* num weight))
                                   (map vector nums weights)))]
    (if (pos? weighted-num)
      (round 1 (/ weighted-num weighted-sum))
      (float 0))))

(defn quartiles [coll scale-fn]
  (let [sorted (sort coll)
        q2 (median sorted)
        cnt (count sorted)
        [lower upper'] (split-at (quot cnt 2) sorted)
        upper (if (odd? cnt)
                (rest upper')
                upper')
        q1 (median lower)
        q3 (median upper)]
    (map scale-fn [q1 q2 q3])))

(defn inter-quartile-range [num-coll frequency-coll]
  (let [total (mapcat #(repeat %2 %1) num-coll frequency-coll)
        [q1 _ q3] (quartiles total #(round 1 %))
        result (- q3 q1)]
    (round 1 result)))

(defn std-dev [coll]
  (let [m (mean coll)
        cnt (count coll)
        variance (apply + (map #(Math/pow (- % m) 2) coll))]
    (round 1 (Math/sqrt (/ variance cnt)))))

(defn binomial-distribution [n p k]
  (apply * [(combination n k)
            (Math/pow p k)
            (Math/pow (- 1 p) (- n k))]))

(defn binomial-distribution1 [boy girl]
  (let [n 6
        p (/ boy (+ boy girl))
        k-list (range 3 (inc n))]
    (round 3 (apply + (map #(binomial-distribution n p %) k-list)))))