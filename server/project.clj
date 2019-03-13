(defproject shelves-server "0.1.0-alpha"
  :description "An open-source ILS for the digital library era."
  :url "https://shelves-ils.github.io"

  :license {:name "Apache License v2.0"
            :url "http://www.apache.org/licenses/"}

  :dependencies [[org.clojure/clojure "1.10.0"] ;; Core library.
                 [com.taoensso/timbre "4.10.0"] ;; Logging library.
                 [clj-http "3.9.1"] ;; HTTP library.
                 [cheshire "5.8.1"] ;; JSON support.
                 [clj-time "0.15.1"] ;; Date & Time library.
                 [org.clojure/java.jdbc "0.7.9"] ;; JDBC library.
                 [org.postgresql/postgresql "42.2.5"] ;; PostgreSQL JDBC connector.
                 [speclj "3.3.2"] ;; Test library.
                 [org.clojure/data.xml "0.0.8"] ;; XML library.
                 [org.clojure/data.json "0.2.6"] ;; JSON library.
                 [ondrs/barcode "0.1.0"] ;; Barcode library.
                 [com.draines/postal "2.0.3"] ;; Email library.
                 [clj-isbn "1.0.0"]] ;; ISBN parsing library.

  :main org.shelves.server.core

  :plugins [[speclj "3.3.2"]]

  :test-paths ["spec"]

  :target-path "target/%s"

  :profiles {:uberjar {:aot
                       :all}})
