package factory;

public class MultipleFactoryBuilder {
    public BaseFactory getMultipleObject(String type){
        if (type.equalsIgnoreCase("A")){
            return new MultipleFactoryA();
        }else if (type.equalsIgnoreCase("B")){
            return new MultipleFactoryB();
        }else if (type.equalsIgnoreCase("C")){
            return new MultipleFactoryC();
        }

        return null;
    }
}
