package factory;

public class MultipleFactoryC implements BaseFactory {
    @Override
    public void print(String args) {
        System.out.println("multiple C " + args);
    }
}
