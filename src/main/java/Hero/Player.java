package Hero;
import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Hero{ // create a new hero
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        // para perceber que o erro está no getPlayerImage()
        try {
            getPlayerImage();
        }catch (Exception e){
            System.out.println("getPlayerImage() is not working");
        }

    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }
    public void getPlayerImage(){

        try {
            up1 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-7.png"));
            up2 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-8.png"));
            left1 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-5.png"));
            left2 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-6.png"));
            right1 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-3.png"));
            right2 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-4.png"));
            down1 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-1.png"));
            down2 = ImageIO.read(new File("C:\\Users\\manue\\IdeaProjects\\Umbrella_game\\src\\main\\res\\player\\LOLITA-2.png"));
            //tive de utilizar files, por ser mais fácil que  ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_up_1.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed){
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed){
            direction = "down";
            y += speed;
        }
        else if(keyH.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if(keyH.rightPressed){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){

       BufferedImage image = null;

       switch(direction){
           case "up":
               image = up1;
               break;
           case "down":
               image = down1;
               break;
           case "left":
               image = left1;
               break;
           case "right":
               image = right1;
               break;
       }
       g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
