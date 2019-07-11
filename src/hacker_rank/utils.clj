(ns hacker-rank.utils)

(defn round [precision n]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/round (* n factor)) factor)))

(defn fact [n]
  (->> (inc n)
       (range)
       (rest)
       (reduce *)))

(defn combination [n k]
  (let [numerator (fact n)
        denominator (* (fact k) (fact (- n k)))]
    (/ numerator denominator)))