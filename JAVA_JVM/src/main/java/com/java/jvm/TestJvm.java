package com.java.jvm;

import java.util.concurrent.TimeUnit;

public class TestJvm {
    public static void main(String[] args) {

        int a = 2 + 3;
        int c = 0;
        int b = 1;
        int d = c + b;


        try{
            TimeUnit.SECONDS.sleep(6000);}catch(InterruptedException e){e.printStackTrace();}
        System.out.println(a);
    }
}
