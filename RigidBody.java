/**
 * Created by Jordan on 2016-12-15.
 */
public class RigidBody {

    public MyVector location;
    public MyVector velocity;
    public MyVector acceleration;
    public MyVector netForce;

    public float invMass;

    /**
     * An object that requires physics computations
     * */
    public RigidBody(float mass) {
        this.invMass = 1 / mass;
        location = new MyVector();
        velocity = new MyVector();
        acceleration = new MyVector();
        netForce = new MyVector();
    }

}
