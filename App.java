package demolition;

import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;
import java.util.ArrayList;


public class App extends PApplet {
    ArrayList<Bomb> bombList;
    ArrayList<RedEnemy> redEnemyList;
    ArrayList<YellowEnemy> yellowEnemyList;
    Map myMap;
    BombGuy bombGuy;
    RedEnemy redEnemy;
    YellowEnemy yellowEnemy;
    //    int bombGuyX;
    Bomb newBomb;
//    int bombGuyY;
    boolean is_keyReleased = false;
    public static int count = 0;
    public static int enemyFrame = 0;
    PFont font;
    
    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;
    public static final int FPS = 60;

    public static int time;

    public App() {
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }
    // Load images during setup

    public void setup() {
        frameRate(FPS);
        myMap=new Map(this);
        time= myMap.timer;
        bombList = new ArrayList<>();
        redEnemyList = new ArrayList<>();
        yellowEnemyList = new ArrayList<>();
        bombList.add(new Bomb(myMap, this));
        redEnemyList.add(new RedEnemy(myMap, this, myMap.getRedEnemyPositionX(), myMap.getRedEnemyPositionY()));
        yellowEnemyList.add(new YellowEnemy(myMap, this, myMap.getYellowEnemyPositionX(), myMap.getYellowEnemyPositionY()));
        
        bombGuy = new BombGuy(myMap, this, myMap.getBombGuyPositionX(), myMap.getBombGuyPositionY());
        // redEnemy = new RedEnemy(myMap, this, myMap.getRedEnemyPositionX(), myMap.getRedEnemyPositionY());
        // yellowEnemy = new YellowEnemy(myMap, this, myMap.getYellowEnemyPositionX(), myMap.getYellowEnemyPositionY());
        font = createFont("PressStart2P-Regular.ttf",10);
    }

    public void draw() {
        background(239, 129, 0);

        if (!myMap.isTimeFinished()) {
        if (myMap.isMapValid()) {
            image(myMap.getIconPlayer(), 128, 16);
            image(myMap.getIconTime(), 256, 16);

            fill(0);
            textFont(font,20);
            text(bombGuy.life,192,42);
            text(myMap.timer,312,42);
        

            myMap.loadMapDrawing(myMap.mapLevels.get(myMap.getCurrentLevel()), myMap.getSolidWall(), myMap.getBrokenWall(), myMap.getEmptyWall(), myMap.getGoalWall());
        }

        if (enemyFrame == 60) {
            enemyFrame = 0;
            myMap.timer--;
        }
        enemyFrame++;

        //red and yellow step function

        if (enemyFrame == 60) { // for each loop -> red enemy step + render same with yellow enemy
            for(RedEnemy r : redEnemyList){
                r.step();
            }

            for(YellowEnemy y : yellowEnemyList){
                y.step();
            }
        }

        for(RedEnemy r: redEnemyList){
            if (r.getX_coord()!= 0)
                r.render();
        }

        for(YellowEnemy y: yellowEnemyList){
            if (y.getX_coord()!= 0)
                y.render();
        }

        for (Bomb b : bombList) {
            if(b.getBombX() != 0)
                b.renderPlaceBomb();
        }



    //    if (redEnemy.getX_coord() != 0) {
    //             redEnemy.render();
    //         }
    //         if (yellowEnemy.getX_coord() != 0) {
    //             yellowEnemy.render();
    //         }
        if (bombGuy.getX_coord() != 0) {
                    bombGuy.render();
        }
        count++;

       
        
    }else if (myMap.isTimeFinished()){
            fill(0);
            textFont(font, 15);
            text("Game Over", 175,240);
        }

    }


    // space = 32
    // arrow left 37
    // arrow up	38
    // arrow right	39
    // arrow down	40

    public void keyPressed(KeyEvent event) {

        if (is_keyReleased && event.getKeyCode() == 37) { //arrow left 37
            bombGuy.setDirection("Left");
            // bombGuyDir = "Left";
            if (!bombGuy.collidesWithWall(bombGuy.getDirection())) {
                bombGuy.sub_x_direction();
                is_keyReleased = false;

            }
            return;
        } else if (is_keyReleased && event.getKeyCode() == 38) {   // arrow up	38
            bombGuy.setDirection("Up");
            // bombGuyDir = "Up";
            if (!bombGuy.collidesWithWall(bombGuy.getDirection())) {
                bombGuy.sub_y_direction();
                is_keyReleased = false;
            }
            return;
        } else if (is_keyReleased && event.getKeyCode() == 39) { // arrow right	39
            bombGuy.setDirection("Right");
            // bombGuyDir = "Right";
            if (!bombGuy.collidesWithWall(bombGuy.getDirection())) {
                bombGuy.add_x_direction();
                is_keyReleased = false;
            }
            return;
        } else if (is_keyReleased && event.getKeyCode() == 40) { // arrow down	40
            bombGuy.setDirection("Down");
            // bombGuyDir = "Down";
            if (!bombGuy.collidesWithWall(bombGuy.getDirection())) {
                bombGuy.add_y_direction();
                is_keyReleased = false;
            }
            return;
        } else if (event.getKeyCode() == 32) {
            is_keyReleased = false;
            bombList.add(new Bomb(myMap, this));
            int i = bombList.size()-1;
            bombList.get(i).setBombX(bombGuy.getX_coord());
            bombList.get(i).setBombY(bombGuy.getY_coord());
            
           
            return;
        } else
            return;

    }

    public void keyReleased(KeyEvent event) {
        is_keyReleased = true;
    }


    public static void main(String[] args) {
        PApplet.main("demolition.App");
    }
}