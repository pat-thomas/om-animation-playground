(ns om-animation-playground.model)

(defn mirror-horizontal
  [{:keys [height width x y]}]
  [(- width x) y])

(defn mirror-vertical
  [{:keys [height width x y]}]
  [x (- height y)])

(defn mirror-coordinates
  [mirror-type {:keys [height width]} coordinates]
  (when-let [impl (cond (= mirror-type :horizontal)
                        mirror-horizontal

                        (= mirror-type :vertical)
                        mirror-vertical

                        :else
                        nil)]
    (map (fn [[x y]]
           (impl {:height height
                  :width  width
                  :x      x
                  :y      y}))
         coordinates)))

(defn multiples
  [upper-limit]
  (reduce (fn [acc n]
            (if (= (mod upper-limit n) 0)
              (conj acc n)
              acc))
          []
          (range 2 (inc upper-limit))))
