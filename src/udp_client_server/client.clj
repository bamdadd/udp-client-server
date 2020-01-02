(ns udp-client-server.client
  (:require [udp-wrapper.core :refer [packet send-message make-address
                                      get-bytes-utf8]]))

(defn send [message server]
  (let [pkt (packet
              (get-bytes-utf8 message)
              (make-address (:host server))
              (:port server))]
    (send-message (:socket server) pkt))
  server)
