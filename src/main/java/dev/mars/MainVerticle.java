package dev.mars;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

    public static void main(String[] args) {
        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MainVerticle());
    }

    @Override
    public void start(final Promise<Void> startPromise) {
        // This is the entry point of the Verticle.
        // You can initialize your services, routers, etc. here.
        System.out.println("Started" + this.getClass().getName());

        // Example: Deploy other Verticles or set up HTTP server, etc.
        vertx.deployVerticle(new VerticleChildA());
        vertx.deployVerticle(new VerticleChildB());
        startPromise.complete();
    }


    public class VerticleChildA extends AbstractVerticle {
        @Override
        public void start(final Promise<Void> startPromise) {
            // This is another Verticle that can be deployed.
            System.out.println("Started " + this.getClass().getName());
            startPromise.complete();
        }
    }

    public class VerticleChildB extends AbstractVerticle {
        @Override
        public void start(final Promise<Void> startPromise) {
            // This is another Verticle that can be deployed.
            System.out.println("Started " + this.getClass().getName());
            startPromise.complete();
        }
    }


}

