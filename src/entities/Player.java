package entities;

import game.GamePanel;
import game.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    private GamePanel gp;
    private KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        setX(100);
        setY(100);
        setSpeed(4);
        setDirection("down");
    }

    public void getPlayerImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        boolean keyPressed = false;
        if(keyH.isUpPressed()){
            setDirection("up");
            setY(getY()-getSpeed());
            keyPressed = true;
        } else if(keyH.isDownPressed()){
            setDirection("down");
            setY(getY()+getSpeed());
            keyPressed = true;
        } else if(keyH.isLeftPressed()){
            setDirection("left");
            setX(getX()-getSpeed());
            keyPressed = true;
        } else if(keyH.isRightPressed()){
            setDirection("right");
            setX(getX()+getSpeed());
            keyPressed = true;
        }

        if(keyPressed){
            setSpriteCounter(getSpriteCounter()+1);
            if(getSpriteCounter()>12){
                if(getSpriteNum()==1){
                    setSpriteNum(2);
                }
                else if(getSpriteNum()==2){
                    setSpriteNum(1);
                }
                setSpriteCounter(0);
            }
        }
    }

    public void draw(Graphics g2d){
        BufferedImage image = null;
        switch (getDirection()) {
            case "up":
                if(getSpriteNum() == 1){
                    image = getUp1();
                }
                if(getSpriteNum() == 2){
                    image = getUp2();
                }
                break;
            case "down":
                if(getSpriteNum() == 1){
                    image = getDown1();
                }
                if(getSpriteNum() == 2){
                    image = getDown2();
                }
                break;
            case "left":
                if(getSpriteNum() == 1){
                    image = getLeft1();
                }
                if(getSpriteNum() == 2){
                    image = getLeft2();
                }
                break;
            case "right":
                if(getSpriteNum() == 1){
                    image = getRight1();
                }
                if(getSpriteNum() == 2){
                    image = getRight2();
                }
                break;
        };

        g2d.drawImage(image, getX(), getY(), gp.getTileSize(), gp.getTileSize(), null);
    }
}
