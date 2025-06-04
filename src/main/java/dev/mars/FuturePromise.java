package dev.mars;

import io.vertx.core.Future;
import io.vertx.core.Promise;

public class FuturePromise {
    public static void main(String[] args) {
        Promise<String> promise = Promise.promise();
        Future<String> future = promise.future();

        // Simulate an asynchronous operation
        future.onComplete(result -> {
            if (result.succeeded()) {
                System.out.println("Success: " + result.result());
            } else {
                System.out.println("Failure: " + result.cause());
            }
        });

        // Complete the promise successfully
        promise.complete("Operation completed!");
    }
}