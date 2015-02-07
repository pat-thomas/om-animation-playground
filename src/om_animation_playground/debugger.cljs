(ns om-animation-playground.debugger
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true]
            [om-animation-playground.state :as state])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent toggle
  (render
   (dom/button
    #js {:id      "toggle-debugger"
         :onClick (fn [_]
                    (om/transact! data [:debugger :show] not))}
    "Toggle debugger")))

(defcomponent debugger-row
  [key-path prefix]
  (render
   (dom/div
    #js {:className "debugger-row"}
    (str prefix ": " (.stringify js/JSON (clj->js (get-in data key-path)))))))

(def keys-to-remove-from-debugger
  [:tick
   :selected-animation
   [:debugger :show]])

(defn dissoc-keys
  [data ks]
  (reduce (fn [acc k]
            (if (keyword? k)
              (dissoc acc k)
              (apply (partial dissoc acc) k)))
          data
          ks))

(defcomponent root
  (render
   (dom/div
    #js {:id "debugger"}
    (om/build toggle data)
    (when (get-in data [:debugger :show])
      (dom/div
       #js {:id "debugger-rows"}
       (om/build debugger-row data {:opts {:key-path [:tick]
                                           :prefix   "Tick"}})
       (om/build debugger-row data {:opts {:key-path [:selected-animation]
                                           :prefix   "Current animation"}})
       (.stringify js/JSON
                   (-> data
                       (dissoc-keys keys-to-remove-from-debugger)
                       clj->js)))))))
