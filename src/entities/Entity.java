package entities;

import java.awt.image.BufferedImage;

public class Entity {

    private int x, y;
    private int speed;

    private BufferedImage up1, up2, up3, up4, up5, up6, up7, up8,
            down1, down2,down3, down4, down5, down6, down7, down8,
            left1, left2, left3, left4, left5, left6, left7, left8,
            right1, right2, right3, right4, right5, right6, right7, right8;
    private String direction;
    private int spriteCounter = 0;
    private int spriteNum = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public BufferedImage getUp1() {
        return up1;
    }

    public void setUp1(BufferedImage up1) {
        this.up1 = up1;
    }

    public BufferedImage getUp2() {
        return up2;
    }

    public void setUp2(BufferedImage up2) {
        this.up2 = up2;
    }

    public BufferedImage getUp3() {
        return up3;
    }

    public void setUp3(BufferedImage up3) {
        this.up3 = up3;
    }

    public BufferedImage getUp4() {
        return up4;
    }

    public void setUp4(BufferedImage up4) {
        this.up4 = up4;
    }

    public BufferedImage getUp5() {
        return up5;
    }

    public void setUp5(BufferedImage up5) {
        this.up5 = up5;
    }

    public BufferedImage getUp6() {
        return up6;
    }

    public void setUp6(BufferedImage up6) {
        this.up6 = up6;
    }

    public BufferedImage getUp7() {
        return up7;
    }

    public void setUp7(BufferedImage up7) {
        this.up7 = up7;
    }

    public BufferedImage getUp8() {
        return up8;
    }

    public void setUp8(BufferedImage up8) {
        this.up8 = up8;
    }

    public BufferedImage getDown1() {
        return down1;
    }

    public void setDown1(BufferedImage down1) {
        this.down1 = down1;
    }

    public BufferedImage getDown2() {
        return down2;
    }

    public void setDown2(BufferedImage down2) {
        this.down2 = down2;
    }

    public BufferedImage getDown3() {
        return down3;
    }

    public void setDown3(BufferedImage down3) {
        this.down3 = down3;
    }

    public BufferedImage getDown4() {
        return down4;
    }

    public void setDown4(BufferedImage down4) {
        this.down4 = down4;
    }

    public BufferedImage getDown5() {
        return down5;
    }

    public void setDown5(BufferedImage down5) {
        this.down5 = down5;
    }

    public BufferedImage getDown6() {
        return down6;
    }

    public void setDown6(BufferedImage down6) {
        this.down6 = down6;
    }

    public BufferedImage getDown7() {
        return down7;
    }

    public void setDown7(BufferedImage down7) {
        this.down7 = down7;
    }

    public BufferedImage getDown8() {
        return down8;
    }

    public void setDown8(BufferedImage down8) {
        this.down8 = down8;
    }

    public BufferedImage getLeft1() {
        return left1;
    }

    public void setLeft1(BufferedImage left1) {
        this.left1 = left1;
    }

    public BufferedImage getLeft2() {
        return left2;
    }

    public void setLeft2(BufferedImage left2) {
        this.left2 = left2;
    }

    public BufferedImage getLeft3() {
        return left3;
    }

    public void setLeft3(BufferedImage left3) {
        this.left3 = left3;
    }

    public BufferedImage getLeft4() {
        return left4;
    }

    public void setLeft4(BufferedImage left4) {
        this.left4 = left4;
    }

    public BufferedImage getLeft5() {
        return left5;
    }

    public void setLeft5(BufferedImage left5) {
        this.left5 = left5;
    }

    public BufferedImage getLeft6() {
        return left6;
    }

    public void setLeft6(BufferedImage left6) {
        this.left6 = left6;
    }

    public BufferedImage getLeft7() {
        return left7;
    }

    public void setLeft7(BufferedImage left7) {
        this.left7 = left7;
    }

    public BufferedImage getLeft8() {
        return left8;
    }

    public void setLeft8(BufferedImage left8) {
        this.left8 = left8;
    }

    public BufferedImage getRight1() { getRight8();
        return right1;
    }

    public void setRight1(BufferedImage right1) {
        this.right1 = right1;
    }

    public BufferedImage getRight2() {
        return right2;
    }

    public void setRight2(BufferedImage right2) {
        this.right2 = right2;
    }

    public BufferedImage getRight3() {
        return right3;
    }

    public void setRight3(BufferedImage right3) {
        this.right3 = right3;
    }

    public BufferedImage getRight4() {
        return right4;
    }

    public void setRight4(BufferedImage right4) {
        this.right4 = right4;
    }

    public BufferedImage getRight5() {
        return right5;
    }

    public void setRight5(BufferedImage right5) {
        this.right5 = right5;
    }

    public BufferedImage getRight6() {
        return right6;
    }

    public void setRight6(BufferedImage right6) {
        this.right6 = right6;
    }

    public BufferedImage getRight7() {
        return right7;
    }

    public void setRight7(BufferedImage right7) {
        this.right7 = right7;
    }

    public BufferedImage getRight8() {
        return right8;
    }

    public void setRight8(BufferedImage right8) {
        this.right8 = right8;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
