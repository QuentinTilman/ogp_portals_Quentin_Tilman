package portals;

public interface Transformation {

	/**
	 * Applies the implemented transformation to the given value.
	 * @pre | value >= 0
	 * 
	 */
	int apply(int value);
}
