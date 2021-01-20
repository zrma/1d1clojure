(ns le_et_code.lv0easy)

(defn two-sum [coll target]
  (let [idx (range (count coll))]
    (first (for [i idx
                 j idx
                 :when (and (not= i j)
                            (= target (+ (nth coll i)
                                         (nth coll j))))] [i j]))))