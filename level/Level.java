package level;

import core.MyVector;

import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-16.
 */
public class Level {

    private Tile[][] tiles;
    private ArrayList<MyVector> globalForces;

    public Level() {

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
