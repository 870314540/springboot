package FileProcess1;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lenovo on 2017/8/14.
 * 处理数据
 */

public class RemoveP {

    /**
     * 读文件
     * @param filePath
     * @return
     */
    public static String readFile(String filePath){
        StringBuffer sb= new StringBuffer("");
        HashSet<String> set1 = new HashSet<String>();
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            String str = "";
            while((str = br.readLine()) != null) {
                sb.append(str+",");
            }
            br.close();
            reader.close();

            return sb.toString();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


        return null ;
    }

    /**
     * 写文件
     * @param filePath
     * @param str
     */
    public static void writeFile(String filePath,String str){
        HashSet<String> set1 = new HashSet<String>();
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(str);
            bw.close();
            writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static Set duplicate(String str) {
        /**
         * 用逗号隔开
         */
        if (null == str || "".equals(str)) {
            System.out.println("duplicate str is null ");
            return null;

        }
        String[] strArray = str.split(",");
        int len = strArray.length;
        if (0 != len) {
            HashSet<String> set1 = new HashSet<String>();
            StringBuffer sb = new StringBuffer("");

            for (int i = 0; i < len; i++) {
                if (null != strArray[i] && !"".equals(strArray[i]))
                    set1.add(strArray[i]);
            }
//            Iterator<String> it = set1.iterator();
//            while (it.hasNext()) {
//                sb.append(it.next()+",");
//            }
            return set1;
        }
        return null;
    }


    public static String cat(Set strSet) {
        int len = strSet.size();
        if (0 != len  && null != strSet) {
            StringBuffer sb = new StringBuffer("");

            StringBuffer newsb = new StringBuffer("");

            Iterator<String> it = strSet.iterator();

            int i = 0;
            while (it.hasNext()) {
                sb.append("'"+it.next() + "',");

                if( i % 100  == 0 ){
                    sb.append("\r\n");
                }
                i++;
            }

            return sb.toString();

//            String  tmpStr = sb.toString();
//            return tmpStr.substring(0,tmpStr.length()-1) + ")";
        }
        return null ;
    }

    public static String catSql(Set strSet) {
        int len = strSet.size();
        // sql 语句
        String strsql = "sql ";
        if (0 != len  && null != strSet) {
            StringBuffer sb = new StringBuffer("");

            StringBuffer newsb = new StringBuffer("");

            Iterator<String> it = strSet.iterator();

            int i = 0;
            while (it.hasNext()) {

                sb.append(strsql+"'"+it.next() + "';"+"\r\n");

            }
            return sb.toString();

//            String  tmpStr = sb.toString();
//            return tmpStr.substring(0,tmpStr.length()-1) + ")";
        }
        return null ;
    }





    public static  void main(String[] args){
        String a = "1,2,3,4,5,6,7,7";
        String readFile = "";
        String writeFile = "";




        System.out.print(cat(duplicate(a)));
        System.out.print(catSql(duplicate(a)));

    }


}
