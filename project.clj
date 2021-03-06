(defproject om-animation-playground "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure       "1.6.0"]
                 [org.clojure/clojurescript "0.0-2727"]
                 [org.omcljs/om             "0.8.7"]
                 [om-utils                  "0.4.0"]]
  :plugins [[lein-cljsbuild "1.0.3"]]
  :source-paths ["src"]
  :cljsbuild {:builds [{:id           "development"
                        :source-paths ["src"]
                        :compiler     {:output-to     "om_animation_playground.js"
                                       :output-dir    "out"
                                       :optimizations :none
                                       :source-map    true}}]})
