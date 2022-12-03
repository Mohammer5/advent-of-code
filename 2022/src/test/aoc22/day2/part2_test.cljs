(ns aoc22.day2.part2-test
  (:require [cljs.test :refer (deftest is)]
            [aoc22.day2.part2 :refer [solve-part-two]]
            [aoc22.day2.inputs :refer [example-input-day2]]))

(deftest should-return-12
  (is (= (solve-part-two example-input-day2) 12)))
