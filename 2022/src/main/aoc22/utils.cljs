(ns aoc22.utils)

(defn max-num-in-col [col]
  (reduce #(if (> %2 %1) %2 %1) col))

(defn sum [col]
  (reduce + col))

(defn without-index [col index]
  (let [before-index (subvec col 0 index)
        after-index (subvec col (+ index 1))]
    (concat before-index after-index)))

(defn debug-value 
  ([value] (debug-value "DEBUG-VALUE:" value))
  ([message value] (println message " " value) value))

(defn in? [value coll]
  (some #(= value %1) coll))

(defn into-last [coll item]
  (let [last-group (peek coll)
        without-last (pop coll)]
    (->> (vec (conj last-group item))
         (conj without-last)
         (vec))))

(defn into-new [coll item]
  (vec (conj coll [item])))

(defn find-common [coll-2d]
  (let [first-inner-coll (first coll-2d)
        colls-to-search (rest coll-2d)
        loop-count (count first-inner-coll)]
    (loop [common-item nil
           index 0]
      (if (or common-item (= loop-count index))
        common-item
        (let [cur-item (nth first-inner-coll index)
              found-common-item (reduce
                                (fn [found inner-coll]
                                  (and found (in? cur-item inner-coll)))
                                true
                                colls-to-search)]
          (recur (if found-common-item cur-item common-item) (+ index 1)))))))
