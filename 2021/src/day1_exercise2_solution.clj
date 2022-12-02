(ns day1_exercise2_solution
  (:require [day1data]))

(defn sum-next-three [col index]
  (reduce
    (fn [acc cur] (+ acc cur))
    0
    (subvec col index (+ index 3))))

(defn main []
  (prn (reduce-kv
    (fn [acc index cur]
      (cond
        (= index 0)
          acc
        (> index (- (count day1data/input) 3))
          acc
        (>
         (sum-next-three day1data/input index)
         (sum-next-three day1data/input (dec index)))
          (inc acc)
        :else
          acc))
    0
    day1data/input)))
