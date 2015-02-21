(ns om-animation-playground.animations.pulse
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true]
            [om-animation-playground.common.components :as components])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn calc-highlighted
  [tick {:keys [column-num row-num]}]
  (cond
    (= (mod tick (+ column-num row-num)) 0)
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
