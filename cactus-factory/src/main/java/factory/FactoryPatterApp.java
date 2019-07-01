package factory;

public class FactoryPatterApp {

    public static void main(String[] args) {

        //私有静态final内部类
        SimpleFactoryBuilder.build();
        SimpleFactoryBuilder.build("我是私有静态final内部类带参构造器");


        MultipleFactoryBuilder mfb = new MultipleFactoryBuilder();
        BaseFactory moa = mfb.getMultipleObject("A");
        moa.print("A");

        BaseFactory mob = mfb.getMultipleObject("B");
        mob.print("B");

        BaseFactory moc = mfb.getMultipleObject("C");
        moc.print("C");


    }
}
