(ns aoc22.day2.part2
  (:require [clojure.string]
            [aoc22.utils :refer [debug-value sum]]
            [aoc22.day2.constants :refer [shape-values result-values]]
            [aoc22.day2.shared :refer [get-points-of-round]]
            [aoc22.day2.inputs :refer [example-input-day2 input-challenge-two]]))

(def choice-mapping {:A :rock
                     :B :paper
                     :C :scissors
                     :X :lose
                     :Y :draw
                     :Z :win})

(defn parse-input [input]
  (mapv
    (fn [round]
      (let [choices (.split round " ")
            opponent-choice ((keyword (nth choices 0)) choice-mapping)
            my-choice ((keyword (nth choices 1)) choice-mapping)]
        [opponent-choice my-choice])
    )
    input))

(defn transform-outcome-to-choice [opponent-choice outcome]
  (cond
    (or
      (and (= opponent-choice :rock) (= outcome :win))
      (and (= opponent-choice :paper) (= outcome :draw))
      (and (= opponent-choice :scissors) (= outcome :lose)))
    :paper

    (or
      (and (= opponent-choice :paper) (= outcome :win))
      (and (= opponent-choice :scissors) (= outcome :draw))
      (and (= opponent-choice :rock) (= outcome :lose)))
    :scissors
    
    :else :rock))

(defn transform-outcome-in-round-to-choice [round]
  (let [opponent-choice (nth round 0)
        my-choice (nth round 1)]
    [opponent-choice (transform-outcome-to-choice opponent-choice my-choice)]))

(defn solve-part-two [input]
  (->> (parse-input input)
       (mapv transform-outcome-in-round-to-choice)
       (mapv get-points-of-round)
       (sum)))

(comment (solve-part-two example-input-day2))
