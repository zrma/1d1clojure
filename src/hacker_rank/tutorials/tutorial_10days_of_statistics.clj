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