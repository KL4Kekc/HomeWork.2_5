package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passengers extends Thread {
    Semaphore semaphore;
    int id;
    CountDownLatch latch;

    public Passengers(Semaphore semaphore, int id, CountDownLatch latch) {
        this.semaphore = semaphore;
        this.id = id;
        this.latch = latch;
    }

    public synchronized void run()  {
        try {
            semaphore.acquire();
            System.out.println("Пассажир " + id + " покупает билет");
            System.out.println("Пассажир "+ id + " садится в автобус");
            semaphore.release();
            latch.countDown();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
