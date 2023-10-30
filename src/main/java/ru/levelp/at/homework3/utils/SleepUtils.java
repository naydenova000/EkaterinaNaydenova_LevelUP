package ru.levelp.at.homework3.utils;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {

    public static void sleep(long timeout){
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    private SleepUtils(){}
}
