package factory;

public class SimpleFactoryBuilder {

    public static SimpleFactoryObject build(){
        return build(null);
    }

    public static SimpleFactoryObject build(String args){
        if (args == null){
            return new SimpleFactoryObject();
        }

        return new SimpleFactoryObject(args);
    }

    private static final class SimpleFactoryObject implements BaseFactory{

        public SimpleFactoryObject(){
            this.print("我是私有静态final内部类无参构造器");
        };

        public SimpleFactoryObject(String args){
            System.out.println(args);
        }

        @Override
        public void print(String args) {
            System.out.println(args);
        }
    }
}
