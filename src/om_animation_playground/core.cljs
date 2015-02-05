(ns om-animation-playground.core
  (:require [om.core                         :as om  :include-macros true]
            [om.dom                          :as dom :include-macros true]
            [om-animation-playground.state   :as state]
            [om-animation-playground.animations.pulse :as pulse]
            [om-animation-playground.helpers :as helpers])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(enable-console-print!)

(defn start-app-loop
  [time handler]
  (.setInterval js/window handler time))

(def animation-component-dispatch
  {"pulse" pulse/root})

(defn select-animation-option
  [animation-option]
  (dom/option
   #js {:className "select-animation-option"}
   animation-option))

(defcomponent select-animation
  (render
   (dom/select
    #js {:id       "select-animation"
         :selected (:selected-animation data)
         :onChange (fn [e]
                     (om/transact! data (fn [state]
                                          (assoc state :selected-animation (.. e -target -value)))))}
    (select-animation-option "pulse")
    ;;(select-animation-option "bar")
    )))

(defcomponent container
  (render
   (dom/div
    #js {:id "app-container"}
    (when-let [selected-animation (get animation-component-dispatch (:selected-animation data))]
      (om/build selected-animation data)))))

(defcomponent app
  (render
   (dom/div
    #js {:id "app"}
    (om/build container data)
    (om/build select-animation data))))

(defn app-loop
  [time]
  (.setInterval
   js/window
   (fn []
     (when-let [handler (:handler @state/app-state)]
       (swap! state/app-state handler)))
   time))

(defn init!
  []
  (om/root
   app
   state/app-state
   {:target (. js/document (getElementById "my-app"))})
  (app-loop 1000))

(init!)
