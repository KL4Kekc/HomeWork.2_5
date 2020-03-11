package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int Passengers = 100;
    public static CountDownLatch latch;

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(Passengers);

        Semaphore semaphore = new Semaphore(4);

        for (int i = 1; i < 101; i++) {
            new Passengers(semaphore, i, latch).start();
        }
        latch.await();
        System.out.println("Автобус полон, отправка в Ош");
    }
}
