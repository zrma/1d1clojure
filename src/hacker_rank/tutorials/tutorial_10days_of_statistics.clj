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

(defn quartiles [coll]
  (let [sorted (sort coll)
        q2 (median sorted)
        cnt (count sorted)
        half (quot cnt 2)
        [lower upper'] (split-at half sorted)
        upper (if (odd? cnt)
                (rest upper')
                upper')
        q1 (median lower)
        q3 (median upper)]
    (map int [q1 q2 q3])))

(defn inter-quartile-range [num-coll frequency-coll]
  (let [total (mapcat #(repeat %2 %1) num-coll frequency-coll)
        [q1 _ q3] (quartiles total)
        result (- q3 q1)]
    (float result)))