package ch.bbw.gameboy;

import ch.bbw.gameboy.gameobjects.Smiley;

public class SpriteMover {


    private double xVelocity = 1;
    private double yVelocity = 0.8;
    private boolean isRightButtonClicked = false;
    private boolean isSpaceButtonClicked = false;
    private int spaceClickCounter = 0;
    private int rightClickCounter = 0;
    private int actX = 0;
    private int actY = 0;
    private boolean enterButtonClicked = false;


    public void tick(Smiley smiley) {
        if (isRightButtonClicked) {
            rightClickCounter++;
            switch(rightClickCounter) {
                case 1 -> xVelocity = 5.5;
                case 2 -> {
                    xVelocity = 0;
                    rightClickCounter = 0;
                }
            }
            actX = (int) (smiley.getPositionX() + xVelocity);
            actY = smiley.getPositionY();
            smiley.setPositionX(actX);
            smiley.setPositionY(actY);
            System.out.println(smiley.getPositionX());
            System.out.println(smiley.getPositionY());
            isRightButtonClicked = false;
        }

        if (isSpaceButtonClicked) {
            spaceClickCounter++;
            switch (spaceClickCounter) {
                case 1, 12, 23 -> yVelocity = 0.1;
                case 2, 13, 24 -> yVelocity = 0.5;
                case 3, 14, 25 -> yVelocity = 4;
                case 4, 15, 26 -> yVelocity = 0.8;
                case 5, 16, 27 -> yVelocity = 0.3;
                case 6, 7, 8, 9, 10, 17, 18, 19, 20, 21, 28, 29 -> yVelocity = 0;
                case 11, 22, 30, 32 -> yVelocity = -0.8;
                case 31, 34  -> yVelocity = 10;
                case 35 -> {
                    yVelocity = 0;
                    xVelocity = 5.5;
                }
                case 36 -> {
                    xVelocity = 2.7;
                }
                case 37 -> {
                    yVelocity = -2;

                }
                case 33 -> {
                    yVelocity = -2;
                    xVelocity = 0;
                }

                case 38 -> {
                    yVelocity = 0;
                    xVelocity = 1.5;
                }
                case 39 -> {
                    yVelocity = 15;
                }
                case 40 -> xVelocity = 5.5;
                case 41 -> yVelocity = -9.5;
                case 42 -> {
                    xVelocity = 5.5;
                    yVelocity = -5.5;
                }
                case 43 -> {
                    yVelocity = -0.8;
                    spaceClickCounter = 0;
                }
            }


            actX = (int) ( smiley.getPositionX() + xVelocity);
            actY = (int) (smiley.getPositionY() - yVelocity);
            smiley.setPositionX(actX);
            smiley.setPositionY(actY);

            isSpaceButtonClicked = false;
        }
    }

    public void setRightButtonClicked(boolean rightButtonClicked) {
        isRightButtonClicked = rightButtonClicked;
    }

    public void setSpaceButtonClicked(boolean spaceButtonClicked) {
        isSpaceButtonClicked = spaceButtonClicked;
    }

    public boolean isRightButtonClicked() {
        return isRightButtonClicked;
    }

    public boolean isSpaceButtonClicked() {
        return isSpaceButtonClicked;
    }


    public int getRightClickCounter() {
        return rightClickCounter;
    }

    public int getActX() {
        return actX;
    }

    public int getActY() {
        return actY;
    }


    public void setEnterButtonClicked(boolean enterButtonClicked) {
        this.enterButtonClicked = enterButtonClicked;
    }

    public boolean isEnterButtonClicked() {
        return enterButtonClicked;
    }
}