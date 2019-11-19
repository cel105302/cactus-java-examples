package behavior.iterator;

/**
 * 迭代器模式（Iterator Pattern）是 Java 和 .Net 编程环境中非常常用的设计模式。
 * 这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 * <p>
 * 迭代器模式属于行为型模式。
 * <p>
 * 优点： 1、它支持以不同的方式遍历一个聚合对象。
 * 2、迭代器简化了聚合类。
 * 3、在同一个聚合上可以有多个遍历。
 * 4、在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 * <p>
 * 缺点：由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，
 * 类的个数成对增加，这在一定程度上增加了系统的复杂性。
 */
public class Iterator {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (IteratorI iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}

interface IteratorI {
    public boolean hasNext();

    public Object next();
}

interface Container {
    public IteratorI getIterator();
}

class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    @Override
    public IteratorI getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements IteratorI {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
