import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ChessNotation}'s addTurn method.
 *
 * Note: Replace "ChessNotationImpl" with the specific implementation being
 * tested.
 *
 * @author Othon DeAssis
 *
 */
public class ChessNotationTest {

    /**
     * Invokes the appropriate {@code ChessNotation} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new chess notation instance
     */
    protected ChessNotation constructorTest() {
        return new ChessNotationImpl();
    }

    /**
     * Test case for {@code addTurn} when the notation is empty.
     */
    @Test
    public void testAddTurnEmptyNotation() {
        // Arrange
        ChessNotation chess = this.constructorTest();

        // Act
        chess.addTurn("e4", "e5");

        // Assert
        assertEquals("1. e4 e5", chess.toString());
    }

    /**
     * Test case for {@code addTurn} when the notation contains one turn.
     */
    @Test
    public void testAddTurnOneTurn() {
        // Arrange
        ChessNotation chess = this.constructorTest();
        chess.addTurn("e4", "e5");

        // Act
        chess.addTurn("Nf3", "Nc6");

        // Assert
        assertEquals("1. e4 e5 2. Nf3 Nc6", chess.toString());
    }

    /**
     * Test case for {@code addTurn} with an incomplete previous turn (white
     * only).
     */
    @Test
    public void testAddTurnIncompletePreviousTurn() {
        // Arrange
        ChessNotation chess = this.constructorTest();
        chess.addTurn("e4", "");

        // Act
        chess.addTurn("Nf3", "Nc6");

        // Assert
        assertEquals("1. e4 -- 2. Nf3 Nc6", chess.toString());
    }

    /**
     * Test case for {@code addTurn} with special moves (castling).
     */
    @Test
    public void testAddTurnCastling() {
        // Arrange
        ChessNotation chess = this.constructorTest();
        chess.addTurn("e4", "e5");

        // Act
        chess.addTurn("O-O", "O-O");

        // Assert
        assertEquals("1. e4 e5 2. O-O O-O", chess.toString());
    }

    /**
     * Test case for {@code addTurn} when both moves are missing.
     */
    @Test
    public void testAddTurnBothMovesMissing() {
        // Arrange
        ChessNotation chess = this.constructorTest();

        // Act
        chess.addTurn("", "");

        // Assert
        assertEquals("1. -- --", chess.toString());
    }
}
