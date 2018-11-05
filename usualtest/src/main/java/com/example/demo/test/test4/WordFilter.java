package com.example.demo.test.test4;

import com.alibaba.fastjson.JSON;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.Calendar;
import java.util.List;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/9/7
 */
public class WordFilter {

    public static void automaticSelection(String title) {
        //移除停用词进行分词
        List<Word> list = WordSegmenter.seg(title);

        System.out.println(JSON.toJSONString(list));

        //保留停用词

        List<Word> lists = WordSegmenter.segWithStopWords(title);
        System.out.println(JSON.toJSONString(lists));

    }

    public static void main(String[] args) {

        String[] s1 = "123".split(",");

        System.out.println(s1.length);


        int curHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int curMinute = Calendar.getInstance().get(Calendar.MINUTE);

        System.out.println(curHour + "  " +curMinute);


//
//        WordFilter.automaticSelection("我叫李太白，我是一个诗人，我生活在唐朝");
    }
}
