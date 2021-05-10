package ch.bbw.gameboy;

import ch.bbw.gameboy.api.*;
import ch.bbw.gameboy.gameobjects.Ground;
import ch.bbw.gameboy.gameobjects.Smiley;
import ch.bbw.gameboy.gameobjects.Wall;
import ch.bbw.gameboy.impl.*;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Anchor point for the graphic {@link #tick()} and the user-interaction {@link #onButtonPress(GameButton)}.
 */
public class GameLogic implements ButtonController {

    private final PixelGraphic graphic;
    private final Smiley smiley;
    private BackgroundDesigner backdgroundDesigner = new BackgroundDesigner();
    private SpriteMover spriteMover = new SpriteMover();
    private CopyOnWriteArrayList<Ground> grounds = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Wall> walls = new CopyOnWriteArrayList<>();
    private boolean isGameWon = false;

    public GameLogic(PixelGraphic graphic) {
        this.graphic = graphic;
        smiley = new Smiley(graphic, 30, 80);
    }

    public static void main(String[] args) throws Throwable {
        GameBbwoy.main(args); // just here for a convenient button
    }

    // TODO Startscreen machen mit Logo (mit Space kommt man auf den GameScreen)

    public void tick() {
        graphic.clear();
        backdgroundDesigner.draw(graphic, walls, grounds);
        if (!isGameWon) {
            spriteMover.tick(smiley);
        }
        smiley.draw();
        // If the Player has won
        if (smiley.getPositionX() == 150 && smiley.getPositionY() == 24) {
            backdgroundDesigner.drawLogoTwiceForTheWin(graphic);
            isGameWon = true;
        }
    }


    @Override
    public void onButtonPress(ButtonController.GameButton button) {
        switch (button) {
            case RIGHT -> spriteMover.setRightButtonClicked(true);
            case SPACE -> spriteMover.setSpaceButtonClicked(true);
        }
    }

    @Override
    public void onButtonRelease(ButtonController.GameButton button2) {
        switch (button2) {
            case RIGHT -> spriteMover.setRightButtonClicked(false);
            case SPACE -> spriteMover.setSpaceButtonClicked(false);
        }
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon(boolean gameWon) {
        isGameWon = gameWon;
    }

}