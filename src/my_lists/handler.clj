(ns my-lists.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.session.memory :refer [memory-store]]
            [noir.session :as session]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [my-lists.routes.home :refer [home-routes]]))

(defn init []
  (println "my-lists is starting"))

(defn destroy []
  (println "my-lists is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)
      (session/wrap-noir-session {:store (memory-store)})))



