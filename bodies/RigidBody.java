package bodies;

import core.MyVector;

/**
 * Created by Jordan on 2016-12-15.
 */
public class RigidBody {

    public MyVector dimensions;

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

        dimensions = new MyVector(48, 96);

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
