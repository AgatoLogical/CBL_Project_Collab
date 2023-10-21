import java.util.*;

public class CombinationManager {
    private static List<Combination> combinations = new ArrayList<>();

    public static void addCombination(Combination combination){
        combinations.add(combination);
    }

    public Item combineItems(Item item1, Item item2){
        for (Combination combination : combinations) {
            if (((combination.getParent1() == item1 && combination.getParent2() == item2) || (combination.getParent1() == item2 && combination.getParent2() == item1))){
                return combination.getChild();
            }
        }

        return null;
    }
}
