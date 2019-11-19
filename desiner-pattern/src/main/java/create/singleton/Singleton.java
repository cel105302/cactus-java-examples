package create.singleton;

/**
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，
 * 它提供了一种创建对象的最佳方式。
 * <p>
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问
 * 其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
 *
 * 有点
 * 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。
 * 2、避免对资源的多重占用（比如写文件操作）。
 *
 * 缺点
 * 没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 */
public class Singleton {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        Singleton object = SingleObject.getInstance();

        object = LazySingleton.getInstance();
        //sychronized
        object = LazySingleton1.getInstance();
        //双检锁
        object = BothCheckLockSigleton.getSingleton();
        //静态内部类
        StaticSingleton.getInstance();
        //枚举
        SingletonEnum.INSTANCE.whateverMethod();
    }
}

/**
 * 恶汉式
 */
class SingleObject extends Singleton {

    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
}

/**
 * 懒汉式，线程不安全
 */
class LazySingleton extends Singleton {
    private static LazySingleton instance;
    private LazySingleton (){}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 懒汉式，线程安全
 */
class LazySingleton1 extends Singleton {
    private static LazySingleton1 instance;
    private LazySingleton1 (){}
    public static synchronized LazySingleton1 getInstance() {
        if (instance == null) {
            instance = new LazySingleton1();
        }
        return instance;
    }
}

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 */
class BothCheckLockSigleton extends Singleton{
    private volatile static BothCheckLockSigleton singleton;
    private BothCheckLockSigleton (){}
    public static BothCheckLockSigleton getSingleton() {
        if (singleton == null) {
            synchronized (BothCheckLockSigleton.class) {
                if (singleton == null) {
                    singleton = new BothCheckLockSigleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 登记式/静态内部类 --> 可替代双检锁
 */
class StaticSingleton extends Singleton {
    private static class SingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }
    private StaticSingleton (){}
    public static final StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举
 */
enum SingletonEnum {
    INSTANCE;
    public void whateverMethod() {
    }
}


