import bodies.RigidBody;
import level.Level;

/**
 * Created by Jordan on 2016-12-15.
 */
public class Main {

    public static void main(String[] args) {
        Scene scene = new Scene();
        scene.add(new RigidBody(10));
        scene.getRigidBodies().get(0).location.set(5, 5);
        scene.setLevel(new Level());

        scene.step(0.01f);
    }

}
