# websocketApplication
Springboot websocket application to auto suggest textbox with prompts.

This Springboot Application takes suggestion data from MySQL Table -Jeopardy.
It uses Websocketing and Hibernate Second level caching using Ehcache.

## What is a websocket?
WebSocket is a computer communications protocol, providing full-duplex communication channels over a single TCP connection. WebSocket is distinct from HTTP. The protocol enables interaction between a web browser (or other client application) and a web server with lower overhead than half-duplex alternatives such as HTTP polling, facilitating real-time data transfer from and to the server.

## What is STOMP?
Simple (or Streaming) Text Oriented Message Protocol (STOMP), formerly known as TTMP, is a simple text-based protocol, designed for working with message-oriented middleware (MOM). It provides an interoperable wire format that allows STOMP clients to talk with any message broker supporting the protocol.

Since websocket is just a communication protocol, it doesn’t know how to send a message to a particular user. STOMP is basically a messaging protocol which is useful for these functionalities.

## Setting up the application
Our application will have the following configuration which can be set using Spring Initializr :

Java version : 11

Type : Maven Project

Dependencies : Websocket

Spring Boot version : 2.7.9

## Dataset used: 
[JEOPARDY_CSV](https://drive.google.com/file/d/0BwT5wj_P7BKXUl9tOUJWYzVvUjA/view?resourcekey=0-uFrn8bQkUfSCvJlmtKGCdQ)

