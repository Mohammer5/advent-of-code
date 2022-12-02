(ns day3_exercise1_solution
  (:require
    [day3_exercise1_data :refer [input]]
    [clojure.string :as str])

(defn get-sequences [data]
  (let [len (count (get data 0))]
    (loop [index 0 sequences []]
      (if (= index len)
        sequences
        (recur
          (inc index)
          (let [with-chars (mapv (fn [binary] (get binary index)) data)
                flattened (map (fn [col] (get col 0)) with-chars)]
            (conj sequences flattened)))))))

(defn determine-most-common [cur-sequence]
  (do
    (let
      [len (count cur-sequence)
       with-ones (filter (fn [value] (do (prn value) (= value "1"))) cur-sequence)
       _ (prn with-ones)
       with-ones-length (count with-ones)
       half-length (Math/floor (/ len 2))]
      (if (> with-ones-length half-length) 1 0))))

(defn determine-least-common [cur-sequence]
  (let [len (count cur-sequence)]
    (if (> (count (filter #(= % "1") cur-sequence)) (Math/floor (/ len 2))) 0 1)))

(defn determine-gamma [sequences] 
  (let
    [with-most-common (map determine-most-common sequences)
     number-string (str/join with-most-common "")
     cur-number (Integer/parseInt number-string 10)]))

(defn determine-epsilon [sequences] 
  (let
    [with-least-common (map determine-least-common sequences)
     number-string (str/join with-least-common "")
     cur-number (Integer/parseInt number-string 10)]))

(defn main []
  (let
    [sequences (get-sequences input)
     gamma (determine-gamma sequences)
     ; foo (prn gamma)
     ; epsilon (determine-epsilon sequences)
    ]
    "@TODO"))
    ; (* gamma epsilon))))
