(ns org.bookports.server.db
  (:require [clojure.java.jdbc :as jdbc])
  (:gen-class))

(def db-spec
  {:dbtype "postgres"
   :dbname "bookports_dev"
   :user "bookports"
   :password "bookports"})

(def staff-table-ddl
  (jdbc/create-table-ddl
   :staff
   [[:id :serial "PRIMARY KEY"]
    [:first_name "TEXT"]
    [:last_name "TEXT"]
    [:is_admin :bool]]))

(jdbc/db-do-commands db-spec
                     [staff-table-ddl])

(jdbc/insert! db-spec :staff
              {:first_name "Chris"
               :last_name "Doe"
               :is_admin false})
