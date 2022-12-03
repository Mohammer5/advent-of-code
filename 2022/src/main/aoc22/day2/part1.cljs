(ns aoc22.day2.part1
  (:require [clojure.string]
            [aoc22.utils :refer [debug-value sum]]
            [aoc22.day2.constants :refer [shape-values result-values]]
            [aoc22.day2.shared :refer [get-points-of-round]]
            [aoc22.day2.inputs :refer [example-input-day2 input-challenge-two]]))

(println example-input-day2)

(def choice-mapping {:A :rock
                     :B :paper
                     :C :scissors
                     :X :rock
                     :Y :paper
                     :Z :scissors})

(defn parse-input [input]
  (mapv
    (fn [round]
      (let [choices (.split round " ")
            opponent-choice ((keyword (nth choices 0)) choice-mapping)
            my-choice ((keyword (nth choices 1)) choice-mapping)]
        [opponent-choice my-choice])
    )
    input))

(defn solve-part-one [input]
  (->> (parse-input input)
    (mapv get-points-of-round)
    (sum)))
