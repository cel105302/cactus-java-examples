package factory;

public class AdvancedFactoryA implements BaseFactory {
    @Override
    public void print(String args) {
        System.out.println("multiple A " + args);
    }
}
