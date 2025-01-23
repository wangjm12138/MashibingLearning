package com.jackiewang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLearning {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(2);
    }
}
