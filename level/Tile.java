package level;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Tile extends JPanel {
    private BufferedImage img;
    private String ID;

    public Tile(BufferedImage img, String ID) {
        this.img = img;
        this.ID = ID;
    }


    /**
     * Getters and Setters
     */
    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
