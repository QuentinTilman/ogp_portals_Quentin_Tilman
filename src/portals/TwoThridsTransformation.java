package portals;

public class TwoThridsTransformation implements Transformation{

	@Override
	/**
	 * @throws IllegalArgumentException | value < 0
	 * @post 
	 */
	public int apply(int value) {
		if(value < 0)
			throw new IllegalArgumentException("The given value must be positive.");
		return 2*value/3;
	}
	
	public TwoThridsTransformation() {}

}
