(ns org.bookports.server.core
  (:use compojure.core)
  (:require [org.bookports.server.config :as config]
            [clojure.data.xml :as xml :refer :all]
            [taoensso.timbre :as log]
            [compojure.route :as route]
            [compojure.response :as response])
  (:gen-class))

;; a LIDL is a 'library identification label'

(defn get-time
  []
  (-> (java.time.ZonedDateTime/now)
      (.toString)))

(defn root-handler
  [req]
  {:status 200,
   :headers {"Content-Type" "application/xml; charset=utf-8"}
   :body
   (emit-str
    (element :bookports {:ts (get-time)}
             (element :status {:lidl "CHI"})))})

(defroutes base-api
  (GET "/" [] root-handler)
  (route/not-found "Page not found."))

(defn -main
  [& args]
  (log/info "Bookports (BPS) initialising..."))
