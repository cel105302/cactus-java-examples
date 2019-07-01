package factory;

public class AdvancedFactoryB implements BaseFactory {
    @Override
    public void print(String args) {
        System.out.println("multiple B " + args);
    }
}
