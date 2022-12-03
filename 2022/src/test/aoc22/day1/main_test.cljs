(ns aoc22.day1.main-test
  (:require [cljs.test :refer (deftest is)]
            [aoc22.day1.main :refer [solve-part-one solve-part-two]]
            [aoc22.day1.inputs :refer [example-input]]))

(deftest should-return-24000
  (is (= (solve-part-one example-input) 24000)))

(deftest should-return-45000
  (is (= (solve-part-two example-input) 45000)))
