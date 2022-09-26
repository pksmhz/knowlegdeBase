package org.example;

public class CounterThread extends Thread {
    private static final int LIMIT = 20;

    @Override
    public void run() {
        Counter counter = new Counter();
        while (Counter.getMyCounter() < LIMIT) {
            counter.incrementCounter();
        }
    }
}
