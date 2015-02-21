(ns om-animation-playground.common.components
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent blinking-cell
  [highlighted-pred]
  (render
   (let [{:keys [tick]} data]
     (dom/div
      #js
      {:className (highlighted-pred tick opts)}))))

(defcomponent column
  (render
   (apply
    dom/div
    #js {:className "column"}
    (map (fn [row-num]
           (om/build blinking-cell data {:opts (assoc opts :row-num row-num)}))
         (range 8)))))

