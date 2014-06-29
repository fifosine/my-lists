(defproject my-lists "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [org.postgresql/postgresql "9.3-1101-jdbc4"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [liberator "0.10.0"]
                 [cheshire "5.2.0"]
                 [lib-noir "0.7.6"]
                 [environ "0.5.0"]]
  :plugins [[lein-ring "0.8.10"]
            [lein-environ "0.5.0"]]
  :ring {:handler my-lists.handler/app
         :init my-lists.handler/init
         :destroy my-lists.handler/destroy}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]]
    :env {:db-server "localhost"
          :db-name "my_lists"
          :db-user "my_lists_user"
          :db-password "my_lists_pass"}}})
