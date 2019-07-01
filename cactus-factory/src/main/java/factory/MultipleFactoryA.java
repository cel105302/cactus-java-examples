package factory;

public class MultipleFactoryA implements BaseFactory {
    @Override
    public void print(String args) {
        System.out.println("multiple A " + args);
    }
}
