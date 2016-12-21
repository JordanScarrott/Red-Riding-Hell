package collision;

import bodies.RigidBody;
import level.Tile;

/**
 * Created by Jordan on 2016-12-20.
 */
public class CollisionPair {

    public RigidBody rigidBody;
    public Tile tile;

    /**
     *
     * @param rigidBody
     * @param tile
     */
    public CollisionPair(RigidBody rigidBody, Tile tile) {
        this.rigidBody = rigidBody;
        this.tile = tile;
    }


}
