package testSuite;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import portals.Portal;
import portals.ThreeQuartersTransformation;
import portals.Transformation;
import portals.TwoThridsTransformation;

public class PortalTest {
	
	@Test
	void ConstructorPortaltest() {
		Transformation transformation = new TwoThridsTransformation();
		Portal portal = new Portal(transformation);
		
		assertEquals(transformation, portal.getTransformation());
	}
	
	@Test
	void PairPortalTest() {
		Transformation ta = new TwoThridsTransformation();
		Transformation tb = new ThreeQuartersTransformation();
		
		Portal a = new Portal(ta);
		Portal b = new Portal(tb);
		
		a.setPairPortals(b);
		
		assertEquals(b,a.getPairedPortal());
		assertEquals(a, b.getPairedPortal());
	}
	
	@Test
	void ClearPortalTest() {
		Transformation ta = new TwoThridsTransformation();
		Transformation tb = new ThreeQuartersTransformation();
		
		Portal a = new Portal(ta);
		Portal b = new Portal(tb);
		
		a.setPairPortals(b);
		
		b.clearPairPortal();
		assertEquals(null,a.getPairedPortal());
		assertEquals(null, b.getPairedPortal());
	}
	
	@Test
	void PassThroughPortal() {
		
		Transformation ta = new TwoThridsTransformation();
		Transformation tb = new ThreeQuartersTransformation();
		
		Portal a = new Portal(ta);
		Portal b = new Portal(tb);
		
		a.setPairPortals(b);
		
		assertEquals(tb.apply(ta.apply(4)),a.passPortal(4));
		
	}
}
