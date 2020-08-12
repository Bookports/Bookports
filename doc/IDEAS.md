# Bookports - ideas & notes

## Out of the box experience

Bookports should be an out of the box package, with standard ILS
modules ready to go.

However, it should be extendable with plugins.

## Language

Java awill be used for the server component.

It will use h
Scala will be used for the server component.

The server component will run on the Apache Tomcat platform.

A RESTful API will be provided, along with Swagger documentation.

## API.

As well as a REST API, there will be a SOAP to REST translation proxy available
as part of an optional package.

The APIs will be used both internally for the main librarian and administration
services, as well as the OPAC, and third-party integrations.

## Modules

Open Data.

The OPAC is a separate module from the server component. It will run on the
Apache Tomcat platform as well.

The OPAC will use the server's REST API.

The program should be able to recover from most faults.

Metrics support would be useful for monitoring the ILS
health. InfluxDB could be used for that.

## GUI

Native GUI toolkits will be used for the frontends. Example, web
client, Windows client, Android/iOS client, Linux/Mac client.

### Mobile app

#### Library staff

Mobile app for iOS+Android for library staff.

This can be used as a mobile interface to the ILS,
Handheld mobile app for library staff.
Staff can use for shelving, stocking books. Handheld device for
library operations.

Library patrons can also use the app to check out books, share book details
with friends, or save on a 'wishlist' for later borrowing.

## Topology

Bookports will connect to a centralised server.

A decentralised topology could be considered in the future.

Self-service machines and ILS clients should have a built-in offline
version, and queue up changes to go through a synchronisation process
upon the ILS server goes back online.

One thing to consider with that is conflict resolution handling, upon
resynchronisation.

## Database

The backend will be supported by PostgreSQL.

## Patrons

* Digital library card
   - QR code, or barcode (GTIN?)
   - NFC?

* Text message alerts.

Books notifications.
Recommended books.
Notification when book is in stock.
