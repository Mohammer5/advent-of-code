(ns aoc22.day2.main-test
  (:require [cljs.test :refer (deftest is)]
            [aoc22.day2.main :refer [solve-part-one]]
            [aoc22.day2.inputs :refer [example-input-day2]]))

(deftest should-return-15
  (is (= (solve-part-one example-input-day2) 15)))
