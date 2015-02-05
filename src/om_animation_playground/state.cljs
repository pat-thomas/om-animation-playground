(ns om-animation-playground.state)

(def app-state
  (atom {:tick    0
         :selected-animation "pulse"
         :handler (fn [state]
                    (update-in state [:tick] inc))}))
