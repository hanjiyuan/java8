package h3w.java8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import h3w.java8.App;

public class AppTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCount() {
		assertEquals(100, new App().count());
	}

}
