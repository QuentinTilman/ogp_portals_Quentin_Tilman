package portals;

public class ThreeQuartersTransformation implements Transformation{

	@Override
	/**
	 * @pre | value >= 0
	 * @post | result == Math.round(value*3/4)
	 */
	public int apply(int value) {
		return Math.round(3*value/4);
	}
	
	/**
	 * Instantiates an ThreeQuartersTransformation instance.
	 */
	public ThreeQuartersTransformation() {}

}
