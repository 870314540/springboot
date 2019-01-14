package com.example.demo.lucenetest;


import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.IntsRefBuilder;
import org.apache.lucene.util.fst.*;

import java.util.Comparator;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/14
 */
public class TestFST {

    public static void main(String[] args) {
//todo 待验证
        String[] inputValues = {"abe", "abf", "ade"};
        long outputValues[] = {5, 7, 12};

        try {
            PositiveIntOutputs outputs = PositiveIntOutputs.getSingleton();
            Builder<Long> builder = new Builder<Long>(FST.INPUT_TYPE.BYTE1, outputs);
            BytesRefBuilder scratchBytes = new BytesRefBuilder();
            IntsRefBuilder scratchInts = new IntsRefBuilder();
            for (int i = 0; i < inputValues.length; i++) {
                scratchBytes.copyChars(inputValues[i]);
                builder.add(Util.toIntsRef(scratchBytes.toBytesRef(), scratchInts), outputValues[i]);
            }
            FST<Long> fst = builder.finish();


            Long value = Util.get(fst, new BytesRef("abf"));
            System.out.println(value); // 7

            IntsRef key = Util.getByOutput(fst, 12);
            System.out.println(Util.toBytesRef(key, scratchBytes).utf8ToString()); // ade

            BytesRefFSTEnum<Long> iterator = new BytesRefFSTEnum<Long>(fst);

            while (iterator.next() != null) {
                BytesRefFSTEnum.InputOutput<Long> mapEntry = iterator.current();
                System.out.println(mapEntry.input.utf8ToString());
                System.out.println(mapEntry.output);
            }



            Comparator<Long> comparator = new Comparator<Long>() {
                public int compare(Long left, Long right) {
                    return left.compareTo(right);
                }
            };
        } catch (Exception e){

        }
    }
}
