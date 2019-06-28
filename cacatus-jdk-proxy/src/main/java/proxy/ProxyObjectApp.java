package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyObjectApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        /*反射*/
        Class clazz = Class.forName("io.grpc.examples.helloworld.proxy.ProxyObjectServiceImpl");
        Method method = clazz.getMethod("sayHello", String.class);
        method.invoke(clazz.newInstance(), "反射");

        /*动态代理*/
        ProxyObjectHandler handler = new ProxyObjectHandler(new ProxyObjectServiceImpl());
        ((ProxyObjectService)handler.getInstance()).sayHello("动态代理");
    }
}
