import bodies.RigidBody;
import common.MathUtils;
import common.MyVector;
import level.Level;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jordan on 2016-12-15.
 */
public class Scene /*extends JPanel*/ {

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
            MyVector collisionCell = collisionDetection(rb);
            if (collisionCell != null) {
//                System.out.println("Collision at location: " + collisionCell);
                // Round y to nearest cell
                collisionCell.y = (int)(collisionCell.y);
                rb.velocity.set(0.01f, 0);
            }
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
     * <p>
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

        for (float i = topLeft.x; i <= topLeft.x + rb.dimensions.x; i++) {
            for (float j = topLeft.y; j <= topLeft.y + rb.dimensions.y; j++) {
//                repaint();
                if (tileCollision(j, i)) {
                    return rb.location;
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
        return level.getTiles()[(int)x][(int)y] != null;
    }

    public boolean tileCollision(int x, int y) {
        return level.getTiles()[x][y] != null;
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
