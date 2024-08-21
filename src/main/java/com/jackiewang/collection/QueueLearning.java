package com.jackiewang.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueLearning {


    public static void main(String[] args) {

       ArrayBlockingQueue<String> arrayBlockingQueue  = new ArrayBlockingQueue<>(3);
       Thread one = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   arrayBlockingQueue.put("one");
                   System.out.println("one");
                   arrayBlockingQueue.put("two");
                   System.out.println("two");
                   arrayBlockingQueue.put("three");
                   System.out.println("three");
                   arrayBlockingQueue.put("four");
                   System.out.println("four");
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       });
       one.start();
       Thread two = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(10000);
                   System.out.println(arrayBlockingQueue.take());
                   Thread.sleep(1000);
                   System.out.println(arrayBlockingQueue.take());
                   Thread.sleep(1000);
                   System.out.println(arrayBlockingQueue.take());
                   Thread.sleep(1000);
                   System.out.println(arrayBlockingQueue.take());
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
       });
       two.start();

    }
}
