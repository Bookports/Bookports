(ns org.shymega.emergence.email
  (:require [postal.core :as postal]
            [carica.core :as carica]
            [taoensso.timbre :as log]
            [org.shymega.emergence.config :as config]
            [cheshire.core :as ches])
  (:gen-class))

(defn get-password [& args]
  "Get email password for SMTP server."
  (log/debug "Retrieving SMTP password...")
  (if-let [password (carica.core/config :mail-server-from-pwd)]
    password
    (log/warn "Cannot get a password for SMTP.")))

(defn email-send-smtp [recipient subject body]
  "Send an email via SMTP."
  (log/trace "Called, preparing connection.")
  (let [conn {:host (carica.core/config :mail-server)
              :ssl (carica.core/config :mail-server-ssl)
              :user (carica.core/config :mail-server-from-addr)
              :pass (get-password)}]
    (log/trace "Connection object produced.")
    (log/trace "Sending..")
    (log/trace (format "*** EMAIL DETAILS ***\nFrom: %s\nRecipient: %s\nSubject: %s\n"))

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
    "smtp"
    (email-send-smtp recipient subject
                     body)
    "sendmail"
    (email-send-sendmail recipient subject
                         body)
    "default"
    (log/error "Unable to detect sending method!")
    (log/error "Bailing out, not gonna send a email. Sorry.")
    {:op "EMAIL_SEND",
     :error "EMAIL_SEND_NO_METHOD",
     :success? false}))
