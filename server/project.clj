(defproject emergence-server "0.1.0-alpha"
  :description "An open-source ILS for the digital library era."
  :url "https://emergence-ils.github.io"

  :min-lein-version "2.8.0"
  :uberjar-name "emergence-server-standalone.jar"

  :license {:name "Apache License v2.0"
            :url "http://www.apache.org/licenses/"}

  :dependencies [[org.clojure/clojure "1.8.0"] ;; Core library.
                 [com.taoensso/timbre "4.10.0"] ;; Logging library.
                 [cheshire "5.8.1"] ;; JSON support.
                 [clj-time "0.15.1"] ;; Date & Time library.
                 [org.clojure/java.jdbc "0.7.8"] ;; JDBC library.
                 [org.postgresql/postgresql "42.2.5"] ;; PostgreSQL JDBC connector.
                 [speclj "3.3.2"] ;; Test library.
                 [com.draines/postal "2.0.3"] ;; Email library.
                 [clj-isbn "1.0.0"] ;; ISBN parsing library.
                 ]

  :main org.emergence.server.core

  :plugins [[speclj "3.3.2"]]

  :test-paths ["spec"]

  :target-path "target/%s"

  :profiles {:uberjar {:aot
                       :all}})
