package components.chess;

import org.junit.Test;

/**
 * JUnit test cases for ChessNotationSecondary.
 */
public class ChessNotationSecondaryTest {

    /**
     * Creates brand new ChessNotation slate for testing.
     *
     * @return correct assertEquals with correct logic / correctness.
     */
    private ChessNotationSecondary createNewChessNotation() {
        return new ChessNotation1() {
            @Override
            public ChessNotation newInstance() {
                return null; //new implementation for testing
            }

            @Override
            public void clear() {
                //no-op implementation for testing
            }

            @Override
            public void transferFrom(ChessNotation chessNotation) {
                //no-op implementation for testing
            }
        };
    }

    /**
     * Test for checkAmount.
     */
    @Test
    public void testCheckAmount1() {

    }
}