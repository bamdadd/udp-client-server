(ns udp-client-server.server-test
  (:require [clojure.test :refer :all]
            [udp-client-server.server :as server]
            [udp-client-server.client :as client])
  (:import (java.net ServerSocket)))

(defn get-free-port []
  (let [socket (ServerSocket. 0)]
    (.close socket)
    (.getLocalPort socket)))

(deftest server
  (let [port (get-free-port)
        state (atom [])
        srv (server/start port #(swap! state conj %))]
    (client/send "message 1" srv)
    (client/send "message 2" srv)
    (client/send "message 3" srv)
    (Thread/sleep 10)
    (server/shutdown srv)
    (is (= @state ["message 1" "message 2" "message 3"]))))
