package factory;

public class AdvancedFactoryC implements BaseFactory {
    @Override
    public void print(String args) {
        System.out.println("multiple C " + args);
    }
}
