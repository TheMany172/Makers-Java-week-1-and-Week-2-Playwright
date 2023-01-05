package game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MaskerTest {
    @Test
    public void testGetsMaskedWord() {
        Masker masker = new Masker();
        ArrayList<Character> guessedLetters = new ArrayList<>();
        guessedLetters.add('E');
        guessedLetters.add('V');

        assertEquals("DEVE___E_", masker.getMaskedWord("DEVELOPER", guessedLetters));
    }

    @Test
    public void MockedMaskerTest() {
        Masker mockedmasker1 = new Masker();

        ArrayList<Character> guessedLetters = new ArrayList<>();
        guessedLetters.add('E');
        String word_to_guess = "DEVELOPER";
//
        assertEquals("DE_E___E_", mockedmasker1.getMaskedWord(word_to_guess, guessedLetters));
    }

    @Test
    public void testGetsWordToGuessWithRandomWord() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

        game.Game game = new Game(mockedChooser);
        mockedChooser.getRandomWordFromDictionary();

        assertEquals("D________", game.getWordToGuess());
    }
    @Test public void testGuessLetterRightAndDisplayGuessedLetter() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);

        assertEquals(true, game.guessLetter('K'));
    }

    @Test public void testGuessLetterWrong() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);
        game.guessLetter('B');
        assertEquals(false, game.guessLetter('Z'));
        assertEquals(8, Integer.valueOf(game.getRemainingAttempts()));
    }

    @Test public void testGuessLetterRightAndDisplayGuessedLetter_updated() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);

        assertEquals(game.guessLetter('K'), true);
        assertEquals("M_K___", game.getWordToGuess());
    }

    @Test public void testGuessLetterWrong_updated() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);

        assertEquals(game.guessLetter('O'), false);
        assertEquals("M_____", game.getWordToGuess());
    }
}