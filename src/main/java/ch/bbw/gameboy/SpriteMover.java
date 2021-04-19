package ch.bbw.gameboy;

import ch.bbw.gameboy.api.PixelGraphic;
import ch.bbw.gameboy.gameobjects.Smiley;

public class SpriteMover {


    private int xVelocity = 1;

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    private double yVelocity = 0.8;
    private boolean isRightButtonClicked = false;
    private boolean isSpaceButtonClicked = false;
    private int spaceClickCounter = 0;


    public boolean isRightButtonClicked() {
        return isRightButtonClicked;
    }

    public boolean isSpaceButtonClicked() {
        return isSpaceButtonClicked;
    }

    public void setRightButtonClicked(boolean rightButtonClicked) {
        isRightButtonClicked = rightButtonClicked;
    }

    public void setSpaceButtonClicked(boolean spaceButtonClicked) {
        isSpaceButtonClicked = spaceButtonClicked;
    }

    public void draw(Smiley smiley) {

        int actX = 0;
        int actY = 0;
        // Create a Logo

        if (isRightButtonClicked) {
            actX = smiley.getPositionX() + xVelocity;
            actY = smiley.getPositionY();
            smiley.setPositionX(actX);
            smiley.setPositionY(actY);
            isRightButtonClicked = false;
        }

        if (isSpaceButtonClicked) {
            spaceClickCounter++;
            switch (spaceClickCounter) {
                case 1 -> yVelocity = 1;
                case 2 -> yVelocity = 0.9;
                case 3 -> yVelocity = 0.8;
                case 4 -> yVelocity = 0.7;
                case 5 -> yVelocity = 0.6;
                case 6 -> yVelocity = 0.5;
                case 7 -> yVelocity = 0.4;
                case 8 -> yVelocity = 0;
                case 9 -> yVelocity = -0.1;
                case 10 -> yVelocity = -0.2;
                case 11 -> yVelocity = -0.3;
                case 12 -> {
                    yVelocity = -0.4;
                    spaceClickCounter = 0;
                }
            }
            actX = smiley.getPositionX() + xVelocity;
            actY = (int) (smiley.getPositionY() - yVelocity);
            smiley.setPositionX(actX);
            smiley.setPositionY(actY);
            isSpaceButtonClicked = false;

        }


    }
}