package com.example.demo.common;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/7/23
 * 算法一
 * 1)将长网址md5生成32位签名串,分为4段, 每段8个字节;
 * 2)对这四段循环处理, 取8个字节, 将他看成16进制串与0x3fffffff(30位1)与操作, 即超过30位的忽略处理;
 * 3)这30位分成6段, 每5位的数字作为字母表的索引取得特定字符, 依次进行获得6位字符串;
 * 4)总的md5串可以获得4个6位串; 取里面的任意一个就可作为这个长url的短url地址;
 * 这种算法,虽然会生成4个,但是仍然存在重复几率,下面的算法一和三,就是这种的实现.
 * 算法二
 * a-zA-Z0-9 这64位取6位组合,可产生500多亿个组合数量.把数字和字符组合做一定的映射,就可以产生唯一的字符串,如第62个组合就是aaaaa9,
 * 第63个组合就是aaaaba,再利用洗牌算法，把原字符串打乱后保存，那么对应位置的组合字符串就会是无序的组合。
 * 把长网址存入数据库,取返回的id,找出对应的字符串,例如返回ID为1，那么对应上面的字符串组合就是bbb,同理 ID为2时，
 * 字符串组合为bba,依次类推,直至到达64种组合后才会出现重复的可能，所以如果用上面的62个字符，任意取6个字符组合成字符串的话，
 * 你的数据存量达到500多亿后才会出现重复的可能。
 */
public class ShortUrlGenerator {
    public static String[] shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "key321" ;
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"

        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = ( new CMyEncrypt()).md5(key + url);
        String hex = sMD5EncryptResult;

        String[] resUrl = new String[4];
        for ( int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong (sTempSubString, 16);
            String outChars = "" ;
            for ( int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[( int ) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

        String sLongUrl = "http://474515923.qzone.qq.com" ; //长链接
        String[] aResult = shortUrl (sLongUrl);
        // 打印出结果
        for ( int i = 0; i < aResult. length ; i++) {
            System. out .println( "[" + i + "]:::" + aResult[i]);
        }
    }


}
