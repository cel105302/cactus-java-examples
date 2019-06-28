package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObjectHandler implements InvocationHandler {
    Object object;

    public ProxyObjectHandler(Object object){
        this.object = object;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),this.object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我代理的method是：" + method.getName());

        Object res = method.invoke(object,args);

        System.out.println("我的任务完成了" + res);

        return res;
    }


}
