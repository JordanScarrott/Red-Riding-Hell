import bodies.RigidBody;
import core.MyVector;
import level.Level;

import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-15.
 */
public class Scene {

    private Level level;

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
     */
    public void update(float dt) {
        // Apply global forces
        for (RigidBody rb : rigidBodies) {
            for (MyVector mv : globalForces) {
                rb.netForce.add(mv);
            }
        }

        // Integrate
        for (RigidBody rb : rigidBodies) {
            integrateForces(rb, dt);
            integrateVelocity(rb, dt);
        }

        // Collision Detection (With Tiles)
        for (RigidBody rb : rigidBodies) {
            collisionDetection(rb);
        }

        // Collision Resolution (With Tiles)

        // Clear forces
        for (RigidBody rb : rigidBodies) {
            rb.netForce.set(0, 0);
        }
    }

    /**
     * Detects collisions between Tiles and a RigidBody
     */
    public void collisionDetection(RigidBody rigidBody) {
        int x = (int)rigidBody.location.x;
        int y = (int)rigidBody.location.y;

        if (level.getTiles()[x + 1][y] != null) {

        }
    }

    /**
     * Integrates the velocity of a RigidBody
     */
    public void integrateVelocity(RigidBody rb, float dt) {
        // x += v * dt
        rb.location.add(rb.velocity.mult(dt));
    }

    /**
     * Integrates the Forces acting on a RigidBody
     *
     * @param rb the RigidBody who's forces will be integrated
     * @param dt the time interval to integrate by
     */
    public void integrateForces(RigidBody rb, float dt) {
        // v += 1 / mass * forces * dt
        rb.velocity.add(rb.netForce.mult(rb.invMass * dt));
    }


    /**
     * Getters and Setters
     */
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public ArrayList<RigidBody> getRigidBodies() {
        return rigidBodies;
    }

    public void setRigidBodies(ArrayList<RigidBody> rigidBodies) {
        this.rigidBodies = rigidBodies;
    }

    public ArrayList<MyVector> getGlobalForces() {
        return globalForces;
    }

    public void setGlobalForces(ArrayList<MyVector> globalForces) {
        this.globalForces = globalForces;
    }
}
