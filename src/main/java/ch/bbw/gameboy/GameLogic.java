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
    private BackgroundDesigner backdgroundDesigner;
    private SpriteMover spriteMover = new SpriteMover();
    private CopyOnWriteArrayList<Ground> grounds = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Wall> walls = new CopyOnWriteArrayList<>();
    private boolean isGameWon = false;

    public GameLogic(PixelGraphic graphic) {
        this.graphic = graphic;
        smiley = new Smiley(graphic, 30, 80);
        backdgroundDesigner = new BackgroundDesigner(graphic, walls, grounds, spriteMover);
    }

    public static void main(String[] args) throws Throwable {
        GameBbwoy.main(args); // just here for a convenient button
    }

    public void tick() {
        graphic.clear();
        if(!spriteMover.isEnterButtonClicked()) {
            backdgroundDesigner.draw();
            backdgroundDesigner.drawStartText();
        }
        if(spriteMover.isEnterButtonClicked()) {
            backdgroundDesigner.draw();
            if (!isGameWon) {
                spriteMover.tick(smiley);
            }
            smiley.draw();
            // If the Player has won
            if (winCondition()) {
                backdgroundDesigner.drawLogoTwiceForTheWin();
                isGameWon = true;
            }
        }

    }

    private boolean winCondition() {
        return smiley.getPositionX() == 150 && smiley.getPositionY() == 24;
    }


    @Override
    public void onButtonPress(ButtonController.GameButton button) {
        switch (button) {
            case RIGHT -> spriteMover.setRightButtonClicked(true);
            case SPACE -> spriteMover.setSpaceButtonClicked(true);
            case ENTER -> spriteMover.setEnterButtonClicked(true);
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