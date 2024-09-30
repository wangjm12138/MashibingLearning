package com.jackiewang.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completeFutureLearning {

    public static void main(String[] args) {
        //thenApply需要返回值，thenApplyAsync是可以加指定线程池
//        CompletableFuture<Integer> objectCompletableFuture = CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("first");
//            System.out.println(Thread.currentThread().getName());
//            return 1;
//        }).thenApply(result -> {
//            System.out.println("first result :" + result);
//            System.out.println("second");
//            System.out.println(Thread.currentThread().getName());
//            return 2;
//        });
//
//        try {
//            Integer ret = objectCompletableFuture.get();
//            System.out.println(ret);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }

        //thenAccept 不需要返回值, thenAcceptAsync 加指定线程池
        CompletableFuture<?> objectCompletableFuture = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("first");
            System.out.println(Thread.currentThread().getName());
            return 1;
        }).thenAccept(result -> {
            System.out.println("first result :" + result);
            System.out.println("second");
            System.out.println(Thread.currentThread().getName());
        });

        objectCompletableFuture.join();



    }
}
