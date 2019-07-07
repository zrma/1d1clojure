(ns hacker-rank.fp
  (:require [hacker-rank.utils :refer :all]))

(defn solve-me-first [x y]
  (+ x y))

(defn hello-world []
  (print "Hello World"))

(defn hello-word-n-times [n]
  (dorun
   (for [_ (range n)]
     (println "Hello World"))))

(defn list-replication [n l]
  (mapcat (partial repeat n) l))

(defn filter-array [delim l]
  (filter #(> delim %) l))

(defn filter-positions-in-a-list [l]
  (take-nth 2 (rest l)))

(defn array-of-n-elements [n]
  (range n))

(defn reverse-a-list [n]
  (reverse n))

(defn sum-of-odd-elements [l]
  (reduce + (filter odd? l)))

(defn list-length [l]
  (count l))

(defn update-list [l]
  (map (fn [x] (if (<= 0 x) x (- x))) l))

(defn fact [n]
  (->> (inc n)
       (range)
       (rest)
       (reduce *)))

(defn evaluating-exponential [n]
  (loop [i 10
         res 1.0]
    (if (= i 1)
      (round 4 res)
      (recur (dec i) (+ res (/ (Math/pow n (dec i)) (fact (dec i))))))))

(defn algebraic-expr [coefficients exponents x]
  (reduce-kv (fn [res coefficient exponent]
               (->> exponent
                    (Math/pow x)
                    (* coefficient)
                    (+ res)))
             0.0 (zipmap coefficients exponents)))

;; 콘솔 읽기 유틸 함수
;
;(require '[clojure.string :as str])
;
;(defn read-split []
;  (map #(Long/parseLong %) (-> (read-line)
;                               (str/split #" "))))

(defn area-under-curves-and-volume-of-revolving-a-curve [a b [left right']]
  (let [delta 0.001
        right (+ right' delta)]
    (vector (* delta
               (reduce + (map #(algebraic-expr a b %)
                              (range left right delta))))
            (* Math/PI
               (reduce + (map #(-> (algebraic-expr a b %)
                                   (Math/pow 2)
                                   (* delta))
                              (range left right delta)))))))
