package demolition;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class YellowEnemy extends Player {
    PApplet appObject;
    ArrayList<PImage> moveLeftSprites = new ArrayList<>();
    ArrayList<PImage> moveRightSprites = new ArrayList<>();
    ArrayList<PImage> moveUpSprites = new ArrayList<>();
    ArrayList<PImage> moveDownSprites = new ArrayList<>();
    PImage yellowEnemyImg;

    public YellowEnemy(Map mapObject, PApplet appObject, int x, int y) {
        super(mapObject,appObject, x, y);
        this.appObject = appObject;
        this.yellowEnemyImg = appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_down1.png");
        loadYellowEnemyImages();
        super.moveDownSprites = this.moveDownSprites;
        super.moveUpSprites = this.moveUpSprites;
        super.moveRightSprites=this.moveRightSprites;
        super.moveLeftSprites = this.moveLeftSprites;
    }

    //public void render(int x, int y) {
//        appObject.image(this.yellowEnemyImg, x, y - 32);
//    }

    public void loadYellowEnemyImages() {

        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_left1.png"));
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_left2.png"));
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_left3.png"));
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_left4.png"));

        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_right1.png"));
        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_right2.png"));
        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_right3.png"));
        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_right4.png"));

        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_up1.png"));
        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_up2.png"));
        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_up3.png"));
        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_up4.png"));

        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_down1.png"));
        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_down2.png"));
        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_down3.png"));
        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\yellow_enemy\\yellow_down4.png"));

    }

//    public void render() {
//        // appObject.image(this.redEnemyImg, x, y - 32);
//        int x=getX_coord();
//        int y=getY_coord()-32;
//        switch (this.direction) {
//            case "Down":
//                if (App.count == 48) {
//                    App.count = 0;
//                }
//                if (App.count >= 0 && App.count <= 12) {
//                    appObject.image(moveDownSprites.get(0), x, y);
//                } else if (App.count >= 12 && App.count <= 24) {
//                    appObject.image(moveDownSprites.get(1), x, y);
//                } else if (App.count >= 24 && App.count <= 36) {
//                    appObject.image(moveDownSprites.get(2), x, y);
//                } else if (App.count >= 36 && App.count <= 48) {
//                    appObject.image(moveDownSprites.get(3), x, y);
//                }
//                break;
//            case "Left":
//                if (App.count == 48) {
//                    App.count = 0;
//                }
//                if (App.count >= 0 && App.count <= 12) {
//                    appObject.image(moveLeftSprites.get(0), x, y);
//                } else if (App.count >= 12 && App.count <= 24) {
//                    appObject.image(moveLeftSprites.get(1), x, y);
//                } else if (App.count >= 24 && App.count <= 36) {
//                    appObject.image(moveLeftSprites.get(2), x, y);
//                } else if (App.count >= 36 && App.count <= 48) {
//                    appObject.image(moveLeftSprites.get(3), x, y);
//                }
//                break;
//            case "Right":
//                if (App.count == 48) {
//                    App.count = 0;
//                }
//                if (App.count >= 0 && App.count <= 12) {
//                    appObject.image(moveRightSprites.get(0), x, y);
//                } else if (App.count >= 12 && App.count <= 24) {
//                    appObject.image(moveRightSprites.get(1), x, y);
//                } else if (App.count >= 24 && App.count <= 36) {
//                    appObject.image(moveRightSprites.get(2), x, y);
//                } else if (App.count >= 36 && App.count <= 48) {
//                    appObject.image(moveRightSprites.get(3), x, y);
//                }
//                break;
//            case "Up":
//                if (App.count == 48) {
//                    App.count = 0;
//                }
//                if (App.count >= 0 && App.count <= 12) {
//                    appObject.image(moveUpSprites.get(0), x, y);
//                } else if (App.count >= 12 && App.count <= 24) {
//                    appObject.image(moveUpSprites.get(1), x, y);
//                } else if (App.count >= 24 && App.count <= 36) {
//                    appObject.image(moveUpSprites.get(2), x, y);
//                } else if (App.count >= 36 && App.count <= 48) {
//                    appObject.image(moveUpSprites.get(3), x, y);
//                }
//                break;
//        }
//
//    }

    public void step() {
        if (!this.collidesWithWall("Left") && this.direction.equals("Left")) {
            this.sub_x_direction();
        } else if (!this.collidesWithWall("Right") && this.direction.equals("Right")) {
            this.add_x_direction();
        } else if (!this.collidesWithWall("Down") && this.direction.equals("Down")) {
            this.add_y_direction();
        } else if (!this.collidesWithWall("Up") && this.direction.equals("Up")) {
            this.sub_y_direction();
        } else {
            this.direction = this.clockwiseDirection(this.direction);
            //System.out.println(this.direction);
            this.move(this.direction);
        }
    }

    public String clockwiseDirection(String direction) {
        int i=0;
        String newDirection;

            for (int c=0;c<4;c++)
            {
                if (direction.equals(directions[c]))
                {
                    i=c;
                }
            }

        while (true)
        {
            newDirection = directions[(i+1)%4];
            i++;

            if (!collidesWithWall(newDirection))
            {
                return newDirection;
            }
        }
    }
}