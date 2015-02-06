(ns om-animation-playground.debugger
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true]
            [om-animation-playground.state :as state])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent root
  (render
   (dom/div
    #js {:id "debugger"}
    (when (get-in data [:debugger :show])
      (.stringify js/JSON (clj->js data))))))
