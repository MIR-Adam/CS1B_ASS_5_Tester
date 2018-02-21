package phase1;

import java.util.logging.Logger;

import javax.annotation.Generated;
import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import mockit.Deencapsulation;

@Generated(value = "org.junit-tools-1.0.6")
public class FoothillTest {

	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(FoothillTest.class.toString());

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

	private Foothill createTestSubject() {
		return new Foothill();
	}

	@MethodRef(name = "loadCardIcons", signature = "()V")
	@Test
	public void testLoadCardIcons() throws Exception {

		// default test
		Foothill foothill = createTestSubject();
		Deencapsulation.invoke(foothill, "loadCardIcons");
		ImageIcon[] icon = Deencapsulation.getField(foothill, "icon");
		Assert.assertEquals(57, icon.length);
	}

	@MethodRef(name = "turnIntIntoCardValueChar", signature = "(I)C")
	@Test
	public void testTurnIntIntoCardValueChar() throws Exception {
		int k = 0;
		char result;

		// test 1
		k = 0;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardValueChar", new Object[] { k });
		Assert.assertEquals(50, result);

		// test 2
		k = -1;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardValueChar", new Object[] { k });
		Assert.assertEquals(63, result);

		// test 3
		k = 1;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardValueChar", new Object[] { k });
		Assert.assertEquals(51, result);

		// test 4
		k = 13;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardValueChar", new Object[] { k });
		Assert.assertEquals(88, result);

		// test 5
		k = 12;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardValueChar", new Object[] { k });
		Assert.assertEquals(65, result);

		// test 6
		k = 14;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardValueChar", new Object[] { k });
		Assert.assertEquals(63, result);
	}

	@MethodRef(name = "turnIntIntoCardSuitChar", signature = "(I)C")
	@Test
	public void testTurnIntIntoCardSuitChar() throws Exception {
		int k = 0;
		char result;

		// test 1
		k = 0;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(67, result);

		// test 2
		k = -1;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(63, result);

		// test 3
		k = 1;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(68, result);

		// test 4
		k = 3;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(83, result);

		// test 5
		k = 2;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(72, result);

		// test 6
		k = 4;
		result = Deencapsulation.invoke(Foothill.class, "turnIntIntoCardSuitChar", new Object[] { k });
		Assert.assertEquals(63, result);
	}

	@MethodRef(name = "main", signature = "([QString;)V")
	@Test
	public void testMain() throws Exception {
		String[] args = new String[] { "" };

		// default test
		Foothill.main(args);
	}
}