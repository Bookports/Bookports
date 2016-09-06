(defproject emergence "0.1.0-alpha"
  :description "A free software ILS system."

  :url "https://p.shymega.org.uk/shymega/emergence"

  :license {:name "Apache License v2.0"
            :url "http://www.apache.org/licenses/"}

  :dependencies [[org.clojure/clojure "1.8.0"] ;; Core library
                 [com.taoensso/timbre "4.7.3"] ;; Logging 
                 [cheshire "5.6.3"] ;; JSON support
                 [clj-time "0.12.0"] ;; Date & Time library
                 [sonian/carica "1.2.1"] ;; Configuration library - EDN
                 [com.ashafa/clutch "0.4.0"] ;; CouchDB library
                 [speclj "3.3.2"] ;; Test library
                 [com.draines/postal "1.11.3"] ;; Email library
                 [buddy "1.1.0"] ;; For authentication
                 [clj-isbn "0.0.7"] ;; ISBN parsing library
                 [javax.servlet/servlet-api "2.5"] ;; Java Servlet API lib
                 [ring "1.5.0"] ;; For web apps
                 [compojure "1.5.1"] ;; For web apps
                 [metosin/compojure-api "1.1.8"]] ;; For web API's

  :main org.shymega.emergence.core

  :plugins [[speclj "3.3.2"]
            [lein-codox "0.9.6"]
            [lein-cloverage "1.0.7-SNAPSHOT"]]

  :test-paths ["spec"]

  :target-path "target/%s"

  :profiles {:uberjar {:aot
                       :all}})
