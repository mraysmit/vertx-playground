package dev.mars;

import io.vertx.core.Vertx;

public class EventBusExample {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.eventBus().consumer("address", message -> {
            System.out.println("Received message: " + message.body());
        });

        vertx.eventBus().send("address", "Hello, Event Bus!");
    }
}