import java.util.Random;

class Deck {

	private static final int MAX_PACKS = 6;
	private static final int NUM_CARDS_PER_PACK = 52;
	private static final int MAX_CARDS_PER_DECK = (MAX_PACKS * NUM_CARDS_PER_PACK);

	private static Card[] MasterPack;

	private Card[] cards;
	private int topCard;
	private int numCards;
	private int numPacks;

	public boolean init(int numPacks) {
		if (numPacks > MAX_PACKS || numPacks <= 0) {
			return false;
		}

		numCards = numPacks * NUM_CARDS_PER_PACK;

		cards = new Card[numCards];

		// for loop to fill numPacks
		for (int s = 0; s < numPacks; s++) {
			// for loop to fill numCards
			for (int g = 0; g < numCards; g++) {
				// transfer values from MasterPack array to cards array
				MasterPack[g] = cards[g + (NUM_CARDS_PER_PACK * s)];
			}
		}
		return true;
	}

	// numCards accessor
	public int getNumCards() {
		return numCards;
	}

	// topCard accessor
	public Card getTopCard() {
		if (numCards <= 0) {
			return new Card();
		}

		Card topCardClone = cards[numCards--];

		numCards--;

		return topCardClone;
	}

	// shuffle cards
	public void shuffle() {
		Card ShuffleClone = new Card();

		// construct new Random
		Random rn = new Random();
		for (int i = 0; i < numCards; i++) {
			// set Random range for integer 'r'
			int r = rn.nextInt(12) + 1;

			ShuffleClone = cards[i];
			cards[i] = cards[(r) % numCards];
			ShuffleClone = cards[(r) % numCards];
		}
	}

	// card accessor for returning a valid card from the cards array
	public Card inspectCard(int c) {
		if (c < 0 || c >= MAX_CARDS_PER_DECK || c > numCards - 1) {
			return new Card();
		}
		return cards[c];
	}

	public Card dealCard() {
		if (numCards <= 0) {
			return new Card();
		}
		Card dealtCard = cards[numCards--];
		return dealtCard;
	}

	// allocates a static reference deck of cards
	private static void allocateMasterPack() {

		MasterPack = new Card[NUM_CARDS_PER_PACK];

		char cardValue;
		int cc = 0; // card counter
		int ccs = 1; // card counter for irregular characters
		int ccf = 13; // value of full suit

		// reference array of suits
		Card.Suit cardSuits[] = { Card.Suit.spades, Card.Suit.diamonds, Card.Suit.hearts, Card.Suit.clubs };

		// for loop to switch between the four suits
		for (int i = 0; i < 4; i++) {

			cardValue = 2;

			while (cc < 8) {
				MasterPack[cc + (i * ccf)] = new Card(cardValue, cardSuits[i]);
				cardValue++;
				cc++;
			}
			// special assignment of irregular characters
			MasterPack[cc + ccs + (i * ccf)] = new Card('T', cardSuits[i]);
			MasterPack[cc + ccs++ + (i * ccf)] = new Card('J', cardSuits[i]);
			MasterPack[cc + ccs++ + (i * ccf)] = new Card('Q', cardSuits[i]);
			MasterPack[cc + ccs++ + (i * ccf)] = new Card('K', cardSuits[i]);
			MasterPack[cc + ccs++ + (i * ccf)] = new Card('A', cardSuits[i]);

		}
	}

	// Default Constructor
	public Deck() {

		numPacks = 1;

		if (!init(numPacks)) {
			allocateMasterPack();
		}
	}

	// Constructor Overloader
	public Deck(int numPacks) {
		if (!init(numPacks)) {
			allocateMasterPack();
		}
	}

}