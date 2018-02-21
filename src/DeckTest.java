
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
public class DeckTest {

	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(DeckTest.class.toString());

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

	private Deck createTestSubject() {
		return new Deck(1);
	}

	@MethodRef(name = "allocateMasterPack", signature = "()V")
	@Test
	public void testAllocateMasterPack() throws Exception {

		// default test
		Deencapsulation.invoke(Deck.class, "allocateMasterPack");
	}

	@MethodRef(name = "init", signature = "(I)Z")
	@Test
	public void testInit() throws Exception {
		Deck testSubject;
		int numPacks = 0;
		boolean result;

		// test 1
		testSubject = createTestSubject();
		numPacks = 1;
		result = testSubject.init(numPacks);
		Assert.assertEquals(true, result);

		// test 2
		testSubject = createTestSubject();
		numPacks = 0;
		result = testSubject.init(numPacks);
		// Assert.assertEquals(false, result);
		// Assert.assertEquals(0,testSubject.getNumCards());

		// test 3
		testSubject = createTestSubject();
		numPacks = 2;
		result = testSubject.init(numPacks);
		Assert.assertEquals(true, result);

		// test 4
		testSubject = createTestSubject();
		numPacks = -1;
		result = testSubject.init(numPacks);
		Assert.assertEquals(false, result);

		// test 5
		testSubject = createTestSubject();
		numPacks = 100;
		result = testSubject.init(numPacks);
		Assert.assertEquals(false, result);
	}

	@MethodRef(name = "init", signature = "()V")
	@Test
	public void testInit_1() throws Exception {
		Deck testSubject;
		int numPacks = 0;
		boolean result;

		// test 1
		testSubject = new Deck();
		numPacks = 1;
		result = testSubject.init(numPacks);
		Assert.assertEquals(true, result);

		// test 1 (without a parameter)
		testSubject = new Deck(0);
		// testSubject.init();
		numPacks = 1;
		testSubject.init(numPacks);
		// Assert.assertEquals(52, testSubject.getNumCards() + 1); // Student's topCard
		// starts as 52 (for 1 deck) and thus is 1
		// more than the index of the actual topCard in the array
		Assert.assertEquals(52, testSubject.getNumCards());

		// test 2
		testSubject = new Deck();
		// Assert.assertEquals(52, testSubject.getNumCards() + 1); // Student's topCard
		// starts as 52 (for 1 deck) and thus is 1
		// more than the index of the actual topCard in the array
		Assert.assertEquals(52, testSubject.getNumCards());

		// test 3
		testSubject = new Deck();
		numPacks = 2;
		result = testSubject.init(numPacks);
		// Assert.assertEquals(104, testSubject.getNumCards() + 1); // Student's topCard
		// starts as 52 (for 1 deck) and thus is 1
		// more than the index of the actual topCard in the array
		Assert.assertEquals(104, testSubject.getNumCards());
	}

	@MethodRef(name = "getNumCards", signature = "()I")
	@Test
	public void testGetNumCards() throws Exception {
		Deck testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getNumCards();
		Assert.assertEquals(52, result);
	}

	@MethodRef(name = "shuffle", signature = "()V")
	@Test
	public void testShuffle() throws Exception {
		Deck testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.shuffle();
	}

	@MethodRef(name = "dealCard", signature = "()QCard;")
	@Test
	public void testDealCard() throws Exception {
		Deck testSubject;
		Card result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.dealCard();
		boolean notEmpty = true;
		while (notEmpty) {
//			Assert.assertEquals(false, result.getErrorFlag());
			 Assert.assertFalse(result.isErrorFlag()); // : Student uses is form of
			// predicate
			result = testSubject.dealCard();
			notEmpty = testSubject.getNumCards() > 0;
		}

		// Try to deal from empty deck
		// accessing elements -> AIOOBEx
		result = testSubject.dealCard(); // if false, ERROR: Student is not checking if it is safe
		// to deal a card from an empty Deck instance
//		Assert.assertTrue(result.getErrorFlag());
		 Assert.assertTrue(result.isErrorFlag()); // : Student uses is form of
		// predicate

		// Test if dealing can possibly change the masterPack
		testSubject = createTestSubject();
		Card[] masterPack = Deencapsulation.getField(Deck.class, "masterPack");
		result = testSubject.dealCard();
		for (int index = 0; index < masterPack.length; ++index) {
			if (masterPack[index].equals(result)) {
				if (masterPack[index] == result) {
					Assert.fail("dealCard() should return copies of objects from the masterPack, not origonals");
				}
			}
		}
	}

	@MethodRef(name = "inspectCard", signature = "(I)QCard;")
	@Test
	public void testInspectCard() throws Exception {
		Deck testSubject;
		int k = 0;
		Card result;

		// test 1
		testSubject = createTestSubject();
		k = 0;
		result = testSubject.inspectCard(k);
		Assert.assertEquals("2 of clubs", result.toString());
		// if not equal, ERROR Student is sorting out of the assigned order

		// test 2
		testSubject = createTestSubject();
		k = -1;
		result = testSubject.inspectCard(k);
//		Assert.assertEquals(true, result.getErrorFlag());
		 Assert.assertTrue(result.isErrorFlag()); // : Student uses is predicate

		// test 3
		testSubject = createTestSubject();
		k = 1;
		result = testSubject.inspectCard(k);
//		Assert.assertEquals(false, result.getErrorFlag());
		 Assert.assertFalse(result.isErrorFlag()); // : Student uses is predicate

		// test 4
		testSubject = createTestSubject();
		k = 1000;
		result = testSubject.inspectCard(k);
//		Assert.assertEquals(true, result.getErrorFlag());
		 Assert.assertTrue(result.isErrorFlag()); // : Student uses is predicate

	}
}