package demolition;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

// event management (keystrokes)

public abstract class Player {
    int x_coord;
    int y_coord;
    int bombGuyPositionX;
    int bombGuyPositionY;
    int redEnemyPositionX;
    int redEnemyPositionY;
    int yellowEnemyPositionX;
    int yellowEnemyPositionY;
    PApplet appObject;
    String direction;
    boolean isKilled;

    ArrayList<PImage> moveLeftSprites = new ArrayList<>();
    ArrayList<PImage> moveRightSprites= new ArrayList<>();
    ArrayList<PImage> moveUpSprites = new ArrayList<>();
    ArrayList<PImage> moveDownSprites = new ArrayList<>();

    protected String[] directions = {"Up", "Right", "Down", "Left"};

    Map myMap;

    public Player(Map mapObject, PApplet appObject, int x, int y){
        myMap = mapObject;
        this.appObject=appObject;
        this.x_coord = x;
        this.y_coord = y;
        this.direction = "Down";
        this.isKilled = false;
        // this.bombGuyPositionX = mapObject.getBombGuyPositionX();
        // this.bombGuyPositionY = mapObject.getBombGuyPositionY();
        // this.redEnemyPositionX = mapObject.getRedEnemyPositionX();
        // this.redEnemyPositionY = mapObject.getRedEnemyPositionY();
        // this.yellowEnemyPositionX = mapObject.getYellowEnemyPositionX();
        // this.yellowEnemyPositionY = mapObject.getYellowEnemyPositionY();

    }

    public void add_x_direction(){   
        this.x_coord += 32;
    }
    public void add_y_direction(){
        this.y_coord  += 32;
    }

    public void sub_y_direction(){
        this.y_coord -= 32;
    }

    public void sub_x_direction(){
        this.x_coord-=32;
    }
 
// string direction
// right x-32
// left +32
// up y+
// down y-

    public boolean collidesWithWall(String direction){  // check if they have collided with wall
        if (direction.equals("Left")){
            for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
                if (myMap.solidWallCoords.get(i)+32 == this.x_coord && myMap.solidWallCoords.get(i+1) == this.y_coord){
                    return true;
                }
            }
            for(int i = 0 ; i < myMap.brokenWallCoords.size(); i = i+2){
                if (myMap.brokenWallCoords.get(i)+32 == this.x_coord && myMap.brokenWallCoords.get(i+1) == this.y_coord){
                    return true;
                }
            }
        }
        else if (direction.equals("Right")){
            for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
                if (myMap.solidWallCoords.get(i)-32 == this.x_coord && myMap.solidWallCoords.get(i+1) == this.y_coord){
                    return true;
                }
            }

            for(int i = 0 ; i < myMap.brokenWallCoords.size(); i = i+2){
                if (myMap.brokenWallCoords.get(i)-32 == this.x_coord && myMap.brokenWallCoords.get(i+1)== this.y_coord){
                    return true;
                }
            }
        }
        else if (direction.equals("Up")){
            for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
                if (myMap.solidWallCoords.get(i) == this.x_coord && myMap.solidWallCoords.get(i+1)+32 == this.y_coord){
                    return true;
                }
            }

            for(int i = 0 ; i < myMap.brokenWallCoords.size(); i = i+2){
                if (myMap.brokenWallCoords.get(i) == this.x_coord && myMap.brokenWallCoords.get(i+1)+32 == this.y_coord){
                    return true;
                }
            }
        }

        else if (direction.equals("Down")){
            for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
                if (myMap.solidWallCoords.get(i) == this.x_coord && myMap.solidWallCoords.get(i+1) -32 == this.y_coord){
                    return true;
                }
            }

            for(int i = 0 ; i < myMap.brokenWallCoords.size(); i = i+2){
                if (myMap.brokenWallCoords.get(i) == this.x_coord && myMap.brokenWallCoords.get(i+1)-32 == this.y_coord){
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean bombCollision(){
        return false;
    }

    // move method for both enemies ........................................

    public void move(String randomDirection) {
        if (randomDirection.equals("Left")) {
            direction = "Left";
            this.sub_x_direction();
        } else if (randomDirection.equals("Right")) {
            direction = "Right";
            this.add_x_direction();
        } else if (randomDirection.equals("Down")) {
            direction = "Down";
            this.add_y_direction();
        } else if (randomDirection.equals("Up")) {
            direction = "Up";
            this.sub_y_direction();
        }
    }

    public void render() {
        // appObject.image(this.redEnemyImg, x, y - 32);
        int x=getX_coord();
        int y=getY_coord()-32;   // if !iskilled -> render
        switch (this.direction) {
            case "Down":
                if (App.count == 48) {
                    App.count = 0;
                }
                if (App.count >= 0 && App.count <= 12) {
                    appObject.image(moveDownSprites.get(0), x, y);
                } else if (App.count >= 12 && App.count <= 24) {
                    appObject.image(moveDownSprites.get(1), x, y);
                } else if (App.count >= 24 && App.count <= 36) {
                    appObject.image(moveDownSprites.get(2), x, y);
                } else if (App.count >= 36 && App.count <= 48) {
                    appObject.image(moveDownSprites.get(3), x, y);
                }
                break;
            case "Left":
                if (App.count == 48) {
                    App.count = 0;
                }
                if (App.count >= 0 && App.count <= 12) {
                    appObject.image(moveLeftSprites.get(0), x, y);
                } else if (App.count >= 12 && App.count <= 24) {
                    appObject.image(moveLeftSprites.get(1), x, y);
                } else if (App.count >= 24 && App.count <= 36) {
                    appObject.image(moveLeftSprites.get(2), x, y);
                } else if (App.count >= 36 && App.count <= 48) {
                    appObject.image(moveLeftSprites.get(3), x, y);
                }
                break;
            case "Right":
                if (App.count == 48) {
                    App.count = 0;
                }
                if (App.count >= 0 && App.count <= 12) {
                    appObject.image(moveRightSprites.get(0), x, y);
                } else if (App.count >= 12 && App.count <= 24) {
                    appObject.image(moveRightSprites.get(1), x, y);
                } else if (App.count >= 24 && App.count <= 36) {
                    appObject.image(moveRightSprites.get(2), x, y);
                } else if (App.count >= 36 && App.count <= 48) {
                    appObject.image(moveRightSprites.get(3), x, y);
                }
                break;
            case "Up":
                if (App.count == 48) {
                    App.count = 0;
                }
                if (App.count >= 0 && App.count <= 12) {
                    appObject.image(moveUpSprites.get(0), x, y);
                } else if (App.count >= 12 && App.count <= 24) {
                    appObject.image(moveUpSprites.get(1), x, y);
                } else if (App.count >= 24 && App.count <= 36) {
                    appObject.image(moveUpSprites.get(2), x, y);
                } else if (App.count >= 36 && App.count <= 48) {
                    appObject.image(moveUpSprites.get(3), x, y);
                }
                break;
        }

    }



// public void playerCoordinate(String level){
        
//     File f= new File(level);     //Creation of File Descriptor for input file
//     try{
//     FileReader fr=new FileReader(f);   //Creation of File Reader object
    
//         BufferedReader brFile = new BufferedReader(fr);  //Creation of BufferedReader object
//         int c = 0; 
//         int x = 0;
//         int y = 64;
//         while((c = brFile.read()) != -1){         //Read char by Char
        
//                 char character = (char) c;          //converting integer to char
//                 if (character == 'P'){
//                     this.bombGuyPositionX = x;
//                     this.bombGuyPositionY  = y; 
//                 }
//                 if (character == 'R'){
//                     redEnemyPositionX = x;
//                     redEnemyPositionY  = y; 
//                 }
//                 if (character == 'Y'){
//                     yellowEnemyPositionX = x;
//                     yellowEnemyPositionY = y; 
//                 }
//                 x += 32;
//                 if (x == 480){
//                     y += 32;
//                     x = -64;
//                 }
//         }

//     }catch (Exception e){
        
//     }
// }

    // public int getBombGuyPositionX(){
    //     return bombGuyPositionX;
    // }
    // public int getBombGuyPositionY(){
    //     return bombGuyPositionY;
    // }

    // public int getRedEnemyPositionX(){
    //     return redEnemyPositionX;
    // }
    // public int getRedEnemyPositionY(){
    //     return redEnemyPositionY;
    // }

    // public int getYellowEnemyPositionX(){
    //     return yellowEnemyPositionX;
    // }
    // public int getYellowEnemyPositionY(){
    //     return yellowEnemyPositionY;
    // }

    public int getX_coord(){
        return this.x_coord;
    }

    public int getY_coord(){
        return this.y_coord;
    }

    public void setX_coord(int x){
        this.x_coord = x;
    }

    public void setY_coord(int y){
        this.y_coord = y;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){
       return this.direction;
    }


}