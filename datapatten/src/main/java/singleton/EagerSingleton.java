package singleton;

/**
 * @author thomas
 * @Descrption
 * @create 2018/12/7
 * 饿汉模式:是类持有一个自身的 instance 属性，并且在申明的同时立即初始化
 */
public class EagerSingleton {
    //初始化
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    public static final EagerSingleton getInstance() {
        return instance;
    }

}

