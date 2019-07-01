package singleton;

/**
 * Title: 简陋型单例
 * Description : 优点：类加载时创建对象，保证实例对象一定存在
 *               缺点：如果没有被调用，则造成了资源的浪费
 * @author : cactus (仙人掌)
 * @since : 2019/6/28 16:12
 * @version: v1.0.0
 * @Copyright : cactus
 */
public class SimpleSingletonObject {

    private static final SimpleSingletonObject sso = new SimpleSingletonObject();

    private SimpleSingletonObject(){
        System.out.println("通过简单单例模式获取");
    }

    public static SimpleSingletonObject getInstance(){
        return sso;
    }
}
