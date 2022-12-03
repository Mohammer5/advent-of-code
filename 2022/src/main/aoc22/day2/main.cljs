(ns aoc22.day2.main
  (:require [aoc22.day2.part1 :refer [solve-part-one]]
            [aoc22.day2.part2 :refer [solve-part-two]]
            [aoc22.day2.inputs :refer [input-challenge-two]]))

(defn day2 []
  (println "> part 1: " (solve-part-one input-challenge-two))
  (println "> part 2: " (solve-part-two input-challenge-two))
)
