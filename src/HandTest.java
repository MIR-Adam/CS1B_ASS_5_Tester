
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
public class HandTest {

	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(HandTest.class.toString());
	private Card card = null;

	@Before
	public void setUp() throws Exception {
		card = new Card('A', Card.Suit.spades);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		card = null;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private Hand createTestSubject() {
		return new Hand();
	}

	@MethodRef(name = "resetHand", signature = "()V")
	@Test
	public void testResetHand() throws Exception {
		Hand testSubject;

		// default test
		testSubject = createTestSubject();
		Assert.assertEquals(0, testSubject.getNumCards());
		testSubject.takeCard(card);
		Assert.assertEquals(1, testSubject.getNumCards());
		testSubject.resetHand();

		Assert.assertEquals(0, testSubject.getNumCards());
	}

	@MethodRef(name = "takeCard", signature = "(QCard;)Z")
	@Test
	public void testTakeCard() throws Exception {
		Hand testSubject;
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.takeCard(card);

		Assert.assertEquals(true, result);
		Assert.assertTrue(testSubject.toString().contains("A of spades"));
		while(result) {
			Assert.assertEquals(true, result);
			result = testSubject.takeCard(card);
		}
	}

	@MethodRef(name = "playCard", signature = "()QCard;")
	@Test
	public void testPlayCard() throws Exception {
		Hand testSubject;
		Card result;

		// default test
		testSubject = createTestSubject();
		Assert.assertTrue(testSubject.takeCard(card));
		Assert.assertNotNull(testSubject.toString());
		Assert.assertTrue(testSubject.toString().contains("A of spades"));
		result = testSubject.playCard();
		Assert.assertFalse(testSubject.toString().contains(" of "));
		result = testSubject.playCard();
//		Assert.assertTrue(result.getErrorFlag());
		Assert.assertTrue(result.isErrorFlag()); // Student used 'is' predicate naming instead of getErrorFlag
	}

	@MethodRef(name = "inspectCard", signature = "(I)QCard;")
	@Test
	public void testInspectCard() throws Exception {
		Hand testSubject;
		int k = 0;
		Card result;

		// test 1
		testSubject = createTestSubject();
		Assert.assertTrue(testSubject.takeCard(new Card('A', Card.Suit.spades)));
		k = 0;
		result = testSubject.inspectCard(k);
		Assert.assertNotNull(result);  // A failure here means student didn't use zero-indexing properly
		Assert.assertFalse(result.isErrorFlag()); // Student used 'is' predicate naming instead of getErrorFlag
//		Assert.assertFalse(result.getErrorFlag());
		
		// test 2
		testSubject = createTestSubject();
		k = -1;
		result = Deencapsulation.invoke(testSubject, "inspectCard", new Object[] { k });
//		Assert.assertEquals(true, result.getErrorFlag());
		Assert.assertTrue(result.isErrorFlag()); // Student used 'is' predicate naming instead of getErrorFlag

		// test 3
		testSubject = createTestSubject();
		k = 1;
		result = Deencapsulation.invoke(testSubject, "inspectCard", new Object[] { k });
//		Assert.assertEquals(true, result.getErrorFlag());
		Assert.assertTrue(result.isErrorFlag()); // Student used 'is' predicate naming instead of getErrorFlag

		// Assert.fail();
	}

	@MethodRef(name = "toString", signature = "()QString;")
	@Test
	public void testToString() throws Exception {
		Hand testSubject;
		String result;

		// default test
		Assert.assertNotNull(testSubject = createTestSubject());
		Assert.assertTrue(testSubject.takeCard(card));
		Assert.assertTrue(testSubject.takeCard(new Card('J', Card.Suit.diamonds)));
		result = testSubject.toString();
		Assert.assertTrue(result.contains("A of spades"));
		Assert.assertTrue(result.contains("J of diamonds"));
		testSubject.playCard();
		result = testSubject.toString();
		Assert.assertTrue(result.contains("A of spades"));
		testSubject.playCard();
		result = testSubject.toString();
	Assert.assertFalse(result.contains(" of "));
	}

	@MethodRef(name = "getNumCards", signature = "()I")
	@Test
	public void testGetNumCards() throws Exception {
		Hand testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = Deencapsulation.invoke(testSubject, "getNumCards");

		Assert.assertEquals(0, result);
	}
}