import bodies.RigidBody;
import collision.CollisionPair;
import common.MathUtils;
import common.MyVector;
import level.Level;
import level.Tile;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-15.
 */
public class Scene /*extends JPanel*/ {

    private Level level;

    private ArrayList<RigidBody> rigidBodies;
    private ArrayList<MyVector> globalForces;
    private ArrayList<CollisionPair> collisionPairs;

    /**
     *
     * */
    public Scene() {
        rigidBodies = new ArrayList<>();
        globalForces = new ArrayList<>();
        collisionPairs = new ArrayList<>();
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

        // Integrate Forces and Velocities
        for (RigidBody rb : rigidBodies) {
            integrateForces(rb, dt);
            integrateVelocity(rb, dt);
        }

        // Collision Detection (With Tiles)
        for (RigidBody rb : rigidBodies) {
            Tile collisionCell = collisionDetection(rb);
            if (collisionCell != null) {
                // Generate collision pair
                collisionPairs.add(new CollisionPair(rb, collisionCell));
                rb.velocity.y *= -0.75f;
            }
        }

        // Collision Resolution (With Tiles)

        // Clear forces and collision pairs
        for (RigidBody rb : rigidBodies) {
            rb.netForce.set(0, 0);
        }
        collisionPairs.clear();
    }

    /**
     * Version 2 of the RigidBody - Tile Collision Detection Algorithm
     * Detects RigidBody - Tile collisions for variable sized quads
     * <p>
     * NB: Top and Bottom Right coordinates might be checked twice
     * under certain conditions
     *
     * @param rb the RigidBody to perform collision detection upon
     * @return the Tile in the grid that the RigidBody is colliding with.
     * If there is no collision returns null
     */
    public Tile collisionDetection(RigidBody rb) {
        // Top Left Coordinate
        MyVector topLeft = MyVector.sub(rb.location, rb.halfDim);

        for (float i = topLeft.x; i <= topLeft.x + rb.dimensions.x; i += RigidBody.BLOCK_SIZE) {
            for (float j = topLeft.y; j <= topLeft.y + rb.dimensions.y; j += RigidBody.BLOCK_SIZE) {
//                repaint();
                if (tileCollision(j, i)) {
                    return level.getTiles()[(int)(j / RigidBody.BLOCK_SIZE)][(int)(i / RigidBody.BLOCK_SIZE)];
                }
            }
        }

        return null;
    }

    public void paint(Graphics g) {
//        super.paint(g);

//        g.setColor(Color.BLACK);
//        g.drawRect(100, 100, 50, 50);
    }

    /**
     * @param x x position in the Tiles[][] grid
     * @param y y position in the Tiles[][] grid
     * @return true if player collides with a tile at this position
     */
    public boolean tileCollision(float x, float y) {
        return level.getTiles()[(int)(x / RigidBody.BLOCK_SIZE)][(int)(y / RigidBody.BLOCK_SIZE)] != null;
    }

    public boolean tileCollision(int x, int y) {
        return level.getTiles()[x][y] != null;
    }

    /**
     * Integrates the velocity of a RigidBody
     */
    public void integrateVelocity(RigidBody rb, float dt) {
        // x += v * dt
        rb.location.add(MyVector.mult(rb.velocity, dt));
    }

    /**
     * Integrates the Forces acting on a RigidBody
     *
     * @param rb the RigidBody who's forces will be integrated
     * @param dt the time interval to integrate by
     */
    public void integrateForces(RigidBody rb, float dt) {
        // v += 1 / mass * forces * dt
        rb.velocity.add(rb.netForce.mult(dt).mult(rb.invMass));
    }


    /**
     * Getters and Setters
     */
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
        this.globalForces.addAll(level.getGlobalForces());
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
