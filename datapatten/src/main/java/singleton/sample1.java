package singleton;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/12/7
 */
public class sample1 {
    public static void main(String[] args) {
        System.out.println(123);
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + TwoCheckSingleton.getInstance().hashCode() );
                }
            }).start();
        }

    }
}
