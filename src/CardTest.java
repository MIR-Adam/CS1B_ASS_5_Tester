
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
public class CardTest {

	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(CardTest.class.toString());

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

	private Card createTestSubject() {
		return new Card('A', Card.Suit.spades);
	}

	@MethodRef(name = "set", signature = "(CQSuit;)Z")
	@Test
	public void testSet() throws Exception {
		Card testSubject;
		char value = ' ';
		Card.Suit suit = null;
		boolean result;

		// default test
		testSubject = createTestSubject();
		// Make the testSubject invalid
		result = testSubject.set(value, suit);
		Assert.assertEquals(false, result);
		result = testSubject.set(value, Card.Suit.spades);
		Assert.assertEquals(false, result);
		// Make the testSubject valid
		value = 'J';
		suit = Card.Suit.hearts;
		result = testSubject.set(value, suit);
		Assert.assertTrue(result);
	}

	@MethodRef(name = "getValue", signature = "()C")
	@Test
	public void testGetValue() throws Exception {
		Card testSubject;
		char result;

		// default test
		testSubject = createTestSubject();
//		result = testSubject.getVal();
		 result = testSubject.getValue();// Student uses getValue instead of getVal
		Assert.assertEquals('A', result);
	}

	@MethodRef(name = "getSuit", signature = "()QSuit;")
	@Test
	public void testGetSuit() throws Exception {
		Card testSubject;
		Card.Suit result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSuit();
		Assert.assertEquals(Card.Suit.spades, result);
	}

	@MethodRef(name = "isErrorFlag", signature = "()Z")
	@Test
	public void testIsErrorFlag() throws Exception {
		Card testSubject;
		boolean result;

		// default test
		testSubject = createTestSubject();
//		 result = testSubject.getErrorFlag();
		Assert.assertFalse(testSubject.isErrorFlag()); // Student used 'is' predicate
		// naming
		// Assert.assertFalse(result); // Student used 'is' predicate naming
		testSubject.set('~', testSubject.getSuit());
//		 Assert.assertTrue(testSubject.getErrorFlag());
		Assert.assertTrue(testSubject.isErrorFlag()); // Student used 'is' predicate
		// naming
	}

	@MethodRef(name = "toString", signature = "()QString;")
	@Test
	public void testToString() throws Exception {
		Card testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
		Assert.assertEquals("A of spades", result);

		// make the Card bad and test again
		testSubject.set('~', Card.Suit.clubs);
		result = testSubject.toString();
		Assert.assertTrue(result.toLowerCase().contains("invalid") || result.toLowerCase().contains("illegal"));
	}

	@MethodRef(name = "isValid", signature = "(CQSuit;)Z")
	@Test
	public void testIsValid() throws Exception {
		char value = 'A';
		Card.Suit suit = Card.Suit.spades;
		boolean result;

		// test for detection of valid data
		// result = Card.isValid(value, suit);
		result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value, suit });
		Assert.assertTrue(result);
		value = 'J';
		suit = Card.Suit.diamonds;
		// result = Card.isValid(value, suit);
		result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value, suit });
		Assert.assertTrue(result);
		// test for detection of invalid data cancelled because can't pass null
		// good value, bad suit
		// value = 'J';
		// suit = null;
		// result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value,
		// suit });
		// Assert.assertFalse(result);
		// test for detection of invalid data
		// bad value, good suit
		value = ' ';
		suit = Card.Suit.diamonds;
		result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value, suit });
		Assert.assertFalse(result);
	}

	@MethodRef(name = "equals", signature = "(QCard;)Z")
	@Test
	public void testEquals() throws Exception {
		Card testSubject;
		Card card = new Card('A', Card.Suit.spades);
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.equals(card);
		Assert.assertTrue(result);

		// different value test
		testSubject = createTestSubject();
		testSubject.set('J', testSubject.getSuit());
		result = testSubject.equals(card);
		Assert.assertFalse(result);

		// different suit test
		testSubject = createTestSubject();
//		testSubject.set(testSubject.getVal(), Card.Suit.clubs);
		 testSubject.set(testSubject.getValue(), Card.Suit.clubs); // Student is not
		// using getVal
		result = testSubject.equals(card);
		Assert.assertFalse(result);

		// different errorFlag test
		testSubject = createTestSubject();
		// testSubject.errorFlag = true;
		Deencapsulation.setField(testSubject, "errorFlag", true);
//		 Assert.assertTrue(testSubject.getErrorFlag());
		Assert.assertTrue(testSubject.isErrorFlag()); // Student used 'is' predicate
		// naming
		result = testSubject.equals(card);
		Assert.assertFalse(result); // if result is true, ERROR: Student is not checking if the errorFlag is true
	}

	@MethodRef(name = "Card", signature = "(QCard;)Z")
	@Test
	public void testCard() throws Exception {
		Card testSubject;
		Card card = new Card('A', Card.Suit.spades);
		// boolean result;

		// copy test
		// testSubject = new Card(card);
		testSubject = new Card(); // Student has no copy constructor, which is OK
		Assert.assertEquals(testSubject.toString(), card.toString());
		Assert.assertEquals(true, testSubject.equals(card));
	}
}