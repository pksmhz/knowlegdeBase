package org.example;

public class Counter {
    private static int myCounter = 0;

    public void incrementCounter() {
        synchronized (this) {
            myCounter++;
            System.out.println(Thread.currentThread().getName() + " : " + myCounter);
        }
    }

    public static int getMyCounter() {
        return myCounter;
    }
}
