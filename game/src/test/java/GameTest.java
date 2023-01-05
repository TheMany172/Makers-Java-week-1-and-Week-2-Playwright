package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class GameTest {

    @Test
    public void testremainint_attempts() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");
        game.Game game1 = new Game(mockedChooser);
        assertEquals(10, Integer.valueOf(game1.getRemainingAttempts()));
    }










    //    @Test
//    void testGetsWordToGuess() {
//        game.Game game = new game.Game();
//        assertEquals(game.getWordToGuess(), "B_____");
//    }
//    @Test
//    public void testGetsWordToGuess() {
//        game.Game game = new game.Game("MAKERS");
//        assertEquals("M_____", game.getWordToGuess());
//    }
//

    // NEXT 5 TESTS MOVED TO MASKER


//    @Test
//    public void testGetsWordToGuessWithRandomWord() {
//        WordChooser mockedChooser = mock(WordChooser.class);
//        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");
//
//        game.Game game = new Game(mockedChooser);
//        mockedChooser.getRandomWordFromDictionary();
//
//        assertEquals("D________", game.getWordToGuess());
//    }
//    @Test public void testGuessLetterRightAndDisplayGuessedLetter() {
//        WordChooser mockedChooser = mock(WordChooser.class);
//        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
//
//        Game game = new Game(mockedChooser);
//
//        assertEquals(true, game.guessLetter('K'));
//    }
//
//    @Test public void testGuessLetterWrong() {
//        WordChooser mockedChooser = mock(WordChooser.class);
//        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
//
//        Game game = new Game(mockedChooser);
//        game.guessLetter('B');
//        assertEquals(false, game.guessLetter('Z'));
//        assertEquals(8, Integer.valueOf(game.getRemainingAttempts()));
//    }
//
//    @Test public void testGuessLetterRightAndDisplayGuessedLetter_updated() {
//        WordChooser mockedChooser = mock(WordChooser.class);
//        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
//
//        Game game = new Game(mockedChooser);
//
//        assertEquals(game.guessLetter('K'), true);
//        assertEquals("M_K___", game.getWordToGuess());
//    }
//
//    @Test public void testGuessLetterWrong_updated() {
//        WordChooser mockedChooser = mock(WordChooser.class);
//        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
//
//        Game game = new Game(mockedChooser);
//
//        assertEquals(game.guessLetter('O'), false);
//        assertEquals("M_____", game.getWordToGuess());
//    }

// END OF MOVED TO MASKER



//    @Test public void correct_guesses_stored() {
//        WordChooser mockedChooser = mock(WordChooser.class);
//        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
//
//        Game game = new Game(mockedChooser);
//        game.guessLetter('M');
//        game.guessLetter('A');
//        System.out.println(game.guessedLetters);
//    }


}