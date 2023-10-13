import java.awt.*;
import javax.swing.*;

public class Workshop {

    private static final int numberOfSlots = 0;
    private static final int numberOfPages = 0;
    private static final int numberOfItems = 0;

    static Slot[][] slot = new Slot[numberOfSlots][numberOfPages];
    static Component[] component = new Component[numberOfItems];

    RecipeBook recipeBook = new RecipeBook();

    private int pageDisplayed;

    // other variables for rendering

    public void init() {
        // for all the slots and components
    }

    public void render() {
        // uses moveItem
        // uses goToRecipeBook?
        // uses scroll
    }

    private Point moveItem() {
        // to know the coord. of the place it is dropped?
        return null;
    }

    private void scroll() {
        // for the shelves
        // uses pageDisplayed
    }

    private void goToRecipeBook() {
        // when the button is clicked...
    }

    // goToShop
}
