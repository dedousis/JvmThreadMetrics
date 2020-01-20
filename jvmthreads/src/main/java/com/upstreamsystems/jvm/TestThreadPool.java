package com.upstreamsystems.jvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
public class TestThreadPool implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOG = Logger.getLogger(String.valueOf(TestThreadPool.class));
    @Autowired
    ThreadPoolExecutor executor;


    AtomicInteger count = new AtomicInteger(0);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        for (int i = 0; i < 15000; i++) {
            executor.execute(new Task(count));
            count.getAndIncrement();
        }
        executor.shutdown();
    }

}
