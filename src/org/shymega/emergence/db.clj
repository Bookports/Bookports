(ns org.shymega.emergence.db
  (:require [com.ashafa.clutch :as couch]
            [com.ashafa.clutch :as clutch]
            [taoensso.timbre :as log])
  (:gen-class))

(defn conn-couch-db
  "Connect to `DB`
  Returns a CouchDB database object."
  [db]
  (try
    (couch/get-database db)
    (catch Exception e
      (log/fatal "Failed to connect to CouchDB!")
      (log/fatal "Unable to continue. Bailing out!")
      (log/fatal (format "%s"
                         (.getMessage e))))))
