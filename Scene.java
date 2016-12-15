import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-15.
 */
public class Scene {

    private ArrayList<RigidBody> rigidBodies;

    private ArrayList<MyVector> globalForces;

    /**
     *
     * */
    public Scene() {
        rigidBodies = new ArrayList<>();
        globalForces = new ArrayList<>();
    }

    /**
     * Updates all of the rigid bodies currently in the simulation
     * */
    public void update(float dt) {
        // Apply forces
        for (RigidBody rb : rigidBodies) {
            integrateForces(rb, dt);
            integrateVelocity(rb, dt);
        }

        // Clear forces
        for (RigidBody rb : rigidBodies) {
            rb.netForce.set(0, 0);
        }
    }

    /**
     * Integrates the velocity of a RigidBody
     *
     * */
    public void integrateVelocity(RigidBody rb, float dt) {
        // x += v * dt
        rb.location.add(rb.velocity.mult(dt));
    }

    /**
     * Integrates the Forces acting on a RigidBody
     * @param rb the RigidBody who's forces will be integrated
     * @param dt the time interval to integrate by
     * */
    public void integrateForces(RigidBody rb, float dt) {
//        if (rb.isSTATIC()) return;

        // v += 1 / mass * forces * dt
        rb.velocity.add(rb.netForce.mult(rb.invMass * dt));
    }
}
