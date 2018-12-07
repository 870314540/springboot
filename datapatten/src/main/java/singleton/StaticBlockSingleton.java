package singleton;

/**
 * @author thomas
 * @Descrption
 * @create 2018/12/7
 * 静态代码块模式：在 sun.misc.Unsafe 的源码中却实际应用到了这种设计
 * 与饿汉模式相同，不存在多线程及反射打破单例的可能性。
 */
public final class StaticBlockSingleton {

    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }

    static {
        instance = new StaticBlockSingleton();
    }

    public static final StaticBlockSingleton getInstance() {
        return instance;
    }

}

