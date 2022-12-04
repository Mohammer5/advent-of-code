(ns aoc22.day3.part1
  (:require [aoc22.day3.inputs :refer [example-input-day3 input-challenge-three]]
            [aoc22.day3.constants :refer [type-values]]
            [aoc22.utils :refer [in? sum]]))

(defn parse-input [input]
  (mapv
    (fn [all-items]
      (let [item-count (count all-items)
            compartment-size (/ item-count 2)
            first-compartment (subs all-items 0 compartment-size)
            second-compartment (subs all-items compartment-size)]
        [first-compartment second-compartment]))
    input))

(defn get-common-items [backpack]
  (let [first-compartment (nth backpack 0)
        second-compartment (nth backpack 1)
        compartment-size (count first-compartment)]
    (loop [common-items []
           index 0]
      (if (= index compartment-size)
        common-items
        (let [cur-char (nth first-compartment index)
              in-second-compartment (.includes second-compartment cur-char)
              newly-found (not (in? cur-char common-items))]
          (recur
            (if (and in-second-compartment newly-found)
              (vec (conj common-items cur-char))
              common-items)
            (+ index 1)))))))

(defn get-values-for-items [items]
  (mapv #((keyword %1) type-values) items))

(defn solve-part-one [input]
  (->> (parse-input input)
       (mapv get-common-items)
       (mapv get-values-for-items)
       (flatten)
       (vec)
       (sum)))
