
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.annotation.Generated;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

//import Card.Suit;

@Generated(value = "org.junit-tools-1.0.6")
public class IntegrationTests {

	private static final int MAX_HANDS = 10;
	@Generated(value = "org.junit-tools-1.0.6")
	private Logger logger = Logger.getLogger(IntegrationTests.class.toString());
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream sysOutStream = System.out;

//	@Before
//	public void setUp() throws Exception {
//		System.setOut(new PrintStream(outContent));
//		System.setErr(new PrintStream(errContent));
//
//	}
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		System.setOut(sysOutStream);
//		System.out.println("outContent:");
//		System.out.println(outContent);
//
//		System.setErr(sysOutStream);
//		System.out.println("errContent:");
//		System.out.println(errContent);
//
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//
//	}
	   static int NUM_CARDS_PER_HAND = 7;
	   static int NUM_PLAYERS = 2;
	   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
	   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
	   static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
	   static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

	/**
	 * Run all the code that would be in main methods for A1 and A2
	 * 
	 * @throws Exception
	 */
	@MethodRef(name = "main", signature = "([QString;)V")
	@Test
	public void testMain() throws Exception {
	      int k;
	      ImageIcon tempIcon;

	      // establish main frame in which program will run
	      CardTable myCardTable = new CardTable("CS 1B CardTable",
	         NUM_CARDS_PER_HAND, NUM_PLAYERS);
	      myCardTable.setName("CS 1B CardTable");
	      myCardTable.setSize(800, 600);
	      myCardTable.setLocationRelativeTo(null);
	      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // show everything to the user
	      myCardTable.setVisible(true);

	      // CREATE LABELS ----------------------------------------------------
	      // prepare the human player label array (bottom region)
	      for (k = 0; k < myCardTable.getNumCardsPerHand(); k++)
	      {
	         tempIcon = (ImageIcon) GUICard.getIcon(generateRandomCard());
	         humanLabels[k] = new JLabel(tempIcon);
	      }

	      // prepare the computer label array (all card backs, top region)
	      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
	         computerLabels[k] = new JLabel(
	            GUICard.getBackCardIcon());

	      // prepare the played-card label array with jokers
	      for (k = 0; k < NUM_PLAYERS; k++)
	      {
	         tempIcon = (ImageIcon) GUICard.getIcon(
	            new Card('X', Card.Suit.clubs)
	            );
	         playedCardLabels[k] = new JLabel(tempIcon);
	      }

	      // prepare the played text labels
	      playLabelText[0] = new JLabel("Computer", JLabel.CENTER);
	      playLabelText[1] = new JLabel("You", JLabel.CENTER);

	      // ADD LABELS TO PANELS -----------------------------------------
	      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
	         myCardTable.panelComputerHand.add(computerLabels[k]);
	      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
	         myCardTable.panelPlayerHand.add(humanLabels[k]);

	      // and two random cards in the play region (simulating a computer/hum ply)
	      for (k = 0; k < NUM_PLAYERS; k++)
	         myCardTable.panelTable.add(playedCardLabels[k]);
	      for (k = 0; k < NUM_PLAYERS; k++)
	         myCardTable.panelTable.add(playLabelText[k]);

	      // show everything to the user
	      myCardTable.setVisible(true);
	   }

	   // "global" static Foothill methods
	   static Card generateRandomCard()
	   {
	      Card.Suit suit;
	      char val;

	      int suitSelector, valSelector;

	      // get random suit and value
	      suitSelector = (int) (Math.random() * 4);
	      valSelector = (int) (Math.random() * 13);

	      // pick suit
	      suit = GUICard.turnIntIntoCardSuit(suitSelector);
	      val = GUICard.turnIntIntoCardValueChar(valSelector);

	      return new Card(val, suit);
	   }
}