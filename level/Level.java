package level;

import common.MyVector;

import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-16.
 */
public class Level {

    private Tile[][] tiles;
    private ArrayList<MyVector> globalForces;

    public Level() {
        tiles = new Tile[10][10];
        tiles[5][5] = new Tile(null, "Tile at tiles[5][5]");
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
