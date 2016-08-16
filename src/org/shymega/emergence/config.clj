(ns org.shymega.emergence.config
  (:require [taoensso.timbre :as log])
  (:gen-class))

(defn- get-config-file-location []
  (log/trace "Getting configuration file.")
  (if-let [file (java.lang.System/getenv "EMERGENCE_CONFIG")]
    file
    (do
      (log/fatal "Unable to get location of configuration file.")
      (log/fatal "We cannot continue. Bailing out!")
      (System/exit 12))))

(def config-file
  (get-config-file-location))
