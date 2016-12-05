# emergence ideas

## Desired goals

### Minimal

emergence itself should be minimal, and be extended with Addons.

## Language choice

### Nodes

Probably going to be using Clojure for emergence.

This will include the `nodes` from the P2P network implemented, and
backed by CouchDB and Clojure.

Wait- why use CouchDB? RDBMS would work fine as well, no?
Postgres would be useful as well. It can support JSON as well, which
is essentially what CouchDB is.. apart from the fact it uses sharding
and a Map/Reduce system.

### GUI

Using Clojure for the desktop GUI.

It is possible with the provided REST API for one to make a third
party client for emergence.
