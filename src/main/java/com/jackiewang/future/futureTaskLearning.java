package com.jackiewang.future;

import java.util.concurrent.*;

public class futureTaskLearning {


    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> integerCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Anonymous inner Class");
                return 42;
            }
        };
        Future<Integer> callableTask = executorService.submit(() -> {
            System.out.println("Lambada callable task");
            return 1;
        });

        Future<Integer> integerFutureTask = executorService.submit(integerCallable);
        try {
            Integer i = callableTask.get();
            System.out.println(i);
            Integer j = integerFutureTask.get();
            System.out.println(j);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.close();

    }
}
