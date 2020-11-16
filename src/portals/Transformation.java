package portals;

/**
 * @author QT
 */
public interface Transformation {

	/**
	 * Applies the implemented transformation to the given value.
	 * @pre | value >= 0
	 * @post | Math.round(value * 1/2) <= result && result <= Math.round(value*2)
	 */
	int apply(int value);
}
