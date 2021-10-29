package demolition;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Bomb {
    Map myMap;
    PApplet appObject;
    int bombX;
    int bombY;
    String bombPath;
    String explosionPath;
    int bombFrameCount;
    ArrayList<PImage> bombImages = new ArrayList<>();
    ArrayList<PImage> explosionImages = new ArrayList<>();


    public Bomb(Map mapObj, PApplet appObj){
        myMap = mapObj;
        appObject =  appObj;
        // this.bombX = x;
        // this.bombY = y;
        this.bombFrameCount = 0;
        loadBombImages();
        loadExplosionImages();    
    }

public void setBombX(int x){
    this.bombX = x;
    
}
public void setBombY(int y){
    this.bombY = y;
    
}

public int getBombX(){
   return  this.bombX;
    
}
public int getBombY(){
    return this.bombY; 
    
}

public void renderPlaceBomb(){  
   
    // if(bombFrameCount == 120){
    //     bombFrameCount = 0;
    // }

    if(bombFrameCount <= 0 && bombFrameCount <= 15){
        appObject.image(bombImages.get(0), bombX, bombY);
    }
    else if(bombFrameCount <= 16 && bombFrameCount <= 30){
        appObject.image(bombImages.get(1), bombX, bombY);
    }
    else if(bombFrameCount <= 31 && bombFrameCount <= 45){
        appObject.image(bombImages.get(2), bombX, bombY);
    }
    else if(bombFrameCount <= 46 && bombFrameCount <= 60){
        appObject.image(bombImages.get(3), bombX, bombY);
    }
    else if(bombFrameCount <= 61 && bombFrameCount <= 75){
        appObject.image(bombImages.get(4), bombX, bombY);
    }
    else if(bombFrameCount <= 76 && bombFrameCount <= 90){
        appObject.image(bombImages.get(5), bombX, bombY);
    }
    else if(bombFrameCount <= 91 && bombFrameCount <= 105){
        appObject.image(bombImages.get(6), bombX, bombY);
    }
    else if(bombFrameCount <= 106 && bombFrameCount <= 120){
        appObject.image(bombImages.get(7), bombX, bombY);
    }

    else if(bombFrameCount >=121 && bombFrameCount <= 150){
        renderExplosion();
    }
    // else if(bombFrameCount >=131 && bombFrameCount <= 140){
    //     renderExplosion();
    // }
    // else if(bombFrameCount >=141 && bombFrameCount <= 150){
    //     renderExplosion();
    // }

    bombFrameCount++;
    
}


public void loadBombImages(){
    bombPath = "\\src\\main\\resources\\bomb\\";
    for(int i = 1; i <= 8 ; i++){
        bombImages.add(appObject.loadImage(bombPath + "bomb"+ i + ".png"));
    }

}

public void loadExplosionImages(){
    explosionPath = "\\src\\main\\resources\\explosion\\";
    explosionImages.add(appObject.loadImage(explosionPath +"centre.png"));          // 0
    explosionImages.add(appObject.loadImage(explosionPath +"end_bottom.png"));         // 1
    explosionImages.add(appObject.loadImage(explosionPath +"end_top.png"));             // 2 
    explosionImages.add(appObject.loadImage(explosionPath +"end_left.png"));        // 3
    explosionImages.add(appObject.loadImage(explosionPath +"end_right.png"));       // 4
    explosionImages.add(appObject.loadImage(explosionPath +"horizontal.png"));      // 5
    explosionImages.add(appObject.loadImage(explosionPath +"vertical.png"));        // 6

}

public void renderExplosion(){
    appObject.image(explosionImages.get(0), bombX, bombY);
    appObject.image(explosionImages.get(5), bombX + 32 , bombY); // horizontal right
    appObject.image(explosionImages.get(5), bombX - 32, bombY); // hori.left
    appObject.image(explosionImages.get(6), bombX, bombY - 32); // verti top
    appObject.image(explosionImages.get(6), bombX, bombY + 32); // verti bottom
    appObject.image(explosionImages.get(2), bombX, bombY - 64); // end top
    appObject.image(explosionImages.get(1), bombX, bombY + 64); // end bottom
    appObject.image(explosionImages.get(3), bombX - 64, bombY); // end left
    appObject.image(explosionImages.get(4), bombX + 64, bombY); // end right
}

// public boolean hinderedByWall(){

// }



// fire coordinate -> player coordinate : check for red, yellow, bombguy
// bomb guy -> life - 1 : 









// public boolean collidesWithWall(String direction){  // check if they have collided with wall
//     if (direction.equals("Left")){
//         for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
//             if (myMap.solidWallCoords.get(i)+32 == this.x_coord && myMap.solidWallCoords.get(i+1) == this.y_coord){
//                 return true;
//             }
//         }
        
//     }
//     else if (direction.equals("Right")){
//         for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
//             if (myMap.solidWallCoords.get(i)-32 == this.x_coord && myMap.solidWallCoords.get(i+1) == this.y_coord){
//                 return true;
//             }
//         }

        
//     }
//     else if (direction.equals("Up")){
//         for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
//             if (myMap.solidWallCoords.get(i) == this.x_coord && myMap.solidWallCoords.get(i+1)+32 == this.y_coord){
//                 return true;
//             }
//         }

        
//     }

//     else if (direction.equals("Down")){
//         for(int i = 0 ; i < myMap.solidWallCoords.size(); i = i+2){
//             if (myMap.solidWallCoords.get(i) == this.x_coord && myMap.solidWallCoords.get(i+1) -32 == this.y_coord){
//                 return true;
//             }
//         }

//     }
    
//     }
}


