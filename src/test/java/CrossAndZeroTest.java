import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CrossAndZeroTest {
    private static long suitStartTime;
    private long testStartTime;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Start testing");
        suitStartTime = System.nanoTime();
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Start of the current test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Current test completed in " + (System.nanoTime() - testStartTime));
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test suite completed in " + (System.nanoTime() - suitStartTime));
    }

    @ParameterizedTest
    @ValueSource (chars = {CrossAndZero.CROSS, CrossAndZero.ZERO})
    public void testInWin_false(char player) {
        char[][] field = CrossAndZero.createEmptyField();
        Assertions.assertFalse(CrossAndZero.isWin(field, player));
    }

    @ParameterizedTest
    @ValueSource (chars = {CrossAndZero.CROSS, CrossAndZero.ZERO})
    public void testInWin_trueForFirstDiagonal(char player) {
        char[][] field = CrossAndZero.createEmptyField();
        for (int i = 0; i < CrossAndZero.SIZE; i++) {
            field[i][i] = player;
        }
        Assertions.assertTrue(CrossAndZero.isWin(field, player));
    }

    @ParameterizedTest
    @ValueSource (chars = {CrossAndZero.CROSS, CrossAndZero.ZERO})
    public void testInWin_trueForSecondDiagonal(char player) {
        int size = CrossAndZero.SIZE;
        char[][] field = CrossAndZero.createEmptyField();
        for (int i = 0; i < size; i++) {
            field[i][size - 1 - i] = player;
        }
        Assertions.assertTrue(CrossAndZero.isWin(field, player));
    }

    @ParameterizedTest
    @ValueSource (chars = {CrossAndZero.CROSS, CrossAndZero.ZERO})
    public void testInWin_trueForLine(char player) {
        char[][] field = CrossAndZero.createEmptyField();
        for (int i = 0; i < CrossAndZero.SIZE; i++) {
            field[0][i] = player;
        }
        Assertions.assertTrue(CrossAndZero.isWin(field, player));
    }

//    @ParameterizedTest
//    @ValueSource (chars = {CrossAndZero.CROSS, CrossAndZero.ZERO})
//    public void testInWin_trueForColumn(char player) {
//        char[][] field = CrossAndZero.createEmptyField();
//        for (int i = 0; i < CrossAndZero.SIZE; i++) {
//            field[i][2] = player;
//        }
//        Assertions.assertTrue(CrossAndZero.isWin(field, player));
//    }

    @Test
    public void testInWin_trueForCrossColumn() {
        char[][] field = CrossAndZero.createEmptyField();
        for (int i = 0; i < CrossAndZero.SIZE; i++) {
            field[i][2] = CrossAndZero.CROSS;
        }
        assertThat(CrossAndZero.isWin(field, CrossAndZero.CROSS), is(equalTo(true)));
    }

    @Test
    public void testInWin_trueForZeroColumn() {
        char[][] field = CrossAndZero.createEmptyField();
        for (int i = 0; i < CrossAndZero.SIZE; i++) {
            field[i][2] = CrossAndZero.ZERO;
        }
        assertThat(CrossAndZero.isWin(field, CrossAndZero.ZERO), is(equalTo(true)));
    }

}
