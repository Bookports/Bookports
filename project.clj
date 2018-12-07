(defproject emergence-server "0.1.0-alpha"
  :description "A open source ILS for the libraries of the future"

  :url "https://emergence-ils.github.io"

  :license {:name "Apache License v2.0"
            :url "http://www.apache.org/licenses/"}

  :dependencies [
                 [org.clojure/clojure "1.9.0"] ;; Core library.
                 [com.taoensso/timbre "4.7.3"] ;; Logging library.
                 [cheshire "5.6.3"] ;; JSON support.
                 [clj-time "0.12.0"] ;; Date & Time library.
                 [speclj "3.3.2"] ;; Test library.
                 [com.draines/postal "1.11.3"] ;; Email library.
                 [buddy "1.1.0"] ;; For authentication.
                 [clj-isbn "1.0.0"] ;; ISBN parsing library.
                 ]

  :main org.emergence.server.core

  :plugins [[speclj "3.3.2"]
            [lein-codox "0.9.6"]
            [lein-kibit "0.1.2"]
            [lein-cloverage "1.0.7-SNAPSHOT"]]

  :test-paths ["spec"]

  :target-path "target/%s"

  :profiles {:uberjar {:aot
                       :all}})
