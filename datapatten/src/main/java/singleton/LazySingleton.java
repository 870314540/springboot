package singleton;

/**
 * @author thomas
 * @Descrption
 * @create 2018/12/7
 * 懒汉模式:
 *  只适合单线程
 *  加synchronized 可用于多线程
 */
public class LazySingleton {

    private static LazySingleton instance;
    //　　Java 语言提供了许多禁止指令重排的方式，而在这里，给 instance 加上另一层限制：volatile，则是最好的解决方案。
   // private static volatile LazySingleton instance;


    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        //get的时候初始化
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}


