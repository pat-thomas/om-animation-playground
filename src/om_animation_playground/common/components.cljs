(ns om-animation-playground.common.components
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

