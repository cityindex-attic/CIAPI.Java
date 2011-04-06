package CIAPI.Java.cachestuff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JsonClient.Java.cachestuff.Pair;

public class PairTest {

	private Pair<String, Integer> pair1;
	private Pair<String, Integer> pair1_copy;
	private Pair<Integer, String> pair2;
	private Pair<Integer, String> pair2_copy;

	private Pair<String, String> nullFirst;
	private Pair<String, String> nullFirst_copy;
	private Pair<String, String> nullSecond;
	private Pair<String, String> nullSecond_copy;

	@Before
	public void setUp() throws Exception {
		pair1 = new Pair<String, Integer>("One", new Integer(1));
		pair2 = new Pair<Integer, String>(new Integer(2), "Two");
		pair1_copy = new Pair<String, Integer>("One", new Integer(1));
		pair2_copy = new Pair<Integer, String>(new Integer(2), "Two");

		nullFirst = new Pair<String, String>(null, "null");
		nullFirst_copy = new Pair<String, String>(null, "null");
		nullSecond = new Pair<String, String>("null", null);
		nullSecond_copy = new Pair<String, String>("null", null);
	}

	@After
	public void tearDown() throws Exception {
		pair1 = pair1_copy = null;
		pair2 = pair2_copy = null;
	}

	@Test
	public void testSimpleConstructor() {
		assertEquals(pair1, pair1_copy);
		assertEquals(pair2, pair2_copy);
		assertEquals(pair1.hashCode(), pair1_copy.hashCode());
		assertEquals(pair2.hashCode(), pair2_copy.hashCode());
	}

	@Test
	public void testWithNullValues() {
		assertEquals(nullFirst, nullFirst_copy);
		assertEquals(nullFirst.hashCode(), nullFirst_copy.hashCode());
		assertEquals(nullSecond, nullSecond_copy);
		assertEquals(nullSecond.hashCode(), nullSecond_copy.hashCode());
	}

	@Test
	public void moreEqualityTests() {
		assertFalse(pair1.equals(null));
		assertTrue(pair1.equals(pair1));
		assertFalse(pair1.equals("pair1"));
	}
}
