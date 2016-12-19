package common;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * A 2-dimensional, single-precision, floating-point vector with operator methods
 *
 * @author Jordan Scarrott
 */
public class MyVector {

    public float x, y;

    // Constructors
    public MyVector() {
        this(0, 0);
    }

    public MyVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the sum of two <code>MyVectors</code>
     */
    public static MyVector add(MyVector v1, MyVector v2) {
        return new MyVector(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * Returns the difference of two <code>MyVectors</code>
     */
    public static MyVector sub(MyVector v1, MyVector v2) {
        return new MyVector(v1.x - v2.x, v1.y - v2.y);
    }

    /**
     * Returns a copy of the specified <code>MyVector</code> as a new <code>MyVector</code>
     *
     * @param v the <code>MyVector</code> to be copied
     * @return a copy of the specified <code>MyVector</code> as a new <code>MyVector</code>
     */
    public static MyVector copy(MyVector v) {
        return new MyVector(v.x, v.y);
    }

    /**
     * Returns the product of a specified <code>MyVector</code> and a specified scalar number
     * as a <code>MyVector</code>
     *
     * @param v the <code>MyVector</code> to be multiplied
     * @param m the scalar to be multiplied with the components of the specified
     *          <code>MyVector</code>
     * @return a new <code>MyVector</code> that is the product of the specified
     * <code>MyVector</code> and the specified scalar
     */
    public static MyVector mult(MyVector v, float m) {
        return new MyVector(v.x *= m, v.y *= m);
    }

    /**
     * Computes the magnitude squared of the specified MyVector
     *
     * @return the square magnitude of the specified MyVector
     * @throws NullPointerException if the specified {@code MyVector} is null
     */
    public static float magSq(MyVector myVector) {
        return myVector.x * myVector.x + myVector.y * myVector.y;
    }

    /**
     * Computes dot (scalar) product of two Vectors
     *
     * @param v1 the first MyVector
     * @param v2 the second MyVector
     * @return the dot product of the two vectors
     * @throws NullPointerException if the specified {@code vector} is null
     */
    public static float dotProduct(MyVector v1, MyVector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    /**
     * Computes the angle (in degrees) between two Vectors
     *
     * @param v1 the first MyVector
     * @param v2 the second MyVector
     * @return the angle between the two vectors measured in degrees
     */
    public static float angle(MyVector v1, MyVector v2) {
        final float delta = (v1.x * v2.x + v1.y * v2.y) / (float) Math.sqrt(
                (v1.x * v1.x + v1.y * v1.y) * (v2.x * v2.x + v2.y * v2.y));

        if (delta > 1.0) {
            return 0.0f;
        }
        if (delta < -1.0) {
            return 180.0f;
        }

        return (float) Math.toDegrees(Math.acos(delta));
    }

    /**
     * Returns the square of the distance between two points.
     *
     * @param x1 the X coordinate of the first specified point
     * @param y1 the Y coordinate of the first specified point
     * @param x2 the X coordinate of the second specified point
     * @param y2 the Y coordinate of the second specified point
     * @return the square of the distance between the two
     * sets of specified coordinates.
     */
    public static float distanceSq(float x1, float y1, float x2, float y2) {
        x1 -= x2;
        y1 -= y2;
        return (x1 * x1 + y1 * y1);
    }

    /**
     * Rotates a MyVector by 90 degrees
     *
     * @param myVector the MyVector to rotate
     * @return the specified MyVector rotated by 90deg
     */
    public static MyVector rotate90(MyVector myVector) {
        return new MyVector(-myVector.y, myVector.x);
    }

    /**
     * Rotates a MyVector by -90 degrees
     *
     * @param myVector the MyVector to rotate
     * @return the specified MyVector rotated by -90deg
     */
    public static MyVector rotateMin90(MyVector myVector) {
        return new MyVector(myVector.y, -myVector.x);
    }

    /**
     * Returns myVector rotated by an angle of radAngle radians
     *
     * @param myVector the MyVector to rotate
     * @param radAngle angle in radians
     * @return a rotated MyVector
     */
    public static MyVector rotate(MyVector myVector, float radAngle) {
        double sine = sin(radAngle);
        double cosine = cos(radAngle);

        return new MyVector((float) (myVector.x * cosine - myVector.y * sine)
                , (float) (myVector.x * sine + myVector.y * cosine));
    }

    /**
     * Sets the components, x and y, of this <code>MyVector</code>
     */
    public void set(MyVector v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
     * Sets the components, x and y, of this <code>MyVector</code>
     * @return the MyVector with the new values
     */
    public MyVector set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Returns a copy of this <code>MyVector</code> as a <b>new</b> <code>MyVector</code>
     *
     * @return a copy of this <code>MyVector</code> as a <b>new</b> <code>MyVector</code>
     */
    public MyVector copy() {
        return copy(this);
    }

    /**
     * Adds the components of the specified <code>MyVector</code> to
     * this <code>MyVector</code> and them returns this <code>MyVector</code>
     *
     * @param vx the X component to be added to this <code>MyVector</code>
     * @param vy the Y component to be added to this <code>MyVector</code>
     * @return this <code>MyVector</code> after the addition
     */
    public MyVector add(float vx, float vy) {
        this.x += vx;
        this.y += vy;
        return this;
    }

    /**
     * Adds the components of the specified <code>MyVector</code> to
     * this <code>MyVector</code> and them returns this <code>MyVector</code>
     *
     * @param v the <code>MyVector</code> to be added to this <code>MyVector</code>
     * @return this <code>MyVector</code> after the addition
     */
    public MyVector add(MyVector v) {
        return this.add(v.x, v.y);
    }

    /**
     * Subtracts the components of the specified <code>MyVector</code> from
     * this <code>MyVector</code> and them returns this <code>MyVector</code>
     *
     * @param vx the X component to be subtracted from this <code>MyVector</code>
     * @param vy the Y component to be subtracted from this <code>MyVector</code>
     * @return this <code>MyVector</code> after the subtraction
     */
    public MyVector sub(float vx, float vy) {
        this.x -= vx;
        this.y -= vy;
        return this;
    }

    /**
     * Subtracts the components of the specified <code>MyVector</code> from
     * this <code>MyVector</code> and them returns this <code>MyVector</code>
     *
     * @param v the <code>MyVector</code> to be subtracted from this <code>MyVector</code>
     * @return this <code>MyVector</code> after the subtraction
     */
    public MyVector sub(MyVector v) {
        return this.sub(v.x, v.y);
    }

    /**
     * Multiplies this <code>MyVector</code> by the specified scalar, m
     *
     * @param m the scalar number by which this <code>MyVector</code>
     *          will be multiplied
     * @return this <code>MyVector</code> after the mulitplication
     */
    public MyVector mult(float m) {
        this.x *= m;
        this.y *= m;
        return this;
    }

    /**
     * Returns the quotient of the specified <code>MyVector</code> and the
     * specified scalar number as a <b>new</b> <code>MyVector</code>
     *
     * @param v the <code>MyVector</code> to be divided
     * @param m the scalar by which the specified <code>MyVectors</code> components
     *          will be divided
     * @return a new <code>MyVector</code> that is the quotient of the specified
     * <code>MyVector</code> and the specified scalar
     */
    public MyVector div(MyVector v, float m) {
        return new MyVector(this.x / m, this.y / m);
    }

    /**
     * Divides this <code>MyVector</code> by the specified scalar, m
     *
     * @param m the scalar number by which this <code>MyVector</code>
     *          will be divided
     * @return this <code>MyVector</code> after the division
     */
    public MyVector div(float m) {
        this.x /= m;
        this.y /= m;
        return this;
    }

    /**
     * Returns the angle between the positive Cartesian X axis and the
     * MyVector represented by this instance
     *
     * @return the bearing of the MyVector represented by this instance
     */
    public float bearing() {
        return angle(1, 0);
    }

    /**
     * Computes magnitude (length) of the relative magnitude vector represented
     * by this instance.
     *
     * @return magnitude of the vector
     */
    public float magnitude() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Normalizes the relative magnitude vector represented by this instance.
     * Returns a vector with the same direction and magnitude equal to 1.
     * If this is a zero vector, a zero vector is returned.
     *
     * @return the normalized {@code MyVector}
     */
    public MyVector normalize() {
        final float mag = magnitude();

        if (mag == 0.0) {
            return new MyVector(0.0f, 0.0f);
        }

        return new MyVector(this.x / mag, this.y / mag);
    }

    /**
     * Computes dot (scalar) product of the vector represented by this instance
     * and the specified vector.
     *
     * @param x the X magnitude of the other vector
     * @param y the Y magnitude of the other vector
     * @return the dot product of the two vectors
     */
    public float dotProduct(float x, float y) {
        return this.x * x + this.y * y;
    }

    /**
     * Computes dot (scalar) product of the myVector represented by this instance
     * and the specified myVector.
     *
     * @param myVector the other myVector
     * @return the dot product of the two vectors
     * @throws NullPointerException if the specified {@code myVector} is null
     */
    public float dotProduct(MyVector myVector) {
        return dotProduct(myVector.x, myVector.y);
    }

    /**
     * Returns a random MyVector
     * @param lowerBound the lowest x or y value that can be returned
     * @param upperBound the highest x or y value that can be returned
     * @return a random MyVector of Real numbers
     * */
    /*public static MyVector randomMyVector(int lowerBound, int upperBound) {
        Random rand = new Random();
        float x = rand.nextInt(upperBound - lowerBound);
        x = x > 0 ? x + lowerBound : -x + lowerBound;
        float y = rand.nextInt(upperBound - lowerBound);
        y = y > 0 ? y + lowerBound : -y + lowerBound;
        return new MyVector(x, y);
    }*/

    /**
     * Computes cross product of the myVector represented by this instance
     * and the specified myVector.
     *
     * @param myVector the other myVector
     * @return the cross product of the two vectors
     * @throws NullPointerException if the specified {@code myVector} is null
     */
    public final float cross(MyVector myVector) {
        return this.x * myVector.y - this.y * myVector.x;
    }

    /**
     * Computes the angle (in degrees) between this MyVector and
     * the specified MyVector.
     *
     * @param vx the X magnitude of the other vector
     * @param vy the Y magnitude of the other vector
     * @return the angle between the two vectors measured in degrees
     */
    public float angle(float vx, float vy) {
        return angle(this, new MyVector(vx, vy));
    }

    /**
     * Computes the angle (in degrees) between this MyVector and the
     * specified MyVector
     *
     * @param myVector the other myVector
     * @return the angle between the two vectors measured in degrees,
     * {@code NaN} if any of the two vectors is a zero myVector
     * @throws NullPointerException if the specified {@code myVector} is null
     */
    public float angle(MyVector myVector) {
        return angle(this, myVector);
    }

    /**
     * Rotates the MyVector represented by this instance 90deg
     */
    public void rotate90() {
        float newX = -this.y;
        float newY = this.x;

        this.x = newX;
        this.y = newY;
    }

    /**
     * Rotate the MyVector represented by this instance
     *
     * @param radAngle angle in radians
     */
    public void rotate(float radAngle) {
        this.set(rotate(this, radAngle));
    }

    /**
     * Rotates the MyVector represented by this instance -90deg
     */
    public void rotateMin90() {
        float newX = this.y;
        float newY = -this.x;

        this.x = newX;
        this.y = newY;
    }

    /**
     * Returns a <code>String</code> that represents the value
     * of this <code>Vec2d</code>.
     *
     * @return a string representation of this <code>Vec2d</code>.
     */
    @Override
    public String toString() {
        return "MyVector[" + x + ", " + y + "]";
    }
}