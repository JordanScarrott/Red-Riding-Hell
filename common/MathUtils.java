package common;

/**
 * Created by Jordan on 2016-12-10.
 */
public class MathUtils {

    /**
     * Maps a number from one range to another
     *
     * @param x  the number that you want to map to another range
     * @param a1 lower bound of the current range of x
     * @param a2 upper bound of the current range of x
     * @param b1 lower bound of the new range of x
     * @param b2 upper bound of the new range of x
     * @returns the value of x mapped to the new range
     */
    public static float map(float x, float a1, float a2, float b1, float b2) {
        return b1 + (b2 - b1) * (x - a1) / (a2 - a1);
    }

    /**
     * Rounds a number to the nearest Real number (integer)
     *
     * @param a the number to round
     * @return the number rounded to nearest Real number (integer)
     */
    public static int round(float a) {
        int y = (int) a;

        if (a % y >= 0.5f) {
            return y + 1;
        } else {
            return y;
        }
    }

}