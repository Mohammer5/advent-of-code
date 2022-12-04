(ns aoc22.day3.main
  (:require [aoc22.day3.part1 :refer [solve-part-one]]
            [aoc22.day3.part2 :refer [solve-part-two]]
            [aoc22.day3.inputs :refer [input-challenge-three]]))

(defn day3 []
  (println "> part 1: " (solve-part-one input-challenge-three))
  (println "> part 2: " (solve-part-two input-challenge-three))
)
