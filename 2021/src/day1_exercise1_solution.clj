(ns day1_exercise1_solution
  (:require [day1data]))

(defn main []
  (prn (reduce-kv
    (fn [acc index cur]
      (cond
        (= index 0) acc
        (> cur (get day1data/input (dec index))) (inc acc)
        :else acc))
    0
    day1data/input)))
