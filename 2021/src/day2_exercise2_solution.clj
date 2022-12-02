(ns day2_exercise1_solution
  (:require
    [day2data :refer [input]]
    [clojure.string :as str]))

(defn forward [state amount]
  [(+ (get state 0) amount) (get state 1)])

(defn down [state amount]
  [(get state 0) (+ (get state 1) amount)])

(defn up [state amount]
  [(get state 0) (- (get state 1) amount)])

(defn get-fn-by-command [command]
  (cond
    (= command "forward") forward
    (= command "down") down
    (= command "up") up))

(defn main []
  (prn (reduce *
    (reduce
      (fn [state command-string]
        (let [[command amount] (str/split command-string #" ")]
          ((get-fn-by-command command) state (Integer/parseInt amount))))
      [0 0]
      input))))
