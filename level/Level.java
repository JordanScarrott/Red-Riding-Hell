package level;

import common.MyVector;
import common.ResourceLoader;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-16.
 */
public class Level {

    private Tile[][] tiles;
    private ArrayList<MyVector> globalForces;

    public Level(File file) {
        tiles = ResourceLoader.readFile(ResourceLoader.loadImage("spriteSheets\\spritesheet0.png"), 32, file.getName());
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 15; j++) {
                if (tiles[j][i] != null) {
                    System.out.println(tiles[j][i].toString());
                }
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Gravity
        globalForces = new ArrayList<>();
        globalForces.add(new MyVector(0, 10));
    }

    /**
     * Getters and Setters
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public ArrayList<MyVector> getGlobalForces() {
        return globalForces;
    }

    public void setGlobalForces(ArrayList<MyVector> globalForces) {
        this.globalForces = globalForces;
    }
}
