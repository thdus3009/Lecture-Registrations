package com.specialLecture.common.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class LockHandler {
    private final ConcurrentHashMap<String, Lock> lockMap = new ConcurrentHashMap<>();

    public <T> T executeOnLock(String key, ThrowingSupplier<T> block) {
        Lock lock = lockMap.computeIfAbsent(key, k -> new ReentrantLock());
        boolean acquired;
        try {
            acquired = lock.tryLock(5, TimeUnit.SECONDS);
            if (!acquired) throw new RuntimeException("Timeout 에러 발생");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        try {
            return block.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @FunctionalInterface
    public interface ThrowingSupplier<T> {
        T get() throws Exception;
    }
}
