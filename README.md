# udp-client-server
Simple UDP client and server in clojure
## Usage

```clojure
(let [port 11223
        srv (server/start port println)]
    (client/send "message 1" srv)
    (client/send "message 2" srv)
    (client/send "message 3" srv)
    (Thread/sleep 1)
    (server/shutdown srv))
```

## License

Copyright © 2020 Bamdad Dashtban

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
