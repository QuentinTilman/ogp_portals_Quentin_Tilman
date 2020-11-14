package portals;

/**
 * @invar | getTransformation() != null
 * @author QT
 *
 */
public class Portal {

	/**
	 * @peerObject
	 */
	private Portal pairedPortal;
	
	/**
	 * @invar | transformation != null
	 */
	private Transformation transformation;
	
	/**
	 * @throws IllegalArgumentException | transformation == null
	 * @post | getTransformation().equals(transformation)
	 */
	public Portal(Transformation transformation) {
		if(transformation == null)
			throw new IllegalArgumentException("Transformation may not be null.");
		this.transformation = transformation;
	}
	
	/**
	 * @throws IllegalArgumentException | other == null 
	 * @post | getPairedPortal().equals(other)
	 * @post | other.getPairedPortal().equals(this)
	 */
	public void setPairPortals(Portal other) {
		if(other == null)
			throw new IllegalArgumentException();
		other.pairedPortal= this;
		pairedPortal = other;
	}
	
	/**
	 * 
	 */
	public void clearPairPortal() {
		pairedPortal.pairedPortal = null;
		pairedPortal = null;
	}
	/**
	 * @peerObject
	 */
	public Portal getPairedPortal(){
		return pairedPortal;
	}

	public Transformation getTransformation() {
		return transformation;
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException | value < 0
	 * @param value
	 * @return
	 */
	public int passPortal(int value) {
		if(value < 0)
			throw new IllegalArgumentException();
		return pairedPortal.transformation.apply(value);
	}
}
