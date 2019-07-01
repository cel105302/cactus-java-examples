package singleton;

public class SingletonApp {
    public static void main(String[] args) {
        //简单单例
        SimpleSingletonObject oss = SimpleSingletonObject.getInstance();

        //增强单例
        StrongthSingletonObject ssso = StrongthSingletonObject.getInstance();

    }

}
