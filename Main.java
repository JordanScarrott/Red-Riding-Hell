import javax.swing.*;

/**
 * Created by Jordan on 2016-12-15.
 */
public class Main {
    static JFrame frame = new JFrame();

    public static void main(String[] args) throws InterruptedException {

        int[][] test = new int[][]{{1, 1}, {2, 2}, {3, 3}};
//        System.out.println(test.length);
//        System.out.println(test[0].length);

        frame.setSize(800, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        runnit();

    }

    public static void runnit() throws InterruptedException {
        Display d = new Display(800, 650);
        frame.add(d);
        frame.revalidate();
        frame.repaint();


        float fps = 30;
        float dt = 1 / fps;
        float accumulator = 0;

        float startTime = System.nanoTime();
        float currentTime;

        while (true) {
            currentTime = System.nanoTime();

            // Store the time elapsed since the last frame began
            accumulator += currentTime - startTime;
            // Record the starting of this frame
            startTime = currentTime;

            // Clamp accumulator
//              ??? NOT SURE WHY VALUE IS 0.2 !!!
            if (accumulator > 0.2f) accumulator = 0.2f;

            while (accumulator > dt) {
//                System.out.println(dt);
                d.update(dt);
                accumulator -= dt;
            }

            // Render
            d.repaint();
        }
    }
}
