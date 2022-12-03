(ns aoc22.day2.part1-test
  (:require [cljs.test :refer (deftest is)]
            [aoc22.day2.part1 :refer [solve-part-one]]
            [aoc22.day2.inputs :refer [example-input-day2]]))

(deftest should-return-15
  (is (= (solve-part-one example-input-day2) 15)))
