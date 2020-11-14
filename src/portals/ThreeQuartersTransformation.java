package portals;

public class ThreeQuartersTransformation implements Transformation{

	@Override
	/**
	 * @pre | value >= 0
	 */
	public int apply(int value) {
		return 3*value/4;
	}
	
	public ThreeQuartersTransformation() {}

}
