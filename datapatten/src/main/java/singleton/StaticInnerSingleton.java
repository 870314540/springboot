package singleton;

/**
 * @author thomas
 * @Descrption
 * @create 2018/12/7
 * 利用静态内部类的特性，外部类的 getinstance() 方法，可以直接指向 Holder 持有的对象
 */
public class StaticInnerSingleton {

        private StaticInnerSingleton() {
            if (SingletonHolder.instance != null) {
                throw new IllegalStateException();
            }
        }

        private static class SingletonHolder {
            private static StaticInnerSingleton instance = new StaticInnerSingleton();
        }

        public static StaticInnerSingleton getInstance() {
            return SingletonHolder.instance;
        }

    }


