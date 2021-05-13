package ch.bbw.gameboy.startobjects;

import ch.bbw.gameboy.api.PixelGraphic;

import java.util.List;

public abstract class StartObject {
    protected void draw(List<List<Integer>> logo_data, PixelGraphic graphic, int x2, int y2) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                var colorGround = logo_data.get(0).get(x + y * 8);
                graphic.setPixel(x + x2, y + y2, colorGround);
            }
        }
    }
}
