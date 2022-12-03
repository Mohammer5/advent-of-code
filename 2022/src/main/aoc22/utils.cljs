(ns aoc22.utils)

(defn max-num-in-col [col]
  (reduce #(if (> %2 %1) %2 %1) col))

(defn sum [col]
  (reduce + col))

(defn without-index [col index]
  (let [before-index (subvec col 0 index)
        after-index (subvec col (+ index 1))]
    (concat before-index after-index)))

(defn debug-value [value]
  (println "DEBUG-VALUE: " value)
  value)
