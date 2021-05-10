package ch.bbw.gameboy;

import ch.bbw.gameboy.api.PixelGraphic;
import ch.bbw.gameboy.gameobjects.GameObject;
import ch.bbw.gameboy.gameobjects.Ground;
import ch.bbw.gameboy.gameobjects.Logo;
import ch.bbw.gameboy.gameobjects.Wall;

import java.util.concurrent.CopyOnWriteArrayList;

public class BackgroundDesigner {


    public void draw(PixelGraphic graphic, CopyOnWriteArrayList<Wall> walls, CopyOnWriteArrayList<Ground> grounds) {
        drawLogos(graphic);
        drawGroundLine(graphic, grounds);
        drawWalls(graphic, walls);
    }

    private void drawLogos(PixelGraphic graphic) {
        Logo logo = new Logo(graphic, 25, 30);
        Logo logo1 = new Logo(graphic, 33, 30);
        Logo logo2 = new Logo(graphic, 17, 30);
        Logo logo3 = new Logo(graphic, 25, 22);
        Logo logo4 = new Logo(graphic, 25, 38);
    }

    private void drawWalls(PixelGraphic graphic, CopyOnWriteArrayList<Wall> walls) {
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

    private void drawGroundLine (PixelGraphic graphic, CopyOnWriteArrayList<Ground> grounds) {
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
    }

    public void drawLogoTwiceForTheWin(PixelGraphic graphic) {
        Logo logo = new Logo(graphic, 55, 30);
        Logo logo1 = new Logo(graphic, 63, 30);
        Logo logo2 = new Logo(graphic, 47, 30);
        Logo logo3 = new Logo(graphic, 55, 22);
        Logo logo4 = new Logo(graphic, 55, 38);
    }
}
