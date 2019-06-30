(ns hacker-rank.fp)

(defn solve-me-first [x y]
  (+ x y))

(defn hello-world []
  (print "Hello World"))

(defn hello-word-n-times [n]
  (dorun
    (for [_ (range n)] (println "Hello World"))))
