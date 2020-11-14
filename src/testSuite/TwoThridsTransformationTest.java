package testSuite;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import portals.TwoThridsTransformation;

public class TwoThridsTransformationTest {

	@Test
	void test() {
		TwoThridsTransformation ta = new TwoThridsTransformation();
		assertTrue(0 == ta.apply(1));
		assertTrue(2 == ta.apply(3));
	}
}
