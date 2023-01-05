import game.WordChooser;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.*;


public class WordChooserTest {
    @Test
    public void testDICTIONARYexists() {
        WordChooser chooser1 = new game.WordChooser();
        String[] MOCK_DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

        assertTrue(Arrays.asList(MOCK_DICTIONARY).contains(chooser1.getRandomWordFromDictionary()));
    }

//    @Test
//    public void testremainint_attempts() {
//        game.Game game = new game.Game("MAKERS");
//        assertEquals(10, Integer.valueOf(game.getRemainingAttempts()));
//    }
}
