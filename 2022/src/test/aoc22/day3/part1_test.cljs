(ns aoc22.day3.part1-test
  (:require [cljs.test :refer (deftest is)]
            [aoc22.day3.part1 :refer [solve-part-one]]
            [aoc22.day3.inputs :refer [example-input-day3]]))

(deftest should-return-157
  (is (= (solve-part-one example-input-day3) 157)))
