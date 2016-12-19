import bodies.RigidBody;
import common.MyVector;
import common.MathUtils;
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
        // Gravity
        globalForces.add(new MyVector(0, 1));
    }

    /**
     * Add a RigidBody to the physics simulation
     */
    public void add(RigidBody rigidBody) {
        rigidBodies.add(rigidBody);
    }

    /**
     * Remove a Rigid body from the physics simulation
     */
    public void remove(int i) {
        rigidBodies.remove(i);
    }

    /**
     * Remove a Rigid body from the physics simulation
     */
    public void remove(RigidBody rigidBody) {
        rigidBodies.remove(rigidBody);
    }

    /**
     * Updates all of the RigidBodies currently in the simulation
     */
    public void step(float dt) {
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
            System.out.println(collisionDetection(rb));
        }

        // Collision Resolution (With Tiles)

        // Clear forces
        for (RigidBody rb : rigidBodies) {
            rb.netForce.set(0, 0);
        }
    }

    /**
     * Version 2 of the RigidBody - Tile Collision Detection Algorithm
     * Detects RigidBody - Tile collisions for variable sized quads
     *
     * NB: Top and Bottom Right coordinates might be checked twice
     * under certain conditions
     *
     * @param rb the RigidBody to perform collision detection upon
     * @return a MyVector representing the location of the Tile in
     * the grid that the RigidBody is colliding with. If there is no
     * collision returns null
     */
    public MyVector collisionDetection(RigidBody rb) {
        // Top Left Coordinate
        MyVector topLeft = MyVector.sub(rb.location, rb.halfDim);

        for (float i = topLeft.x; i < topLeft.x + rb.dimensions.x; i++) {
            for (float j = topLeft.y; j < topLeft.x + rb.dimensions.y; j++) {
                if (tileCollision(i, j)) return rb.location;
            }
        }

        // Corners
        /*if (tileCollision(topLeft.x, topLeft.y)) return topLeft;
        if (tileCollision(topLeft.x + rb.dimensions.x - 1, topLeft.y)) return topLeft.add(rb.dimensions.x - 1, 0);
        if (tileCollision(topLeft.x, topLeft.y + rb.dimensions.y - 1)) return topLeft.add(0, rb.dimensions.y - 1);
        if (tileCollision(topLeft.x + rb.dimensions.x - 1, topLeft.y + rb.dimensions.y - 1)) return topLeft.add(rb.dimensions.x - 1, rb.dimensions.y - 1);

        // Left and Right sides
        for (float i = topLeft.x + 1; i < rb.dimensions.x; i++) {
            if (tileCollision(i, topLeft.y)) return topLeft.set(i, topLeft.y);
            if (tileCollision(i, topLeft.y + rb.dimensions.y)) return topLeft.set(i, topLeft.y + rb.dimensions.y);
        }
        // Top and Bottom sides
        for (float i = topLeft.y + 1; i < rb.dimensions.y; i++) {
            if (tileCollision(topLeft.x, i)) return topLeft.set(topLeft.x, i);
            if (tileCollision(topLeft.x + rb.dimensions.x, i)) return topLeft.set(topLeft.x + rb.dimensions.x, i);
        }*/

        return null;
    }

    /**
     * @param x x position in the Tiles[][] grid
     * @param y y position in the Tiles[][] grid
     * @return true if player collides with a tile at this position
     */
    public boolean tileCollision(int x, int y) {
        return level.getTiles()[x][y] != null;
    }

    public boolean tileCollision(float x, float y) {
        return level.getTiles()[MathUtils.round(x)][MathUtils.round(y)] != null;
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

    public ArrayList<MyVector> getGlobalForces() {
        return globalForces;
    }

    public void setGlobalForces(ArrayList<MyVector> globalForces) {
        this.globalForces = globalForces;
    }

    public ArrayList<RigidBody> getRigidBodies() {
        return rigidBodies;
    }

    public void setRigidBodies(ArrayList<RigidBody> rigidBodies) {
        this.rigidBodies = rigidBodies;
    }
}
