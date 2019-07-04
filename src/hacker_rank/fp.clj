(ns hacker-rank.fp)

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

(defn fact [x]
  (loop [n x
         v 1]
    (if (= n 1)
      v
      (recur (dec n) (* v n)))))

(defn exp [x e]
  (loop [n e
         v x]
    (if (= n 1)
      v
      (recur (dec n) (* x v)))))

(defn round [precision d]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/round (* d factor)) factor)))

(defn evaluating-exponential [x]
  (loop [n 9
         v 1.0]
    (if (= n 1)
      (round 4 (+ v (/ (exp x n) (fact n))))
      (recur (dec n) (+ v (/ (exp x n) (fact n)))))))