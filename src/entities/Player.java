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
        setDirection("down");
    }

    public void setDefaultValues(){
        setX(100);
        setY(100);
        setSpeed(4);
    }

    public void getPlayerImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/player/up1.png")));
            //setUp2(ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/player/down1.png")));
            //setDown2(ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/left1.png")));
            //setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/player/right1.png")));
            //setRight2(ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if(keyH.isUpPressed()){
            setDirection("up");
            setY(getY()-getSpeed());
        } else if(keyH.isDownPressed()){
            setDirection("down");
            setY(getY()+getSpeed());
        } else if(keyH.isLeftPressed()){
            setDirection("left");
            setX(getX()-getSpeed());
        } else if(keyH.isRightPressed()){
            setDirection("right");
            setX(getX()+getSpeed());
        }
    }

    public void draw(Graphics g2d){
        BufferedImage image = switch (getDirection()) {
            case "up" -> getUp1();
            case "down" -> getDown1();
            case "left" -> getLeft1();
            case "right" -> getRight1();
            default -> null;
        };

        g2d.drawImage(image, getX(), getY(), gp.getTileSize(), gp.getTileSize(), null);
    }
}
