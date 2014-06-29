(ns my-lists.models.schema
  (:require [my-lists.models.db :refer :all]
            [clojure.java.jdbc :as sql]))

(defn create-user-table []
  (sql/with-connection db
    (sql/create-table
     :task_user
     [:username "varchar(32) primary key not null"]
     [:password "varchar(100) not null"])))

(defn create-task-table []
  (sql/with-connection db
    (sql/create-table
     :task
     [:username "varchar(32) not null"]
     [:task "text not null"]
     [:is_completed "boolean not null"]
     [:due_date "timestamp"]
     ["constraint task_pk primary key (username, task)"])))
