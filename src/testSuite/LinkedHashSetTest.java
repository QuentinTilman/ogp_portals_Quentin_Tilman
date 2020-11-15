package testSuite;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import linkedHashSet.LinkedHashSet;

public class LinkedHashSetTest {

	@Test
	void test() {
		
		LinkedHashSet set = new LinkedHashSet(10);
		String a = "test0";
		String b = "test1";
		String c = "test2";
		String d = "test3";
		String e = "test4";
		
		assertTrue(0 == set.size());
		assertTrue( null != set.toArray());
		
		set.add(a);
		assertTrue(1 == set.size());
		
		set.add(b);
		assertTrue(2 == set.size());
		Object[] o= {a,b};
		assertTrue(Arrays.equals(o,set.toArray()));
		Object[] o2 = {b,a};
		assertFalse(Arrays.equals(o2,set.toArray()));
		
		set.add(c);
		assertTrue(3 == set.size());
		Object[] o3= {a,b,c};
		assertTrue(Arrays.equals(o3,set.toArray()));
		
		set.add(c);
		assertTrue(3 == set.size());
		assertTrue(Arrays.equals(o3,set.toArray()));
		
		
		set.remove(a);
		System.out.print(set.size());
		assertTrue(2 == set.size());
		Object[] o4= {b,c};
		assertTrue(Arrays.equals(o4,set.toArray()));
		
		
	}
}
