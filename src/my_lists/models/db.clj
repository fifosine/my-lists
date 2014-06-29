(ns my-lists.models.db
  (:require [clojure.java.jdbc :as sql]
            [environ.core :refer [env]]))

(def db {:subprotocol "postgresql"
         :subname (str "//" (env :server-name) "/" (env :database-name))
         :user (env :user)
         :password (env :password)
         })
