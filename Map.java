package demolition;

import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.core.PApplet;
import processing.core.PImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;



public class Map{

    PImage solidWall;
    PImage brokenWall;
    PImage emptyWall;
    PImage goalWall;
    PImage iconPlayer;
    PImage iconTime;
    PApplet appObject;

    int timer;

    int bombGuyPositionX;
    int bombGuyPositionY;
    int redEnemyPositionX;
    int redEnemyPositionY;
    int yellowEnemyPositionX;
    int yellowEnemyPositionY;
    int currentLevel;
    ArrayList<String> mapLevels = new ArrayList<>();
    ArrayList<Integer> mapLevelTime = new ArrayList<>();
    ArrayList<Integer> solidWallCoords = new ArrayList<>();
    ArrayList<Integer> brokenWallCoords = new ArrayList<>(); 
    public Map(PApplet appObject){
        this.appObject = appObject;
        this.solidWall = appObject.loadImage("..\\..\\resources\\main\\wall\\solid.png");
        this.brokenWall =appObject.loadImage("..\\..\\resources\\main\\broken\\broken.png");
        this.emptyWall = appObject.loadImage("..\\..\\resources\\main\\empty\\empty.png");
        this.goalWall= appObject.loadImage("..\\..\\resources\\main\\goal\\goal.png");
        this.iconPlayer= appObject.loadImage("..\\..\\resources\\main\\icons\\player.png");
        this.iconTime= appObject.loadImage("..\\..\\resources\\main\\icons\\clock.png");
        this.currentLevel = 0;
        readConfigFile();
        playerCoordinate(mapLevels.get(currentLevel));
        timer = mapLevelTime.get(currentLevel);
    }

    
    public void loadMapDrawing(String level,PImage solidWall,PImage brokenWall,PImage emptyWall,PImage goalWall){
     File f= new File(level);     //Creation of File Descriptor for input file
        try{
        FileReader fr=new FileReader(f);   //Creation of File Reader object
            BufferedReader brFile = new BufferedReader(fr);  //Creation of BufferedReader object
            int c = 0; 
            int x = 0;
            int y = 64;            
            while((c = brFile.read()) != -1){         //Read char by Char
                    char character = (char) c;          //converting integer to char
                    if (character == 'W'){
                        appObject.image(solidWall, x, y); 
                        solidWallCoords.add(x);         // new line inserted
                        solidWallCoords.add(y); 
                    }
                    else if (character == 'B'){
                        appObject.image(brokenWall, x,y);
                        brokenWallCoords.add(x);         // new line inserted
                        brokenWallCoords.add(y);   
                    }
                    else if (character == ' '|| character == 'P' || character == 'R' || character == 'Y'){
                        appObject.image(emptyWall, x,y);   
                    }
                    else if (character == 'G'){
                        appObject.image(goalWall, x,y);           
                    }
                    x += 32;
                    if (x == 480){
                        y += 32;
                        x = -64;
                    }
            }
            

        }catch (Exception e){
           e.printStackTrace();
        }
    }


    public void playerCoordinate(String level){
        
        File f= new File(level);     //Creation of File Descriptor for input file
        try{
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        
            BufferedReader brFile = new BufferedReader(fr);  //Creation of BufferedReader object
            int c = 0; 
            int x = 0;
            int y = 64;
            while((c = brFile.read()) != -1){         //Read char by Char
            
                    char character = (char) c;          //converting integer to char
                    if (character == 'P'){
                        this.bombGuyPositionX = x;
                        this.bombGuyPositionY  = y; 
                    }
                    if (character == 'R'){
                        redEnemyPositionX = x;
                        redEnemyPositionY  = y; 
                    }
                    if (character == 'Y'){
                        yellowEnemyPositionX = x;
                        yellowEnemyPositionY = y; 
                    }
                    x += 32;
                    if (x == 480){
                        y += 32;
                        x = -64;
                    }
            }
    
        }catch (Exception e){
            
        }
    }

   
    public ArrayList<String> readConfigFile() {
        ArrayList<String> configDetails = new ArrayList<String>();   // call from App.java: taking the details
        JSONObject mapDetails = null;
        String lives;

        File jsonFile = new File("config.json");
        try {
            Scanner scan = new Scanner(jsonFile);
            StringBuffer sb = new StringBuffer();
            while (scan.hasNext()) {
                sb.append("" + scan.nextLine());
            }
            scan.close();
            mapDetails = JSONObject.parse(sb.toString());
            lives = mapDetails.get("lives").toString();
            configDetails.add(lives);
            JSONArray levelDetails = mapDetails.getJSONArray("levels");
            for(int i = 0; i < levelDetails.size(); i ++) {
                String path = levelDetails.getJSONObject(i).getString("path");
                mapLevels.add(path);
                int time = levelDetails.getJSONObject(i).getInt("time");
                mapLevelTime.add(time);
                configDetails.add(path);
                configDetails.add(Integer.toString(time));
            }
        }catch (Exception e){

        }
       return configDetails;    
    }


    public boolean isFirstLastValid(String line) {
        String FIRSTLASTLINE = "WWWWWWWWWWWWWWW";
        if (line.equals(FIRSTLASTLINE)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMidValid(String line) {
        if (line.startsWith("W") && line.endsWith("W") && line.length() == 15){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean isMapValid(){
        boolean isFirstLineValid = false;
        boolean isMidLineValid = true;
        boolean isFirstLineFound = false;
        boolean isLastLineValid = false;
        boolean isPlayerFound=false;
        boolean isGoalFound=false;
        String line;
        int Wcount = 0;
        File myFile = new File(mapLevels.get(this.getCurrentLevel()));
        try {
            Scanner levelFile = new Scanner(myFile);

            while (levelFile.hasNextLine()) {
                line = levelFile.nextLine();

                //first line validity starts ---------

                if (line.startsWith("W") && !isFirstLineFound) {
                    isFirstLineFound = true;
                    Wcount++;

                    isFirstLineValid = isFirstLastValid(line);
                    if (!isFirstLineValid){
                        return false;
                    }
                }
                //first line validity ends here --------

                // Mid and End line validity starts ------------
                else if(Wcount == 1){

                    if (!isPlayerFound){
                        isPlayerFound = line.contains("P");
                    }
                    if (!isGoalFound){
                        isGoalFound = line.contains("G");
                    }

                    isMidLineValid = isMidValid(line);

                    if(!isMidLineValid){
                        return false;
                    }
                    isLastLineValid = isFirstLastValid(line);

                    if(isLastLineValid){
                        Wcount++;
                    }
                }
                //Mid and End line validity ends -----------
            
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isPlayerFound && isGoalFound){
            return true;
        }else return false;
    }

    public boolean isTimeFinished ()
    {
        return this.timer == 0;
    }


    public void setCurrentLevel(int level){
        this.currentLevel = level;
    }
    public int getCurrentLevel(){
        return this.currentLevel;
    }

    public int getBombGuyPositionX(){
        return bombGuyPositionX;
    }
    public int getBombGuyPositionY(){
        return bombGuyPositionY;
    }

    public int getRedEnemyPositionX(){
        return redEnemyPositionX;
    }
    public int getRedEnemyPositionY(){
        return redEnemyPositionY;
    }

    public int getYellowEnemyPositionX(){
        return yellowEnemyPositionX;
    }
    public int getYellowEnemyPositionY(){
        return yellowEnemyPositionY;
    }

    public PImage getSolidWall(){
        return solidWall;
    }
    public PImage getBrokenWall(){
        return brokenWall;
    }
    public PImage getEmptyWall(){
        return emptyWall;
    }
    public PImage getGoalWall(){
        return goalWall;
    }
    public PImage getIconPlayer(){
        return iconPlayer;
    }
    public PImage getIconTime(){
        return iconTime;
    }


    // public static void main(String[] args) {
    //     Map m = new Map();
        // System.out.println(m.loadMap());
    // }

}
    
