package ch.bbw.gameboy;

import ch.bbw.gameboy.api.PixelGraphic;
import ch.bbw.gameboy.gameobjects.Smiley;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpriteMoverTest {

    @Test
    void setRightButtonClicked() {
        SpriteMover spriteMover = new SpriteMover();
        spriteMover.setRightButtonClicked(true);
        assertTrue(spriteMover.isRightButtonClicked());
    }

    @Test
    void setSpaceButtonClicked() {
        SpriteMover spriteMover = new SpriteMover();
        spriteMover.setSpaceButtonClicked(true);
        assertTrue(spriteMover.isSpaceButtonClicked());
    }

    @Test
    void tick() {
        SpriteMover spriteMover = new SpriteMover();
        int oldRightClickCounter = spriteMover.getRightClickCounter();
        PixelGraphic pixelGraphic= (x, y, color) -> {

        };
        Smiley smiley = new Smiley(pixelGraphic, 0, 0);
        spriteMover.setRightButtonClicked(true);
        spriteMover.tick(smiley);
        assertEquals(oldRightClickCounter + 1, spriteMover.getRightClickCounter());
    }

    @Test
    void tickIsGameWon() {
        SpriteMover spriteMover = new SpriteMover();
        PixelGraphic pixelGraphic = (x, y, color) -> {

        };
        GameLogic gameLogic = new GameLogic(pixelGraphic);
        Smiley smiley = new Smiley(pixelGraphic, 0, 0);
        if(!gameLogic.isGameWon()) {
            spriteMover.tick(smiley);
        }
    }
    @Test
    void xVelocity(){
        boolean testSuccess = false;
        SpriteMover spriteMover = new SpriteMover();
        PixelGraphic graphic = (x, y, color) -> {

        };
        Smiley smiley = new Smiley(graphic, 0, 0);
        spriteMover.tick(smiley);
        int actX = spriteMover.getActX();
        int rightClickCounter = spriteMover.getRightClickCounter();
        if(rightClickCounter == 0 && actX == 0){
            testSuccess = true;
        }
        assertTrue(testSuccess);
    }
}