(ns aoc22.day2.shared
  (:require [clojure.string]
            [aoc22.day2.constants :refer [shape-values result-values]]))

(defn determine-outcome [opponent-choice my-choice]
  (cond
    (or
      (and (= opponent-choice :rock) (= my-choice :rock))
      (and (= opponent-choice :paper) (= my-choice :paper))
      (and (= opponent-choice :scissors) (= my-choice :scissors)))
    :draw

    (or
      (and (= opponent-choice :rock) (= my-choice :paper))
      (and (= opponent-choice :paper) (= my-choice :scissors))
      (and (= opponent-choice :scissors) (= my-choice :rock)))
    :win

    :else :loss))

(defn get-points-of-round [round]
  (let [opponent-choice (nth round 0)
        my-choice (nth round 1)
        outcome (determine-outcome opponent-choice my-choice)
        shape-points (get shape-values my-choice)
        result-points (get result-values outcome)]
    (+ shape-points result-points)))
