(ns org.emergence.server.core
  (:require [org.emergence.server.config :as config]
            [taoensso.timbre :as log])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (log/info "Emergence now booting up."))
