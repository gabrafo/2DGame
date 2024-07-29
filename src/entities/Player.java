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
            setUp1(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_2.png")));
            setUp3(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_3.png")));
            setUp4(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_4.png")));
            setUp5(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_5.png")));
            setUp6(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_6.png")));
            setUp7(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_7.png")));
            setUp8(ImageIO.read(getClass().getResourceAsStream("/player/bundle/up_8.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_2.png")));
            setDown3(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_3.png")));
            setDown4(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_4.png")));
            setDown5(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_5.png")));
            setDown6(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_6.png")));
            setDown7(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_7.png")));
            setDown8(ImageIO.read(getClass().getResourceAsStream("/player/bundle/down_8.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_2.png")));
            setLeft3(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_3.png")));
            setLeft4(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_4.png")));
            setLeft5(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_5.png")));
            setLeft6(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_6.png")));
            setLeft7(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_7.png")));
            setLeft8(ImageIO.read(getClass().getResourceAsStream("/player/bundle/left_8.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_2.png")));
            setRight3(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_3.png")));
            setRight4(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_4.png")));
            setRight5(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_5.png")));
            setRight6(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_6.png")));
            setRight7(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_7.png")));
            setRight8(ImageIO.read(getClass().getResourceAsStream("/player/bundle/right_8.png")));
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
                if(getSpriteNum()==8){
                    setSpriteNum(1);
                }
                else {
                    setSpriteNum(getSpriteNum() + 1);
                }
                setSpriteCounter(0);
            }
        }
    }

    public void draw(Graphics g2d){
        BufferedImage image = null;
        image = switch (getDirection()) {
            case "up" -> switch (getSpriteNum()) {
                case 1 -> getUp1();
                case 2 -> getUp2();
                case 3 -> getUp3();
                case 4 -> getUp4();
                case 5 -> getUp5();
                case 6 -> getUp6();
                case 7 -> getUp7();
                case 8 -> getUp8();
                default -> image;
            };
            case "down" -> switch (getSpriteNum()) {
                case 1 -> getDown1();
                case 2 -> getDown2();
                case 3 -> getDown3();
                case 4 -> getDown4();
                case 5 -> getDown5();
                case 6 -> getDown6();
                case 7 -> getDown7();
                case 8 -> getDown8();
                default -> image;
            };
            case "left" -> switch (getSpriteNum()) {
                case 1 -> getLeft1();
                case 2 -> getLeft2();
                case 3 -> getLeft3();
                case 4 -> getLeft4();
                case 5 -> getLeft5();
                case 6 -> getLeft6();
                case 7 -> getLeft7();
                case 8 -> getLeft8();
                default -> image;
            };
            case "right" -> switch (getSpriteNum()) {
                case 1 -> getRight1();
                case 2 -> getRight2();
                case 3 -> getRight3();
                case 4 -> getRight4();
                case 5 -> getRight5();
                case 6 -> getRight6();
                case 7 -> getRight7();
                case 8 -> getRight8();
                default -> image;
            };
            default -> null;
        };

        g2d.drawImage(image, getX(), getY(), gp.getTileSize(), gp.getTileSize(), null);
    }
}
