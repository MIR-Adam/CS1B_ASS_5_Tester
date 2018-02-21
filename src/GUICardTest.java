
import java.util.logging.Logger;

import javax.annotation.Generated;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import mockit.Deencapsulation;

@Generated(value = "org.junit-tools-1.0.6")
public class GUICardTest {

	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(GUICardTest.class.toString());

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

	private GUICard createTestSubject() {
		return new GUICard();
	}

	@MethodRef(name = "turnIntIntoCardValueChar", signature = "(I)C")
	@Test
	public void testTurnIntIntoCardValueChar() throws Exception {
		int k = 0;
		char result;

		// test 1
		k = 0;
		String methodName = "turnIntIntoCardValueChar";
		result = Deencapsulation.invoke(GUICard.class, methodName, new Object[] { k });
		Assert.assertEquals(50, result);

		// test 2
		k = -1;
		result = Deencapsulation.invoke(GUICard.class, methodName, new Object[] { k });
		Assert.assertEquals(63, result);

		// test 3
		k = 1;
		result = Deencapsulation.invoke(GUICard.class, methodName, new Object[] { k });
		Assert.assertEquals(51, result);
	}

	@MethodRef(name = "turnIntIntoCardSuitChar", signature = "(I)C")
	@Test
	public void testTurnIntIntoCardSuitChar() throws Exception {
		int k = 0;
		char result;

		// test 1
		k = 0;
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(67, result);

		// test 2
		k = -1;
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(63, result);

		// test 3
		k = 1;
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(68, result);

		// test 4
		k = 3;
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(83, result);

		// test 5
		k = 2;
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(72, result);

		// test 6
		k = 4;
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(63, result);
	}

	@MethodRef(name = "turnIntIntoSuit", signature = "(I)QCard.Suit;")
	@Test
	public void testTurnIntIntoSuit() throws Exception {
		int k = 0;
		Card.Suit result;

		// default test
		result = Deencapsulation.invoke(GUICard.class, "turnIntIntoSuit", new Object[] { k });
		Assert.assertEquals(Card.Suit.clubs, result);
	}

	@MethodRef(name = "valueAsInt", signature = "(QCard;)I")
	@Test
	public void testValueAsInt() throws Exception {
		Card card = null;
		int result;

		// default test
		card = new Card();
//		Assert.assertEquals('A', card.getVal());
		Assert.assertEquals('A', card.getValue());
		result = Deencapsulation.invoke("GUICard", "valueAsInt", card);
		Assert.assertEquals(12, result);
	}

	@MethodRef(name = "suitAsInt", signature = "(QCard;)I")
	@Test
	public void testSuitAsInt() throws Exception {
		Card card = null;
		int result;

		// default test
		card = new Card();
		result = Deencapsulation.invoke(GUICard.class, "suitAsInt", card);
		Assert.assertEquals(3, result);
		;
	}

	@MethodRef(name = "loadCardIcons", signature = "()V")
	@Test
	public void testLoadCardIcons() throws Exception {

		// default test
		GUICard.loadCardIcons();
		ImageIcon[][] iconCards;
		iconCards = Deencapsulation.getField(GUICard.class, "iconCards");
		Assert.assertEquals(14, iconCards.length);
		Assert.assertEquals(4, iconCards[0].length);
	}

	@MethodRef(name = "getIcon", signature = "(QCard;)QImageIcon;")
	@Test
	public void testGetIcon() throws Exception {
		Card card = null;
		Object result;// ImageIcon or Icon

		// default test
		GUICard.loadCardIcons();
		card = new Card('9', Card.Suit.clubs);
		result = GUICard.getIcon(card);
		String expectedString = "9C";
		if (!result.toString().contains(expectedString)) {
			// try to get the filename
			String filename = Deencapsulation.getField(result, "filename");
			Assert.assertNotNull(filename);
			Assert.assertEquals(true, filename.contains(expectedString));
		}
	}

	@MethodRef(name = "getBackCardIcon", signature = "()QIcon;")
	@Test
	public void testGetBackCardIcon() throws Exception {
		Icon result;

		// default test
		GUICard.loadCardIcons();
		result = GUICard.getBackCardIcon();
		String expectedString = "BK";
		if (!result.toString().contains(expectedString)) {
			// try to get the filename
			String filename = Deencapsulation.getField(result, "filename");
			Assert.assertNotNull(filename);
			Assert.assertEquals(true, filename.contains(expectedString));
		}
	}
}