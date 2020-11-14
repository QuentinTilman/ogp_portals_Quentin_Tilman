package testSuite;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import portals.Portal;
import portals.ThreeQuartersTransformation;
import portals.Transformation;
import portals.TwoThridsTransformation;

public class PortalTest {

	@Test
	void test() {
		Transformation ta = new TwoThridsTransformation();
		Transformation tb = new ThreeQuartersTransformation();
		
		Portal a = new Portal(ta);
		Portal b = new Portal(tb);
		
		assertEquals(a.getTransformation(),ta);
		assertEquals(b.getTransformation(),tb);
		
		a.setPairPortals(b);
		
		assertEquals(b,a.getPairedPortal());
		assertEquals(a, b.getPairedPortal());
		
		b.clearPairPortal();
		assertEquals(null,a.getPairedPortal());
		assertEquals(null, b.getPairedPortal());
	}
}
