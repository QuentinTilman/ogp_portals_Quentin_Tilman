package testSuite;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import portals.ThreeQuartersTransformation;

public class ThreeQuartersTransformationTest {

	@Test
	void test() {
		ThreeQuartersTransformation ta = new ThreeQuartersTransformation();
		assertTrue(0 == ta.apply(1));
		assertTrue(3 == ta.apply(4));
	}
}
