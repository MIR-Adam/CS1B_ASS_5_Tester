
import java.util.logging.Logger;

import javax.annotation.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import mockit.Deencapsulation;

@Generated(value = "org.junit-tools-1.0.6")
public class CardTableTest {

	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(CardTableTest.class.toString());

	@Before
	public void setUp() throws Exception {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private CardTable createTestSubject() {
		return new CardTable("CS 1B CardTable", 13, 2);
	}

	@MethodRef(name = "getNumCardsPerHand", signature = "()I")
	@Test
	public void testGetNumCardsPerHand() throws Exception {
		CardTable testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = Deencapsulation.invoke(testSubject, "getNumCardsPerHand");
		Assert.assertEquals(13, result);;
	}

	@MethodRef(name = "getNumPlayers", signature = "()I")
	@Test
	public void testGetNumPlayers() throws Exception {
		CardTable testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = Deencapsulation.invoke(testSubject, "getNumPlayers");
		Assert.assertEquals(2, result);;
	}
}