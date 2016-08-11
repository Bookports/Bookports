(ns org.shymega.emergence.config
  (:gen-class))

(defn- get-config-file []
  (let [file (java.lang.System/getenv "EMERGENCE_CONFIG")]
    (if-not file
      (do
      )
    ))

(def config-file
  (let [file (java.lang.System/getenv "EMERGENCE_CONFIG_F")]
    (if-not file
      (do
        (log/error "EID: 001/A - Unable to get configuration env var. Unable to continue.")
        (System/exit 0))
      file)))
