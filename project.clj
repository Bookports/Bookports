(defproject emergence "0.1.0-alpha"
  :description "A free software ILS system."

  :url "https://p.shymega.org.uk/shymega/emergence"

  :license {:name "Apache License v2.0"
            :url "http://www.apache.org/licenses/"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.taoensso/timbre "4.7.3"]
                 [cheshire "5.6.3"]
                 [clj-time "0.12.0"]
                 [sonian/carica "1.2.1"]
                 [com.draines/postal "1.11.3"]]

  :main emergence.core

  :target-path "target/%s"

  :profiles {:uberjar {:aot
                       :all}})
