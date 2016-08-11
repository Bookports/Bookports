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

(def welcome-email-msg
  (format "Welcome to %s Libraries!
This is an automated email from the %s Library Services.

You have successfully been signed up to %s Libraries.

Library branch: %s

Yours,
emergence." (carica.core/config :org-name) (carica.core/config :org-name) (carica.core/config :org-name) (carica.core/config :branch-name)))


(defn email-send-smtp [recipient subject body]
  "Send an email via SMTP."
  (timbre/debug "I've been called, and should use SMTP - time to prepare.")
  (let [conn {:host (carica.core/config :mail-server)
              :ssl (carica.core/config :mail-server-ssl)
              :user (carica.core/config :mail-server-from-addr)
              :pass (get-password)}]
    (timbre/debug "Connection mapping produced.")
    (timbre/debug "Attempting to send..")
    (timbre/info "Sending an email via SMTP..")
    (postal/send-message conn {:from (:user conn)
                               :to recipient
                               :subject subject
                               :body body})
    (timbre/info "Success!")))

(defn email-send-sendmail [recipient subject body]
  "Send an email via Sendmail."
  (timbre/debug "I've been called, and should use Sendmail - time to prepare.")
  (timbre/debug "Attempting to send..")
  (timbre/info "Sending an email via Sendmail..")
  (postal/send-message {:from (carica.core/config :mail-server-from-addr)
                        :to recipient
                        :subject subject
                        :body body}))


(defn welcome-email-send [recipient]
  "Send a welcome email."
  (timbre/debug "Constructing connection...")
  ;; We need to determine if we are using SMTP, or Sendmail.
  ;; If we send via SMTP, then we use the authentication details as outlined in
  ;; the configuration file.
  
  ;; If we are sending via Sendmail, then we henceforth assume that we are running on a server,
  ;; that contains the SMTP component, e.g Postfix.
  
  (case (carica.core/config :mail-server-send-type)
    "smtp" (email-send-smtp recipient (format "Welcome to %s Libraries!"
                                              (carica.core/config :org-name))
                            welcome-email-msg)
    "sendmail" nil
    "default" (warn "Unable to detect sending type.")))

