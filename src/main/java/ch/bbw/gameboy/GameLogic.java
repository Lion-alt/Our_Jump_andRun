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

    // TODO KeyEvents einbinden

    private final PixelGraphic graphic;

    private final StarfieldExample starfield;

    private Integer color;
    private Smiley smiley;
    private Smiley smiley2;
    private boolean onStartPosition = false;
    private boolean isRightButtonClicked = false;
    private boolean isSpaceButtonClicked = false;
    private boolean isFirstSpace = true;
    private boolean isFirstRightButton = true;
    private CopyOnWriteArrayList<Ground> grounds = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Wall> walls = new CopyOnWriteArrayList<>();

    public GameLogic(PixelGraphic graphic) {
        this.graphic = graphic;
        starfield = new StarfieldExample(graphic);
    }

    public static void main(String[] args) throws Throwable {
        GameBbwoy.main(args); // just here for a convenient button
    }

    /**
     * used to redraw the display. Executed with (more or less) constant fames per second.
     *
     * @see GameBbwoy#FPS
     */


    public void tick() {
        graphic.clear();
        starfield.draw();


        // Instant important Variables

        int actX = 0;
        int actY = 0;

        // Create a Logo

        Logo logo = new Logo(graphic, 25, 30);
        Logo logo1 = new Logo(graphic, 33, 30);
        Logo logo2 = new Logo(graphic, 17, 30);
        Logo logo3 = new Logo(graphic, 25, 22);
        Logo logo4 = new Logo(graphic, 25, 38);

        // Place first Smiley
        if (!onStartPosition) {
            smiley = new Smiley(graphic, 30, 80);
            //onStartPosition = true;
        }


        if (isRightButtonClicked) {
            /*if (isFirstRightButton) {
                actX = smiley.getPositionX() + 3;
                actY = smiley.getPositionY() - 7;
                isFirstRightButton = false;
            }*/
            actX = smiley.getPositionX() + 3;
            actY = smiley.getPositionY() - 7;
            Smiley smiley2 = new Smiley(graphic, actX, actY, RIGHT);
            // isRightButtonClicked = false;
        }

        if (isSpaceButtonClicked) {
            /*if (isFirstSpace) {
                actX = smiley.getPositionX() + 3;
                actY = smiley.getPositionY() - 15;
                isFirstSpace = false;
            }*/
            actX = smiley.getPositionX() + 3;
            actY = smiley.getPositionY() - 15;
            Smiley smiley3 = new Smiley(graphic, actX, actY, SPACE);

            // isSpaceButtonClicked = false;
        }


        // Create a ground line
        for (int x = 0; x < 155; x += 8) {
            for (int y = 96; y < 128; y += 32) {
                if (x == 0) {
                    Ground ground1 = new Ground(graphic, x, y);
                    grounds.add(ground1);
                }
                for (Ground ground : grounds) {
                    ground = new Ground(graphic, x, y);
                }
            }
        }
        // Create the walls
        walls.add(new Wall(graphic, 30, 88));
        walls.add(new Wall(graphic, 40, 80));
        walls.add(new Wall(graphic, 50, 72));
        walls.add(new Wall(graphic, 60, 64));
        walls.add(new Wall(graphic, 70, 64));
        walls.add(new Wall(graphic, 80, 64));
        walls.add(new Wall(graphic, 90, 56));
        walls.add(new Wall(graphic, 100, 48));
        walls.add(new Wall(graphic, 110, 48));
        walls.add(new Wall(graphic, 120, 40));
        walls.add(new Wall(graphic, 130, 32));
        walls.add(new Wall(graphic, 140, 32));
        walls.add(new Wall(graphic, 150, 32));
    }


    @Override
    public void onButtonPress(ButtonController.GameButton button) {
        // TODO How can I draw a new sprite 3 pixels apart from the existing one and delete the existing one?
        switch (button) {
            case RIGHT -> smiley = new Smiley(graphic, smiley.getPositionX() + 8, smiley.getPositionY(), button);
            case SPACE -> smiley = new Smiley(graphic, smiley.getPositionX() + 8, smiley.getPositionY() - 8, button);
        }
    }

    @Override
    public void onButtonRelease(ButtonController.GameButton button2) {
        switch (button2) {
            case RIGHT -> isRightButtonClicked = true;
            case SPACE -> isSpaceButtonClicked = true;
        }
        tick();
    }


}
