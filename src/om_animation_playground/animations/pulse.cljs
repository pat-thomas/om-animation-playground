(ns om-animation-playground.animations.pulse
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent cell
  (render
   (dom/div
    #js
    {:className (if (= (mod (:tick data) 2) 0)
                  "cell"
                  "cell highlighted")})))

(defcomponent root
  (render
   (dom/div
    #js {:className "animation"}
    (om/build cell data))))
