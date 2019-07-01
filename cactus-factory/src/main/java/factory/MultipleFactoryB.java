package factory;

public class MultipleFactoryB implements BaseFactory {
    @Override
    public void print(String args) {
        System.out.println("multiple B " + args);
    }
}
