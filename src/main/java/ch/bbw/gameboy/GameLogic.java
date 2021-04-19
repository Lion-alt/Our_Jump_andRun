package ch.bbw.gameboy;

import ch.bbw.gameboy.api.*;
import ch.bbw.gameboy.gameobjects.Ground;
import ch.bbw.gameboy.gameobjects.Logo;
import ch.bbw.gameboy.gameobjects.Smiley;
import ch.bbw.gameboy.gameobjects.Wall;
import ch.bbw.gameboy.impl.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ch.bbw.gameboy.api.ButtonController.GameButton.RIGHT;
import static ch.bbw.gameboy.api.ButtonController.GameButton.SPACE;

/**
 * Anchor point for the graphic {@link #tick()} and the user-interaction {@link #onButtonPress(GameButton)}.
 */
public class GameLogic implements ButtonController {

    private final PixelGraphic graphic;
    private final Smiley smiley;
    private final StarfieldExample starfield;
    private BackdgroundDesigner backdgroundDesigner = new BackdgroundDesigner();
    private SpriteMover spriteMover = new SpriteMover();


    private Integer color;

    private boolean onStartPosition = false;


    private boolean isFirstSpace = true;
    private boolean isFirstRightButton = true;
    private CopyOnWriteArrayList<Ground> grounds = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Wall> walls = new CopyOnWriteArrayList<>();

    public GameLogic(PixelGraphic graphic) {
        this.graphic = graphic;
        starfield = new StarfieldExample(graphic);
        smiley = new Smiley(graphic, 30, 80);
    }

    public static void main(String[] args) throws Throwable {
        GameBbwoy.main(args); // just here for a convenient button
    }

    /**
     * used to redraw the display. Executed with (more or less) constant frames per second.
     *
     * @see GameBbwoy#FPS
     */


    public void tick() {
        graphic.clear();
        backdgroundDesigner.draw(graphic, walls, grounds);
        spriteMover.draw(smiley);
        smiley.draw();
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
            case SPACE -> {
                spriteMover.setSpaceButtonClicked(false);

            }
        }
    }


}
