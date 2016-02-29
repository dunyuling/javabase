package com.lhg.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuhg on 16-2-24.
 */
public class TLT {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(100);
    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {

                @Override
                protected Integer initialValue() {
                    System.out.println(hashCode());
                    return nextId.getAndIncrement();
                }
            };
    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

}
