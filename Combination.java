import java.util.*;

public class Combination {
    private Component parent1;
    private Component parent2;
    private Component child;
    private boolean discovered;

    public Combination(Component comp1, Component comp2, Component resultComponent) {
        this.parent1 = comp1;
        this.parent2 = comp2;
        this.child = resultComponent;
    }

    public Component getParent1(){
        return this.parent1;
    }

    public Component getParent2(){
        return this.parent2;
    }

    public Component getChild(){
        return this.child;
    }

}
