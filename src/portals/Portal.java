package portals;

/**
 * Each instance of this class represents an Object-Oriented Portal,
 * that applies a certain transformation to items that are pass through or comes out.
 * 
 * @invar | getTransformation() != null
 * @invar | getPairedPortal() == null || getPairedPortal().getPairedPortal().equals(this)
 * @author QT
 *
 */
public class Portal {

	/**
	 * @invar | pairedPortal == null || pairedPortal.pairedPortal.equals(this)
	 * @peerObject
	 */
	private Portal pairedPortal;
	
	/**
	 * @invar | transformation != null
	 */
	private Transformation transformation;
	
	/**
	 * Initialises this instance to represent a Portal with a certain given transformation.
	 * 
	 * @throws IllegalArgumentException | transformation == null
	 * @post | getTransformation().equals(transformation)
	 */
	public Portal(Transformation transformation) {
		if(transformation == null)
			throw new IllegalArgumentException("Transformation may not be null.");
		this.transformation = transformation;
	}
	
	/**
	 * Pairs this portal to another portal 
	 * such that elements can be passed to the pair portal and endure a certain transformation.
	 * 
	 * @throws IllegalArgumentException | other == null 
	 * @throws IllegalArgumentException | other.getPairedPortal() != null 
	 * @throws IllegalArgumentException | getPairedPortal() != null 
	 * @mutates | this, other
	 * @post | getPairedPortal().equals(other)
	 * @post | other.getPairedPortal().equals(this)
	 */
	public void setPairPortals(Portal other) {
		if(other == null)
			throw new IllegalArgumentException("Given value may not be null.");
		if(other.getPairedPortal() != null)
			throw new IllegalArgumentException("The given Portal has already a paired portal.");
		if(pairedPortal != null)
			throw new IllegalArgumentException("This portal has already a paired portal.");
		other.pairedPortal= this;
		pairedPortal = other;
	}
	
	/**
	 * Registers the fact that this portal is breaking it's connection with 
	 * his paired portal.
	 * 
	 * @throws IllegalStateException | getPairedPortal() == null
	 * @mutates this
	 * @post This portal has no paired portal | getPairedPortal() == null
	 * @post This portal's old pair portal has no paired portal. | old(getPairedPortal()).getPairedPortal() == null
	 */
	public void clearPairPortal() {
		if (pairedPortal == null)
            throw new IllegalStateException(
                "This portal does not have a paired portal.");
		pairedPortal.pairedPortal = null;
		pairedPortal = null;
	}
	/**
	 * Returns this portal's paired portal or return null if none is paired.
	 * 
	 * @peerObject
	 */
	public Portal getPairedPortal(){
		return pairedPortal;
	}

	/**
	 * Returns the transformation that this portal applies to values that are pass through.
	 */
	public Transformation getTransformation() {
		return transformation;
	}
	
	/**
	 * 
	 * Passes a value through the wormhole with both transformations applied consecutively starting
	 * by the portal that is used to get in the wormhole.
	 * 
	 * @throws IllegalArgumentException | value < 0
	 * @throws IllegalStateException | getPairedPortal() == null
	 * @post As transformations are some fractions between 1/2 and 2, after passing the wormhole the result will be between 1/4 and 4 times the given value 
	 * 			| value*1/4 <= result && result <= value*4
	 */
	public int passPortal(int value) {
		if(value < 0)
			throw new IllegalArgumentException();
		if(pairedPortal == null)
			throw new IllegalStateException("You first need to pair this portal with another portal to create a wormhole.");
		return pairedPortal.transformation.apply(transformation.apply(value));
	}
}
