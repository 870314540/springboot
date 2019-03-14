package com.sugar.test.algorithm.sorttest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/3/5
 */
public class QuickSort {

    public static void main(String[] args) {
//        System.out.println("Hello World");
//        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
//        int start = 0;
//        int end = a.length - 1;
//        sort1(a, start, end);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }


    }


    public static void sort1(int arr[], int low, int high) {

        int temp, t;
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;

        temp = arr[i];


        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }


        }
        arr[low] = arr[i];
        arr[i] = temp;


        sort1(arr, i + 1, high);
        sort1(arr, low, i - 1);

    }


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


}
