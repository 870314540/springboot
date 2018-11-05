package com.example.demo.test.test1;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/7/17
 */
public class UserEntity {
    private String userName;
    private int userAge;

    private final int money = 10000;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getMoney() {
        System.out.println("借了"+money+"元");
        return money;
    }

    //还钱方法，单个参数
    public void repay(int money){
        System.out.println("你还了 " + money + "元！");
    }
    //还钱方法，多个参数
    public void repay(String userName,int money){
        System.out.println(userName+ " 还了 " + money + "元！");
    }
}
