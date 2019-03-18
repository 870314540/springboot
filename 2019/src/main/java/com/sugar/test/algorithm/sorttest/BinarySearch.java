package com.sugar.test.algorithm.sorttest;

/**
 * 二分查找：必须有序
 * @author cuiyt
 * @Descrption
 * @create 2019/3/14
 */
public class BinarySearch {


    public static int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low) >>> 1;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 14, 17, 21, 25, 28, 40, 131, 332};
        BinarySearch s = new BinarySearch();

        System.out.println(binarySearch(arr,21));
    }

}
