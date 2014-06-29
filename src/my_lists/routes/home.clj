(ns my-lists.routes.home
  (:require [compojure.core :refer :all]
            [my-lists.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "Placeholder"]))

(defroutes home-routes
  (GET "/" [] (home)))
