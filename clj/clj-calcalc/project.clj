(defproject clj-calcalc "0.1.0-SNAPSHOT"
  :description "Fork of Calendrical Calculations code that adds Clojure port"
  ;; forked from: https://github.com/EdReingold/calendar-code2
  :url "https://github.com/echeran/calendar-code2"
  :license {:name "APACHE LICENSE, VERSION 2.0"
            ;; preserve license used for original Common Lisp code in original repo
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/math.numeric-tower "0.0.5"]]
  :repl-options {:init-ns clj-calcalc.core})
