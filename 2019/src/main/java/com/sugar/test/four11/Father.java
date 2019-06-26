package com.sugar.test.four11;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/4/11
 */
public class Father {

    private String name;

    private String age ;

    private String tel;

    public void getName(){
        System.out.println("Father do");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setInfo(Father father){
        father.setAge("11");
        father.setName("000");
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public static void main(String[] args){
        Father father = new Son1();
        father.getName();
        father.setInfo(father);
        System.out.println(father);
    }
}
