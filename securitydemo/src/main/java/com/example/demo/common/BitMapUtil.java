package com.example.demo.common;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/11/13
 */
public class BitMapUtil {
    public static int returnActualLength(byte[] data) {
        int i = 0;
        for (; i < data.length; i++) {
            if (data[i] == '\0')
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        Byte[] bytes = {1, 2};
        System.out.println(bytes.length);
        byte[] bytes1 = {1, 2};
        System.out.println(returnActualLength(bytes1) + "-->" + bytes1.length);
    }
}
