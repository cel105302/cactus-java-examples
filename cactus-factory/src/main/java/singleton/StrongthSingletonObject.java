package singleton;

/**
 * Title: 增强型单例
 * Description : 优点：保证按需创建，并且只允许一个线程创建实例
 *               缺点：多线程会造成阻塞
 * @author : cactus (仙人掌)
 * @since : 2019/6/28 16:12
 * @version: v1.0.0
 * @Copyright : cactus
 */
public class StrongthSingletonObject {
    private static final Object object = new Object();
    private static StrongthSingletonObject oss;

    private StrongthSingletonObject() {
        System.out.println("增强型单例，通过加锁实现");
    }

    public static StrongthSingletonObject getInstance() {
        //锁住目标对象，只允许一个线程创建该对象
        if (oss == null) {
            synchronized (object) {
                if (oss == null) {
                    oss = new StrongthSingletonObject();
                }
            }
        }

        return oss;
    }
}
