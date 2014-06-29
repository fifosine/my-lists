(ns my-lists.models.db
  (:require [clojure.java.jdbc :as sql]
            [environ.core :refer [env]]))

(def db {:subprotocol "postgresql"
         :subname (str "//" (env :db-server) "/" (env :db-name))
         :user (env :db-user)
         :password (env :db-password)
         })
