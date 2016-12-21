import bodies.RigidBody;
import level.Level;
import level.Tile;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Jordan on 2016-11-20.
 */
public class Display extends JPanel {

    private int x, y;
    private Scene scene;

    private Level lvl;
    private JFileChooser jfc;

    public Display(int x, int y) {
        this.x = x;
        this.y = y;
        scene = new Scene();


        jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Documents\\Red-Riding-Hell-Levels"));

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == jfc.APPROVE_OPTION) {
            lvl = new Level(jfc.getSelectedFile());
        }

        scene.setLevel(lvl);
        scene.add(new RigidBody(112, 65, 32, 64, 10));

    }

    /**
     *
     * */
    public void update(float dt) {
        scene.step(dt);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (RigidBody b : scene.getRigidBodies()) {
            g.drawRect((int) (b.location.x - b.halfDim.x)
                    , (int) (b.location.y - b.halfDim.y)
                    , (int) (b.dimensions.x)
                    , (int) (b.dimensions.y)
            );
        }

        Tile tile;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 15; j++) {
                tile = scene.getLevel().getTiles()[j][i];
                if (tile != null) {
                    tile.paint(g);
                }
            }
        }
        scene.paint(g);
    }
}
