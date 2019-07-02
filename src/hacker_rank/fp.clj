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
  (reduce + (filter #(odd? %) l)))