(ns udp-client-server.server
  (:require [udp-wrapper.core :refer [create-udp-server close-udp-server
                                      empty-packet receive-loop
                                      packet send-message make-address
                                      get-bytes-utf8]]))

(defn start [port callback]
  (let [socket (create-udp-server port)
        server-future (receive-loop socket (empty-packet 512) callback)]
    {:socket socket
     :future server-future
     :host "127.0.0.1"
     :port   port}))

(defn shutdown [server]
  (future-cancel (:future server))
  (close-udp-server (:socket server)))



