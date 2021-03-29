package ch.bbw.gameboy;

import ch.bbw.gameboy.api.*;
import ch.bbw.gameboy.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Anchor point for the graphic {@link #tick()} and the user-interaction {@link #onButtonPress(GameButton)}.
 */
public class GameLogic implements ButtonController {


    // TODO Spielelemente designen(Background, Spielfigur, Blöcke in der Luft, Boden, usw..
    // TODO KeyEvents einbinden

    private final PixelGraphic graphic;

    private final StarfieldExample starfield;

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


        var piskel_data = List.of(List.of(
                0, 1, 1, 1, 1, 1, 1, 0,
                1, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 1, 0, 0, 1, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 1, 0, 0, 1, 0, 1,
                1, 0, 0, 1, 1, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 1,
                0, 1, 1, 1, 1, 1, 1, 0
                ), List.of(0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0)
        );
        var ground_data = List.of(List.of(
                1, 2, 2, 2, 2, 2, 2, 1,
                2, 1, 1, 1, 1, 1, 1, 2,
                2, 1, 2, 1, 1, 2, 1, 2,
                2, 1, 1, 1, 1, 1, 1, 2,
                2, 1, 2, 1, 1, 2, 1, 2,
                2, 1, 1, 2, 2, 1, 1, 2,
                2, 1, 1, 1, 1, 1, 1, 2,
                1, 2, 2, 2, 2, 2, 2, 1
        ), List.of(1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2)
        );

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                var color = piskel_data.get(0).get(x + y * 8);
                graphic.setPixel(x + 1, y + 1, color);
            }
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                var color2 = piskel_data.get(0).get(x + y * 8);
                graphic.setPixel(x + graphic.getPixelWidth() / 2, y + graphic.getPixelHeight() / 2, color2);
            }
        }
    }


    @Override
    public void onButtonPress(ButtonController.GameButton button) {

    }

    @Override
    public void onButtonRelease(ButtonController.GameButton button2) {

    }
}
