package ch.bbw.gameboy;

import ch.bbw.gameboy.api.PixelGraphic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundDesignerTest {

    @Test
    void drawLogoTwiceForTheWin() {
        PixelGraphic graphic = (x, y, color) -> {

        };
        BackgroundDesigner backgroundDesigner = new BackgroundDesigner();
        GameLogic gameLogic = new GameLogic(graphic);
        gameLogic.setGameWon(true);
        if(gameLogic.isGameWon()) {
            backgroundDesigner.drawLogoTwiceForTheWin();
        }
        assertTrue(gameLogic.isGameWon());
    }
}