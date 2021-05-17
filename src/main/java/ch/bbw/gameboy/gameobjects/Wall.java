package ch.bbw.gameboy.gameobjects;

import ch.bbw.gameboy.api.PixelGraphic;

import java.util.List;

public class Wall extends GameObject {

    public Wall(PixelGraphic graphic, int x2, int y2) {
        var wall_data = List.of(List.of(
                3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 1, 1, 1, 3,
                3, 1, 1, 1, 1, 3, 3, 3,
                3, 3, 3, 1, 1, 1, 1, 3,
                3, 1, 1, 1, 3, 3, 1, 3,
                3, 3, 3, 1, 1, 1, 3, 3,
                3, 3, 1, 1, 3, 3, 1, 3,
                3, 3, 3, 3, 3, 3, 3, 3
                ), List.of(3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 1, 1, 1, 3,
                3, 1, 1, 1, 1, 3, 3, 3,
                3, 3, 3, 1, 1, 1, 1, 3,
                3, 1, 1, 1, 3, 3, 1, 3,
                3, 3, 3, 1, 1, 1, 3, 3,
                3, 3, 1, 1, 3, 3, 1, 3,
                3, 3, 3, 3, 3, 3, 3, 3)
        );
        // Draw in Parent Class GameObject
        super.draw(wall_data, graphic, x2, y2);
    }
}
