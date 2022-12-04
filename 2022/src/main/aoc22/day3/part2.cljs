(ns aoc22.day3.part2
  (:require [aoc22.day3.inputs :refer [example-input-day3 input-challenge-three]]
            [aoc22.day3.constants :refer [type-values]]
            [aoc22.utils :refer [into-last into-new find-common sum]]))

(defn parse-input [input]
  (let [rucksack-count (count input)]
    (loop [groups [[]]
           index 0]
      (if (= index rucksack-count)
        groups
        (let [rucksack (nth input index)]
          (recur
            (if (and
                  (= 0 (mod index 3))
                  (not= 0 index))
              (into-new groups rucksack)
              (into-last groups rucksack))
            (+ index 1)))))))

(defn solve-part-two [input]
  (->> (parse-input input)
       (mapv find-common)
       (mapv #((keyword %1) type-values))
       (sum)))
