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

(defn binomial-distribution2 [p n]
  (let [f (fn [k] (binomial-distribution n (/ p 100) k))
        res1 (map f (range 3))
        res2 (map f (range 2 (inc n)))]
    [(round 3 (apply + res1)) (round 3 (apply + res2))]))

(defn geometric-distribution [p k]
  (* (Math/pow (- 1 p) (dec k)) p))

(defn geometric-distribution1 [numerator denominator k]
  (round 3 (geometric-distribution (/ numerator denominator) k)))

(defn geometric-distribution2 [numerator denominator k]
  (round 3 (apply + (map #(geometric-distribution (/ numerator denominator) %)
                         (range 1 (inc k))))))

(defn poisson-distribution [n λ]
  (let [numerator (* (Math/pow λ n) (Math/exp (- λ)))
        denominator (fact n)]
    (/ numerator denominator)))

(defn poisson-distribution1 [n λ]
  (round 3 (poisson-distribution n λ)))

(defn poisson-distribution2 [poisson1 poisson2]
  (let [x-square1 (+ poisson1 (Math/pow poisson1 2))
        x-square2 (+ poisson2 (Math/pow poisson2 2))]
    (map #(round 3 %) [(+ 160 (* 40 x-square1))
                       (+ 128 (* 40 x-square2))])))

(defn probability-density-function [μ σ x]
  (let [ex (- (/ (Math/pow (- x μ) 2)
                 (* 2 σ σ)))
        numerator (Math/exp ex)
        denominator (* σ
                       (Math/sqrt (* 2 Math/PI)))]
    (round 10 (/ numerator denominator))))

(defn error-function [x]
  (let [sign (if (neg? x) -1 1)
        p 0.3275911
        t (/ 1 (inc (* p (Math/abs x))))
        arr [0.254829592 -0.284496736 1.421413741 -1.453152027 1.061405429]
        res (- 1 (* t
                    (Math/exp (- (Math/pow x 2)))
                    (reduce #(+ (* %1 t) %2) (reverse arr))))]
    (* sign res)))

(defn cumulative-distribution-function [μ σ x]
  (* (/ 1 2)
     (inc (error-function (/ (- x μ) (* σ (Math/sqrt 2)))))))

(defn normal-distribution1 [μ σ x1 x2-1 x2-2]
  (let [norm1 (cumulative-distribution-function μ σ x1)
        norm2-1 (cumulative-distribution-function μ σ x2-1)
        norm2-2 (cumulative-distribution-function μ σ x2-2)]
    (map #(round 3 %) [norm1 (- norm2-2 norm2-1)])))

(defn normal-distribution2 [μ σ x y]
  (map #(round 2 (* 100 %)) [(- 1 (cumulative-distribution-function μ σ x))
                             (- 1 (cumulative-distribution-function μ σ y))
                             (cumulative-distribution-function μ σ y)]))