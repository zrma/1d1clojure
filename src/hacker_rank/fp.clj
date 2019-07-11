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

(defn list-replication [n coll]
  (mapcat (partial repeat n) coll))

(defn filter-array [delim coll]
  (filter #(> delim %) coll))

(defn filter-positions-in-a-list [coll]
  (take-nth 2 (rest coll)))

(defn array-of-n-elements [n]
  (range n))

(defn reverse-a-list [coll]
  (reverse coll))

(defn sum-of-odd-elements [coll]
  (reduce + (filter odd? coll)))

(defn list-length [coll]
  (count coll))

(defn update-list [coll]
  (map (fn [x] (if (<= 0 x) x (- x))) coll))

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
;(def n (Integer/parseInt (clojure.string/trim (read-line))))
;
;(require '[clojure.string :as str])
;(defn read-split []
;  (map #(Long/parseLong %) (-> (read-line)
;                               (str/split #" "))))

(defn area-under-curves-and-volume-of-revolving-a-curve [a b [begin end']]
  (let [delta 0.001
        end (+ end' delta)]
    (vector (* delta
               (reduce + (map #(algebraic-expr a b %)
                              (range begin end delta))))
            (* Math/PI
               (reduce + (map #(-> (algebraic-expr a b %)
                                   (Math/pow 2)
                                   (* delta))
                              (range begin end delta)))))))
