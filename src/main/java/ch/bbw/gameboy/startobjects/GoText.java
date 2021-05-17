package ch.bbw.gameboy.startobjects;

import ch.bbw.gameboy.api.PixelGraphic;

import java.util.List;

public class GoText extends StartObject {
    public GoText(PixelGraphic graphic, int x, int y) {
        var enter_text_data = List.of(List.of(
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 3, 3, 0, 0, 3, 3, 0,
                3, 0, 0, 0, 3, 0, 0, 3,
                3, 0, 3, 0, 3, 0, 0, 3,
                0, 3, 3, 0, 0, 3, 3, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0
                ), List.of(0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 3, 3, 0, 0, 3, 3, 0,
                3, 0, 0, 0, 3, 0, 0, 3,
                3, 0, 3, 0, 3, 0, 0, 3,
                0, 3, 3, 0, 0, 3, 3, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0)
        );

        super.draw(enter_text_data, graphic, x, y);
    }
}
