(ns aoc22.day2.main
  (:require [clojure.string]
            [aoc22.utils :refer [debug-value sum]]
            [aoc22.day2.inputs :refer [example-input-day2 input-challenge-two]]))

(println example-input-day2)

(def shape-values {::rock 1
                   ::paper 2
                   ::scissors 3})

(def result-values {::win 6
                    ::draw 3
                    ::loss 0})

(def choice-mapping {:A ::rock
                     :B ::paper
                     :C ::scissors
                     :X ::rock
                     :Y ::paper
                     :Z ::scissors})

(defn parse-input [input]
  (mapv
    (fn [round]
      (let [choices (.split round " ")
            opponent-choice ((keyword (nth choices 0)) choice-mapping)
            my-choice ((keyword (nth choices 1)) choice-mapping)]
        [opponent-choice my-choice])
    )
    input))

(defn determine-outcome [opponent-choice my-choice]
  (cond
    (or
      (and (= opponent-choice ::rock) (= my-choice ::rock))
      (and (= opponent-choice ::paper) (= my-choice ::paper))
      (and (= opponent-choice ::scissors) (= my-choice ::scissors)))
    ::draw

    (or
      (and (= opponent-choice ::rock) (= my-choice ::paper))
      (and (= opponent-choice ::paper) (= my-choice ::scissors))
      (and (= opponent-choice ::scissors) (= my-choice ::rock)))
    ::win

    :else ::loss))

(defn get-points-of-round [round]
  (let [opponent-choice (nth round 0)
        my-choice (nth round 1)
        outcome (determine-outcome opponent-choice my-choice)
        shape-points (get shape-values my-choice)
        result-points (get result-values outcome)]
    (+ shape-points result-points)))

(defn map-rounds-to-points [rounds]
  (map get-points-of-round rounds))

(defn solve-part-one [input]
  (->> (parse-input input)
    (mapv get-points-of-round)
    (sum)))

(defn day2 []
  (println "> part 1: " (solve-part-one input-challenge-two))
)
