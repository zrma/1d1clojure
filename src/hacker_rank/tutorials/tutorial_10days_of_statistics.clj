(ns hacker-rank.tutorials.tutorial-10days-of-statistics)

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
    (if (odd? cnt)
      (nth sorted half)
      (let [bottom (dec half)
            bottom-val (nth sorted bottom)
            top-val (nth sorted half)]
        (mean [bottom-val top-val])))))

(defn mode [coll]
  (let [freq (frequencies coll)
        occur (group-by val freq)
        modes (last (sort occur))
        modes (->> modes
                   val
                   (map key))]
    (first (sort modes))))