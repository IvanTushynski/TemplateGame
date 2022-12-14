package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    File p1 = new File("src/res/player/d1.png");
    File p2 = new File("src/res/player/d2.png");
    File p3 = new File("src/res/player/d3.png");
    File p4 = new File("src/res/player/l1.png");
    File p5 = new File("src/res/player/l2.png");
    File p6 = new File("src/res/player/l3.png");
    File p7 = new File("src/res/player/r1.png");
    File p8 = new File("src/res/player/r2.png");
    File p9 = new File("src/res/player/r3.png");
    File p10 = new File("src/res/player/u1.png");
    File p11 = new File("src/res/player/u2.png");
    File p12 = new File("src/res/player/u3.png");

    public Player(GamePanel gp, KeyHandler keyH) throws IOException {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() throws IOException {
        up1 = ImageIO.read(p10);
        up2 = ImageIO.read(p11);
        up3 = ImageIO.read(p12);
        down1 = ImageIO.read(p1);
        down2 = ImageIO.read(p2);
        down3 = ImageIO.read(p3);
        left1 = ImageIO.read(p4);
        left2 = ImageIO.read(p5);
        left3 = ImageIO.read(p6);
        right1 = ImageIO.read(p7);
        right2 = ImageIO.read(p8);
        right3 = ImageIO.read(p9);
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if (spriteNum == 1) {
                image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up1;
                }
                if (spriteNum == 4) {
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1){
                image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                if (spriteNum == 3){
                    image = down1;
                }
                if (spriteNum == 4){
                    image = down3;
                }
                break;
            case "left":
                if (spriteNum == 1){
                image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                if (spriteNum == 3){
                    image = left1;
                }
                if (spriteNum == 4){
                    image = left3;
                }
                break;
            case "right":
                if (spriteNum == 1){
                image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right1;
                }
                if (spriteNum == 4){
                    image = right3;
                }
                break;
        }
        g2.drawImage(image,x,y,gp.tileSize, gp.tileSize, null);
    }

}
