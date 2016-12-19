package bodies;

import common.MyVector;

import java.awt.image.BufferedImage;

/**
 * Created by Jordan on 2016-12-15.
 */
public class RigidBody {

    /**
     * Image that will be rendered representing this RigidBody instance
     * Dimensions could be derived from this -> (convert to grid units!)
     * - Divide by gridSize / scale
     */
    public BufferedImage img;

    /**
     * Width, height of the rectangular RigidBody
     */
    public MyVector dimensions;

    /**
     * Half of the dimension (From center point to outer point)
     */
    public MyVector halfDim;

    public MyVector location;
    public MyVector velocity;
    public MyVector acceleration;
    public MyVector netForce;

    public float invMass;

    /**
     * An object that requires physics computations
     */
    public RigidBody(float mass) {
        this.invMass = 1 / mass;

        dimensions = new MyVector(2.312f, 2.10101f);
        halfDim = new MyVector(dimensions.x / 2, dimensions.y / 2);

        location = new MyVector();
        velocity = new MyVector();
        acceleration = new MyVector();
        netForce = new MyVector();
    }

    /**
     * If the RigidBody represented by this instance needs any special processes
     * to be run this method should be overridden in its subclass
     */
    public void update() {

    }

}
