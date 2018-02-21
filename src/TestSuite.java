import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ CardTableTest.class, GUICardTest.class, HandTest.class, DeckTest.class, CardTest.class, IntegrationTests.class})
public class TestSuite { // nothing
}