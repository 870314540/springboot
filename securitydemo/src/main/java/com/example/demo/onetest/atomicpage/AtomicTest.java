package com.example.demo.onetest.atomicpage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/3/27
 */
public class AtomicTest {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>();


    public static void main(String[] args) throws IOException {

        atomicReference.set(19);

        if (atomicReference.compareAndSet(20, 19 + 1)) {
            System.out.println(11111);
        }


        String targetFile = "22222.tar";
        File file = new File(targetFile);
        file.createNewFile();
    }
}
