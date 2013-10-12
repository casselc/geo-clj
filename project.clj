(defproject geo-clj "0.3.6"
  :description "Geographic encoding/decoding for Clojure and ClojureScript."
  :url "http://github.com/r0man/geo-clj"
  :author "Roman Scherer"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :lein-release {:deploy-via :clojars}
  :dependencies [[noencore "0.1.6"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 [org.postgis/postgis-jdbc "1.3.3"]]
  :profiles {:dev {:dependencies [[com.keminglabs/cljx "0.3.0"]]
                   :plugins [[com.cemerick/austin "0.1.1"]
                             [com.cemerick/clojurescript.test "0.1.0"]]
                   :repl-options {:nrepl-middleware [cljx.repl-middleware/wrap-cljx]}}}
  :plugins [[com.keminglabs/cljx "0.3.0"]
            [lein-cljsbuild "0.3.3"]]
  :hooks [cljx.hooks leiningen.cljsbuild]
  :cljx {:builds [{:source-paths ["src"]
                   :output-path "target/classes"
                   :rules :clj}
                  {:source-paths ["src"]
                   :output-path "target/classes"
                   :rules :cljs}
                  {:source-paths ["test"]
                   :output-path "target/test-classes"
                   :rules :clj}
                  {:source-paths ["test"]
                   :output-path "target/test-classes"
                   :rules :cljs}]}
  :cljsbuild {:test-commands {"phantom" ["phantomjs" :runner "target/testable.js"]}
              :builds [{:source-paths ["target/classes" "target/test-classes"]
                        :compiler {:output-to "target/testable.js"
                                   :optimizations :advanced
                                   :pretty-print true}}]}
  :test-paths ["target/test-classes"])
