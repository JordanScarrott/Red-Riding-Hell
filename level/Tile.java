package level;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile extends JPanel {
    private BufferedImage img;
    private int x;  //Grid X
    private int y;
    private int pX; //Pallette X
    private int pY;
    private int tempX;  //X thats drawn in current view
    private int tempY;
    private int spriteSheet;

    public Tile(BufferedImage img, int x, int y, int pX, int pY, int spriteSheet, int xShift, int yShift) {
        this.img = img;
        this.x = x + xShift * 48;
        this.y = y + yShift * 48;
        this.pX = pX;
        this.pY = pY;
        this.tempX = x;
        this.tempY = y;
        this.spriteSheet = spriteSheet;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, tempX, tempY, null);
    }


    public String toString() {
        return "TempX: " + tempX + "\tTempY: " + tempY;
    }


    /**
     * Getters and Setters
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.tempX = x;
    }

    public int getTempX() {
        return tempX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.tempY = y;
    }

    public int getTempY() {
        return tempY;
    }

    public int getPX() {
        return pX;
    }

    public int getPY() {
        return pY;
    }

    public int getSpriteSheet() {
        return spriteSheet;
    }

}
