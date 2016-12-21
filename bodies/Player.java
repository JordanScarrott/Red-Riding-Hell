package bodies;

/**
 * Created by Jordan on 2016-12-20.
 */
public class Player extends RigidBody {

    /**
     * A player object that requires physics computations
     *
     * @param x x component of location
     * @param y y component of location
     * @param width width of the player
     * @param height height of the player
     * @param mass mass of the player
     */
    public Player(float x, float y, float width, float height, float mass) {
        super(x, y, width, height, mass);

    }


}
