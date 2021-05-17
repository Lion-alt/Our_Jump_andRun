package ch.bbw.gameboy;

import ch.bbw.gameboy.api.PixelGraphic;
import ch.bbw.gameboy.gameobjects.Ground;
import ch.bbw.gameboy.startobjects.GoText;
import ch.bbw.gameboy.startobjects.Logo;
import ch.bbw.gameboy.gameobjects.Wall;
import ch.bbw.gameboy.startobjects.EnterText;
import ch.bbw.gameboy.startobjects.ToText;

import java.util.concurrent.CopyOnWriteArrayList;

public class BackgroundDesigner {


    private SpriteMover spriteMover;
    private PixelGraphic graphic;
    private CopyOnWriteArrayList<Wall> walls;
    private CopyOnWriteArrayList<Ground> grounds;


    public BackgroundDesigner(PixelGraphic graphic, CopyOnWriteArrayList<Wall> walls, CopyOnWriteArrayList<Ground> grounds, SpriteMover spriteMover) {
        this.graphic = graphic;
        this.walls = walls;
        this.grounds = grounds;
        this.spriteMover = spriteMover;
    }

    public BackgroundDesigner() {
        // Constructor for tests
    }

    public void draw() {
        if (!spriteMover.isEnterButtonClicked()) {
            drawLogos();
        }
        drawGroundLine();
        drawWalls();
    }

    private void drawLogos() {
        Logo logo = new Logo(graphic, 25, 30);
        Logo logo1 = new Logo(graphic, 33, 30);
        Logo logo2 = new Logo(graphic, 17, 30);
        Logo logo3 = new Logo(graphic, 25, 22);
        Logo logo4 = new Logo(graphic, 25, 38);
    }

    private void drawWalls() {
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

    private void drawGroundLine() {
        // Create a ground line

        if (!spriteMover.isEnterButtonClicked()) {
            for (int x = 0; x < 155; x += 8) {
                for (int y = 97; y < 129; y += 32) {
                    if (x == 0) {
                        Ground ground1 = new Ground(graphic, x, y);
                        grounds.add(ground1);
                    }
                    if(x >= 100 ) {
                        for (Ground ground : grounds) {
                            ground = new Ground(graphic, x, y);
                        }    } else {
                        for (Ground ground : grounds) {
                            ground = new Ground(graphic, x, y);
                        }
                    }
                }
            }
        }

        if (spriteMover.isEnterButtonClicked()) {
            for (int x = 0; x < 155; x += 8) {
                for (int y = 97; y < 129; y += 32) {
                    if (x == 0) {
                        Ground ground1 = new Ground(graphic, x, y, spriteMover);
                        grounds.add(ground1);
                    }
                    for (Ground ground : grounds) {
                        ground = new Ground(graphic, x, y, spriteMover);
                    }
                }
            }
        }

    }

    public void drawLogoTwiceForTheWin() {
        Logo logo = new Logo(graphic, 55, 30);
        Logo logo1 = new Logo(graphic, 63, 30);
        Logo logo2 = new Logo(graphic, 47, 30);
        Logo logo3 = new Logo(graphic, 55, 22);
        Logo logo4 = new Logo(graphic, 55, 38);
    }

    public void drawStartText() {
        EnterText enterText1 = new EnterText(graphic, 130, 20);
        EnterText enterText2 = new EnterText(graphic, 130, 20);
        EnterText enterText3 = new EnterText(graphic, 130, 20);
        GoText goText1 = new GoText(graphic, 120, 20);
        ToText toText = new ToText(graphic, 110, 20);
    }
}
