package ch.bbw.gameboy.startobjects;

import ch.bbw.gameboy.api.PixelGraphic;

import java.util.List;

public class StartText extends StartObject {
    public StartText(PixelGraphic graphic, int x, int y) {
        var start_text_data = List.of(List.of(
                0, 0, 3, 0, 0, 0, 3, 3,
                0, 3, 0, 3, 3, 3, 0, 3,
                0, 3, 0, 0, 3, 0, 0, 3,
                0, 3, 0, 0, 3, 0, 3, 3,
                3, 0, 3, 0, 0, 3, 0, 3,
                0, 3, 0, 3, 0, 3, 3, 0,
                3, 0, 3, 0, 3, 3, 0, 3,
                0, 0, 0, 0, 0, 0, 0, 0,
                3, 0, 3, 0, 0, 3, 0, 3,
                0, 3, 0, 3, 0, 3, 3, 0,
                3, 0, 3, 0, 3, 3, 0, 3,
                0, 0, 0, 0, 0, 0, 0, 0

                ), List.of(        3, 0, 3, 0, 0, 3, 0, 3,
                0, 3, 0, 3, 0, 3, 3, 0,
                3, 0, 3, 0, 3, 3, 0, 3,
                0, 0, 0, 0, 0, 0, 0, 0,
                3, 0, 3, 0, 0, 3, 0, 3,
                0, 3, 0, 3, 0, 3, 3, 0,
                3, 0, 3, 0, 3, 3, 0, 3,
                0, 0, 0, 0, 0, 0, 0, 0,
                3, 0, 3, 0, 0, 3, 0, 3,
                0, 3, 0, 3, 0, 3, 3, 0,
                3, 0, 3, 0, 3, 3, 0, 3,
                0, 0, 0, 0, 0, 0, 0, 0)
        );

        super.draw(start_text_data, graphic, x, y);


    }
}
