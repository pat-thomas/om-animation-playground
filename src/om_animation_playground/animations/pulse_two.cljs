(ns om-animation-playground.animations.pulse-two
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true]
            [om-animation-playground.common.components :as components])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn calc-highlighted
  [tick {:keys [column-num row-num]}]
  (cond (= (mod (+ column-num tick) 3) 0)
        "cell highlighted"

        (= (mod (+ row-num tick) 7) 0)
        "cell highlighted"

        (= (mod (+ column-num row-num tick) 11) 0)
        "cell highlighted"
        
        :else
        "cell"))

(defcomponent root
  (render
   (dom/div
    #js {:className "animation"}
    (apply
     dom/div
     nil
     (map (fn [column-num]
            (om/build components/column data {:opts {:column-num       column-num
                                                     :highlighted-pred calc-highlighted}}))
          (map inc (range 15)))))))
