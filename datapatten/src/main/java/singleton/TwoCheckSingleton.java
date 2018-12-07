package singleton;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/12/7
 * 双重校验锁DCL
 */
public class TwoCheckSingleton {
    /**
     * 构造函数私有,禁止外部实例化
     */
    private TwoCheckSingleton() {
    }
    //volatile 禁止重排序
    public static volatile TwoCheckSingleton singleton;



    public static TwoCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (TwoCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new TwoCheckSingleton();
                }
            }
        }
        return singleton;
    }
    public static void main(String[] args) {
        System.out.println(123);
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + TwoCheckSingleton.getInstance() );
                }
            }).start();
        }

    }
}
