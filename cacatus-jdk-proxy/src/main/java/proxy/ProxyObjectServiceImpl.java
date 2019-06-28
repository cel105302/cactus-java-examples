package proxy;

public class ProxyObjectServiceImpl implements ProxyObjectService {
    @Override
    public String sayHello(String greet) {
        System.out.println("my name is " + greet);

        return "哈哈，sa zi";
    }
}
