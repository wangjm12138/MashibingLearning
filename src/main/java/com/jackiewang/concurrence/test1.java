package com.jackiewang.concurrence;

public class test1 {

    public static int number = 1;
    public static boolean ready = false;

    private static class ready extends Thread {

        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new ready();
        t.start();
        number = 42;

        ready = true;
        t.join();
        System.out.println(11111);
    }
}
