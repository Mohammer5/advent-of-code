(ns aoc22.day1.main
  (:require [clojure.string]
            [aoc22.utils :refer [max-num-in-col
                                 sum
                                 without-index
                                 debug-value]]
            [aoc22.day1.inputs :refer [input-challenge-one]]))

(defn parse-input [input]
  (let [splitted (clojure.string/split-lines input)]
    (reduce
      #(if (clojure.string/blank? %2)
         (conj %1 [])
         (let [last-cals (last %1)
               cal-as-int (js/parseInt %2)
               with-latest-cal (conj last-cals cal-as-int)
               without-last (pop %1)]
           (conj without-last with-latest-cal))
      )
      [[]]
      splitted)
  ))

(defn find-max-calories [calories]
  (reduce (fn [cur next] (if (> next cur) next cur)) calories))

(defn sum-calories [unsummed]
  (mapv sum unsummed))

(defn determine-max-cal [summed-calories]
  (find-max-calories summed-calories))

(defn determine-top-three-cals [summed-calories]
  (loop [cur-sums summed-calories
         max-three []]
    (let [max-num (max-num-in-col cur-sums)
          index-highest-cal (.indexOf cur-sums max-num)
          max-three-count (count max-three)]
      (if (= max-three-count 3)
        max-three
        (recur
          (vec (without-index cur-sums index-highest-cal))
          (conj max-three max-num))))))

(defn solve-part-one [input]
  (-> (parse-input input)
      (sum-calories)
      determine-max-cal))

(defn solve-part-two [input]
  (-> (parse-input input)
      (sum-calories)
      (determine-top-three-cals)
      (sum)))

(defn init []
  (println "> part 1: " (solve-part-one input-challenge-one))
  (println "> part 2: " (solve-part-two input-challenge-one)))
