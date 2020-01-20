package com.upstreamsystems.jvm;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable {

    AtomicInteger count;

    private static final Logger logger = LoggerFactory.getLogger(Task.class);

    public Task(AtomicInteger count) {
        this.count = count;
    }


    @Override
    public void run() {
        try {
            logger.error(String.valueOf(count));
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
