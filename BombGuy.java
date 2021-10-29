package demolition;
import java.util.ArrayList;



import processing.core.PApplet;
import processing.core.PImage;

public class BombGuy extends Player {
    PApplet appObject;
    int life;
    ArrayList<PImage> moveLeftSprites = new ArrayList<>();
    ArrayList<PImage> moveRightSprites= new ArrayList<>();
    ArrayList<PImage> moveUpSprites = new ArrayList<>();
    ArrayList<PImage> moveDownSprites = new ArrayList<>();
    // String direction;
 

    public BombGuy(Map mapObject, PApplet appObject, int x, int y) {
        super(mapObject, appObject, x, y);
        this.appObject = appObject;
        this.life = 3;
        // this.bombGuyImgLeftMoveDown = appObject.loadImage("\\src\\main\\resources\\player\\player2.png");
        loadBombGuyImages();

        super.moveDownSprites = this.moveDownSprites;
        super.moveUpSprites = this.moveUpSprites;
        super.moveRightSprites=this.moveRightSprites;
        super.moveLeftSprites = this.moveLeftSprites;

    }

//    public void render(){
//        int x=getX_coord();
//        int y=getY_coord()-32;
//        switch (direction) {
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
//    }



    public void loadBombGuyImages(){
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_left1.png"));
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_left2.png"));
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_left3.png"));
        moveLeftSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_left4.png"));

        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_right1.png"));
        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_right2.png"));
        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_right3.png"));
        moveRightSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_right4.png"));

        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_up1.png"));
        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_up2.png"));
        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_up3.png"));
        moveUpSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player_up4.png"));

        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player1.png"));
        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player2.png"));
        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player3.png"));
        moveDownSprites.add(appObject.loadImage("\\src\\main\\resources\\player\\player4.png"));

    }

    public void move(){
    }

   
}


  