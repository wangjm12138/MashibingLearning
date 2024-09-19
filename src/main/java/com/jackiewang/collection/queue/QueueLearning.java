package com.jackiewang.collection.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;

//所有的队列都不能放null数据
public class QueueLearning {


    public static void ArrayBlockingQueueLearning() {
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
//本身容量为0，其实就是一个通道，在线程和线程之间高效通信，队列只有先take才能put，所以下面线程2会先等待线程1先take(虽然take不到)，才会put第一个元素。
    public static void SynchronousQueueLearning() {
        SynchronousQueue<Integer> sq = new SynchronousQueue<>();


        Thread one = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(sq.take());
//                        Object result = sq.poll(5, TimeUnit.SECONDS);
//                        if (result == null) {
//                            System.out.println(result);
//                            break;
//                        }
//                        System.out.println(result);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sq.put(1);
                    sq.put(2);
                    sq.put(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        one.start();
        two.start();

    }

    //真正的无界，直到内存溢出
    public static void PriorityBlockingQueueLearning() throws InterruptedException {
        PriorityBlockingQueue<Student> pq = new PriorityBlockingQueue<>();
        pq.put(new Student("nana",21));
        pq.put(new Student("haha",19));
//        pq.put(new Student("sasa",11));
        pq.put(new Student("wawa",20));
//        pq.put(new Student("zaza",6));

        System.out.println(pq);
        //取数据才有优先级
        System.out.println(pq.take());
        System.out.println(pq.take());
        System.out.println(pq.take());
    }

    //双端队列
    public static void DequeLearning() {
        Deque<String> deque = new LinkedList<>();
        deque.offer("A");
        deque.offer("B");
        deque.offer("C");
        System.out.println(deque);

        deque.offerFirst("D");
        deque.offerLast("E");
        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);

    }

    public static void main(String[] args) throws InterruptedException {
        //ArrayBlockingQueueLearning();
        //SynchronousQueueLearning();
        //PriorityBlockingQueueLearning();
        DequeLearning();
    }
}