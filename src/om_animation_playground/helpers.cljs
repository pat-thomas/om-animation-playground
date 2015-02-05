(ns om-animation-playground.helpers
  (:require [om-animation-playground.state :as state]))

(defn debug-app-state
  [& ks]
  (println (str ks " => " (get-in @state/app-state ks))))
