(ns org.shelves.server.core
  (:require [org.shelves.server.config :as config]
            [taoensso.timbre :as log])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (log/info "Shelves initialising..."))
