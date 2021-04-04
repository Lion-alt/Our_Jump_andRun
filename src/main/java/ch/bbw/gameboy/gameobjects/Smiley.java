package ch.bbw.gameboy.gameobjects;

import ch.bbw.gameboy.GameLogic;
import ch.bbw.gameboy.api.ButtonController;
import ch.bbw.gameboy.api.PixelGraphic;

import java.util.List;

public class Smiley extends GameObject {


    private int positionX;
    private int positionY;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Smiley(PixelGraphic graphic, int x2, int y2) {
        var smiley_data = List.of(List.of(
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

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                var color = smiley_data.get(0).get(x + y * 8);
                graphic.setPixel(x + x2, y + y2, color);
                positionX = x + x2;
                positionY = y + y2;
            }
        }
    }

    // Other Constructor for better creating of new Smileys after KeyEvents
    public Smiley(PixelGraphic graphic, int x2, int y2, ButtonController.GameButton button) {
        var smiley_data = List.of(List.of(
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
        switch (button) {
            case RIGHT, SPACE -> new Smiley(graphic, x2, y2);
        }

    }
}
