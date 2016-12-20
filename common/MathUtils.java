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

    /**
     * @param a the number to absRound
     * @return absolute value of round(a)
     */
    public static int absRound(float a) {
        int x = round(a);
        return x >= 0 ? x : -x;
    }

    /**
     * Prevents a number from exceeding a threshold
     *
     * @param x         the number to clamp
     * @param threshold the max value that x can be
     * @return the number if it is less than threshold else the number
     * set to the same value as the threshold
     */
    public float clamp(float x, float threshold) {
        return x = x > threshold ? threshold : x;
    }

    /**
     * Clamps the number x withing the range of (min -> max)
     *
     * @param x   the number to clamp
     * @param min minimum value of x
     * @param max max value of x
     * @return the clamped number
     */
    public float clamp(float x, float min, float max) {
        if (x < min) {
            return min;
        } else if (x > max) {
            return max;
        } else {
            return x;
        }
    }
}