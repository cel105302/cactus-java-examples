package behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式（Memento Pattern）保存一个对象的某个状态，以便在适当的时候恢复对象。备忘录模式属于行为型模式。
 * <p>
 * 优点： 1、给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态。 2、实现了信息的封装，使得用户不需要关心状态的保存细节。
 * <p>
 * 缺点：消耗资源。如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。
 */
public class Memento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}

class MementoI {
    private String state;

    public MementoI(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public MementoI saveStateToMemento() {
        return new MementoI(state);
    }

    public void getStateFromMemento(MementoI Memento) {
        state = Memento.getState();
    }
}

class CareTaker {
    private List<MementoI> mementoList = new ArrayList<MementoI>();

    public void add(MementoI state) {
        mementoList.add(state);
    }

    public MementoI get(int index) {
        return mementoList.get(index);
    }
}


