package com.example.demo.threadtest.secret;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/12/28
 */
public class Secret {


        //加密移位参照
        static final String STR_AZ = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghklmnopqrstuvwxyz";
        static char[] ssTemp;

        //加密
        public String encrypt(String s) {
            StringBuffer ss = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char tempi = s.charAt(i);
                for (int j = 0; j < STR_AZ.length(); j++) {
                    //大于最大位后，从初的A取。形成循环
                    if (tempi == STR_AZ.charAt(j)) {
                        if ((j+3) >= STR_AZ.length()){
                            int z = j+3-STR_AZ.length();
                            ss.append(STR_AZ.charAt(z));
                        }else{
                            ss.append(STR_AZ.charAt(j+3));
                        }
                    }
                }
            }
            return ss.toString();
        }
        //解密
        public String decrypt(String s){
            StringBuffer ssde = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char tempi = s.charAt(i);
                for (int j = 0; j < STR_AZ.length(); j++) {
                    if (tempi == STR_AZ.charAt(j)) {
                        //小于最小位后，从最大的Z取，形成循环
                        if ((j-3) < 0 ){
                            int z = STR_AZ.length()+(j-3);
                            ssde.append(STR_AZ.charAt(z));
                        }else{
                            ssde.append(STR_AZ.charAt(j-3));
                        }
                    }
                }
            }
            return ssde.toString();
        }

        public static void main(String[] args){
            Secret move3 = new Secret();
            String s1 = "Uhg fkxufk";
            String s2 = "DBC";
            System.out.println("密码：");
            System.out.println(move3.decrypt(s1));
            System.out.println("解密：");
            System.out.println(move3.decrypt(s2));
        }


}
