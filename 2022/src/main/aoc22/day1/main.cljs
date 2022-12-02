(ns aoc22.day1.main
  (:require [clojure.string]
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

(defn determine-max-cal-per-elve [unsummed]
  (let [summed-calories (map #(reduce + %) unsummed)]
    (find-max-calories summed-calories)))

(defn determine-max-cal-from-input [input]
  (determine-max-cal-per-elve (parse-input input)))

(defn init []
  (println (determine-max-cal-from-input input-challenge-one)))
