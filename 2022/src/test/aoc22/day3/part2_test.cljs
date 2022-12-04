(ns aoc22.day3.part2-test
  (:require [cljs.test :refer (deftest is)]
            [aoc22.day3.part2 :refer [solve-part-two]]
            [aoc22.day3.inputs :refer [example-input-day3]]))

(deftest should-return-70
  (is (= (solve-part-two example-input-day3) 70)))
