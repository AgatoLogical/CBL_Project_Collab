import java.awt.*;
import javax.swing.*;

public class NameOfGame {

    Workshop workShop = new Workshop();

    void startPage() {

    }

    public void main(String[] args) {
        NameOfGame game = new NameOfGame();
        game.startPage();
        workShop.init();
        workShop.render();
    }
}
