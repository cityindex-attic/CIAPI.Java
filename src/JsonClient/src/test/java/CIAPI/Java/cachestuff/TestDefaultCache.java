package CIAPI.Java.cachestuff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JsonClient.Java.cachestuff.DefaultCache;

public class TestDefaultCache {

	private DefaultCache<String, String> cache;
	private final long expireTime = 100;

	@Before
	public void setUp() throws Exception {
		cache = new DefaultCache<String, String>(expireTime);
	}

	@After
	public void tearDown() throws Exception {
		cache = null;
	}

	@Test
	public void testPutSimple() {
		assertEquals(0, cache.entryCount());
		assertNull(cache.put("A", "a"));
		assertEquals(1, cache.entryCount());
		assertNull(cache.put("B", "b"));
		assertEquals(2, cache.entryCount());
		assertNull(cache.put("C", "c"));
		assertEquals(3, cache.entryCount());
		assertEquals("a", cache.put("A", "notA"));
		assertEquals(3, cache.entryCount());
		assertEquals("notA", cache.put("A", "a"));
		assertEquals(3, cache.entryCount());
	}

	@Test
	public void testGetSimple() {
		assertNull(cache.put("1", "1"));
		assertEquals("1", cache.get("1"));
		assertNull(cache.get("nonexistantkey"));
	}

	@Test
	public void testSimpleExpireItem() {
		assertNull(cache.put("1", "1"));
		assertEquals("1", cache.get("1"));
		try {
			Thread.sleep(expireTime);
		} catch (InterruptedException e) {
			fail();
		}
		assertNull(cache.get("1"));
	}

	@Test
	public void testManualClean() {
		cache.put("A", "A");
		cache.put("B", "B");
		cache.put("C", "C");
		cache.put("D", "D");
		assertEquals(4, cache.entryCount());
		try {
			Thread.sleep(expireTime + 1);
		} catch (InterruptedException e) {
			fail();
		}
		assertEquals(4, cache.entryCount());
		cache.clean();
		assertEquals(0, cache.entryCount());
	}

	@Test
	public void testAutoClean() {
		cache.setMaxSize(3, false);
		cache.put("A", "A");
		cache.put("B", "B");
		cache.put("C", "C");
		try {
			Thread.sleep(expireTime + 1);
		} catch (InterruptedException e) {
			fail();
		}
		assertEquals(3, cache.entryCount());
		cache.put("D", "D");
		assertEquals(1, cache.entryCount());
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullKey() {
		cache.put("A", "A");
		cache.put(null, "string");
	}

	@Test(expected = NullPointerException.class)
	public void testDeleteNullKey() {
		cache.put("A", "A");
		cache.delete(null);
	}
}
