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
        while (true) {
            d.update(0.001f);
            d.repaint();
        }
    }
}
