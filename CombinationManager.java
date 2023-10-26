import java.util.*;

public class CombinationManager {
    private static List<Combination> combinations = new ArrayList<>();

    public static void addCombination(Combination combination) {
        combinations.add(combination);
    }

    public Component combineComponents(Component item1, Component item2) {
        for (Combination combination : combinations) {
            if (((combination.getParent1() == item1 && combination.getParent2() == item2)
                    || (combination.getParent1() == item2 && combination.getParent2() == item1))) {
                if (!combination.isDiscovered()) {
                    combination.setDiscovered(true);
                    return combination.getChild();
                }
            }
        }

        return null;
    }

    public Combination getParents(Component item) {
        for (Combination combination : combinations) {
            if (combination.getChild() == item) {
                return combination;
            }
        }
        return null;
    }
}
