# Emergence ideas

## Out of the box experience

Emergence should be an out of the box package, with standard ILS
modules ready to go.

However, it should be extendable with plugins for later customisation.

## Language choice

Clojure will be used for the server component.

RESTful API to be provided (with Swagger docs) for GUI clients, and
third-party integrations.

The program should be able to recover from most faults.

Metrics support would be useful for monitoring the ILS
health. InfluxDB could be used for that.

## GUI

Native GUI toolkits will be used for the frontends. Example, web
client, Windows client, Android/iOS client, Linux/Mac client.

### Mobile app.

Staff can use for shelving, stocking books. Handheld device for
library operations.

Library patrons can also use the app to check out books, share book details
with friends, or save on a 'wishlist' for later borrowing.

However, not sure how anti-theft detectors would work with that, as
only the barcode would be scanned, and RFID tags wouldn't be disabled
-- not everyone has a NFC-capable phone, so to assume RFID tags would
be easy to disable _universally_ is a poor assumptions.

On the other hand, are anti-theft detectors necessary, other than to
alert staff of a book being taken out without being scanned?

## Topology
Decentralisation _might_ be an option, but I think for the majority of
installations, centralisation is a more appropriate design. We could
allow for offline usage for when the central server is offline.

I remember from my volunteering at libraries that the ILS might go
down, and we'd have to use an offline version. However, it was not
easy to use, and the outage would also knock the self-service machines
offline.

Self-service machines and ILS clients should have a built-in
offline version, and queue up changes to go through a synchronisation
process upon the ILS server goes back online.

One thing to consider with that is conflict resolution handling.

## Database

The database will be backed by PostgreSQL only, to ensure all efforts
can be focused on one RDBMS. There might be scope for other RDBMS
systems in the future...
