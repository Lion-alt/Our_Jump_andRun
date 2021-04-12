package ch.bbw.gameboy.gameobjects;

import ch.bbw.gameboy.GameLogic;
import ch.bbw.gameboy.api.ButtonController;
import ch.bbw.gameboy.api.PixelGraphic;

import java.util.List;

public class Smiley extends GameObject {


    private final PixelGraphic graphic;
    private int positionX;
    private int positionY;

    private final List<List<Integer>> smiley_data;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    public Smiley(PixelGraphic graphic, int x2, int y2) {
        this.positionX  =x2;
        this.positionY = y2;
        this.graphic = graphic;
        smiley_data = List.of(List.of(
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
    }

    // Other Constructor for better creating of new Smileys after KeyEvents
    public Smiley(PixelGraphic graphic, int x2, int y2, ButtonController.GameButton button) {
        this.graphic = graphic;
        smiley_data = List.of(List.of(
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

    public void draw() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                var color = smiley_data.get(0).get(x + y * 8);
                graphic.setPixel(x + positionX, y + positionY, color);
            }
        }
    }
}
