package ch.bbw.gameboy.startobjects;

import ch.bbw.gameboy.api.PixelGraphic;
import ch.bbw.gameboy.gameobjects.GameObject;

import java.util.List;

public class Logo extends StartObject {
    public Logo(PixelGraphic graphic, int x2, int y2) {
        var logo_data = List.of(List.of(
                2, 0, 0, 0, 0, 0, 0, 2,
                0, 2, 2, 2, 2, 2, 2, 0,
                0, 2, 0, 2, 2, 0, 2, 0,
                0, 2, 2, 2, 2, 2, 2, 0,
                0, 2, 0, 2, 2, 0, 2, 0,
                0, 2, 2, 0, 0, 2, 2, 0,
                0, 2, 2, 2, 2, 2, 2, 0,
                2, 0, 0, 0, 0, 0, 0, 2
                ), List.of(2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2)
        );

        super.draw(logo_data, graphic, x2, y2);
    }
}
