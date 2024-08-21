package com.jackiewang.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadCreator {

    public static void main(String[] args) {
        //懒加载的方式,只有当使用的时候才会创建线程并执行,如果线程已经满了,会放在阻塞队列中等待空闲的线程
//        ExecutorService e = Executors.newFixedThreadPool(2);
//        e.execute(()->{
//            System.out.println("1:"+Thread.currentThread().getName());
//        });
//        e.execute(()->{
//            System.out.println("2:"+Thread.currentThread().getName());
//        });
//        e.execute(()->{
//            System.out.println("3:"+Thread.currentThread().getName());
//        });
//        e.close();
        //单例线程池
//        ExecutorService e = Executors.newSingleThreadExecutor();
//        e.execute(()->{
//            System.out.println(Thread.currentThread().getName()+"1");
//        });
//        e.execute(()->{
//            System.out.println(Thread.currentThread().getName()+"2");
//        });
//        e.execute(()->{
//            System.out.println(Thread.currentThread().getName()+"3");
//        });
        //任务提交时候，立刻就会创建一个线程处理，如果任务结束，后续60秒之内没有任务，就会结束，
        //如果所有线程都在处理任务，就会新建线程处理，最大integer.max
//        ExecutorService pool = Executors.newCachedThreadPool();
//        for(int i = 0; i < 200; i++){
//            final int j = i;
//            pool.execute(()->{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(
//                        Thread.currentThread().getName() + ":" + j
//                );
//            });
//        }
//        pool.shutdown();
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
//        pool.execute(()->{
//            System.out.println(Thread.currentThread().getName()+":1");
//        });
//        pool.schedule(()->{
//            System.out.println(Thread.currentThread().getName()+":2");
//        },5, TimeUnit.SECONDS);
//        pool.scheduleAtFixedRate(()->{
//            System.out.println(Thread.currentThread().getName()+":3");
//        },5, 5, TimeUnit.SECONDS);
//        pool.scheduleWithFixedDelay(()->{
//            System.out.println(Thread.currentThread().getName()+":3");
//        },5, 5, TimeUnit.SECONDS);
    }

}
