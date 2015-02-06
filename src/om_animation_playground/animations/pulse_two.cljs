(ns om-animation-playground.animations.pulse-two
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true]
            [om-animation-playground.common.components :as components])
  (:require-macros [om-utils.core :refer [defcomponent]]))


(defcomponent root
  (render
   (dom/div
    #js {:className "animation"}
    )))
