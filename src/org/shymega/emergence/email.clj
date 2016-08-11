(ns org.shymega.emergence.email
  (:require [postal.core :as postal]
            [carica.core :as carica]
            [taoensso.timbre :as log]
            [org.shymea.emergence.config :as config]
            [cheshire.core :as ches])
  (:gen-class))

(defn get-password [& args]
  "Get email password for SMTP server."
  (log/debug "Retrieving SMTP password...")
  (let [password (carica.core/config :mail-server-from-pwd)]
    (if password
      password
      (log/warn "Unable to get password for SMTP."))))


(defn email-send-smtp [recipient subject body]
  "Send an email via SMTP."
  (log/trace "Called. preparing connection.")
  (let [conn {:host (carica.core/config :mail-server)
              :ssl (carica.core/config :mail-server-ssl)
              :user (carica.core/config :mail-server-from-addr)
              :pass (get-password)}]
    (log/trace "Connection object produced.")
    (log/trace "Sending..")
    (log/info "Sending an email via the SMTP protocol.")
    (postal/send-message conn {:from (:user conn)
                               :to recipient
                               :subject subject
                               :body body})
    (log/info "Success!")))

(defn email-send-sendmail [recipient subject body]
  "Send an email via Sendmail."
  (log/debug "I've been called, and should use Sendmail - time to prepare.")
  (log/debug "Attempting to send..")
  (log/info "Sending an email via Sendmail..")
  (postal/send-message {:from (carica.core/config :mail-server-from-addr)
                        :to recipient
                        :subject subject
                        :body body}))


(defn email-send [recipient subject body]
  "Send an email."
  (case (carica.core/config :send-type)
    "smtp" (email-send-smtp recipient subject
                            body)
    "sendmail" (email-send-sendmail recipient subject
                                    body)
    "default" (log/warn "Unable to detect sending")))
