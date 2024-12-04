package components.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for ChessNotationSecondary.
 */
public class ChessNotationSecondaryTest {

    private ChessNotationSecondary chessNotation;

    /**
     * Sets up a new ChessNotation slate for each test.
     */
    @Before
    public void setUp() {
        this.chessNotation = this.createNewChessNotation();
    }

    /**
     * Creates a new ChessNotation instance for testing.
     */
    private ChessNotationSecondary createNewChessNotation() {
        return new ChessNotation1() {
            @Override
            public ChessNotation newInstance() {
                return this;
            }

            @Override
            public void clear() {
                //no-op implementation for testing
                this.turns.clear();
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
    public void testCheckAmount1NoCheck() {
        //set up test data: no "check" in moves or descriptions.
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Nf3", "Nc6" });

        //test checkAmount
        assertEquals(0, this.chessNotation.checkAmount());
    }

    /**
     * Test for checkAmount.
     */
    @Test
    public void testCheckAmount2OneCheck() {
        //set up test data: one "check".
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Qh5", "Qe7" });

        assertEquals(0, this.chessNotation.checkAmount());
    }

    /**
     * Test for checkAmount.
     */
    @Test
    public void testCheckAmount3MultipleChecks() {
        //set up test data: multiple checks in the moves and descriptions.
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Qh5", "Qe7" });
        this.chessNotation.turns.add(new String[] { "Qf7#", "Qh7+" });

        //"Qf7#" is checkmate, and "Qh7+" is a check, so count one.
        assertEquals(1, this.chessNotation.checkAmount());
    }

    /**
     * Test for checkAmount.
     */
    @Test
    public void testCheckAmount4CheckInDescription() {
        //set up test data: "check".
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Qh5", "Qe7 check" });

        //rhe second turn has "check".
        assertEquals(1, this.chessNotation.checkAmount());
    }

    /**
     * Test for checkAmount.
     */
    @Test
    public void testCheckAmount5CheckWithVariants() {
        //set up test data: "check", "++", and "+".
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Qh5", "Qe7+" });
        this.chessNotation.turns.add(new String[] { "Qh5", "Qe7++" });
        this.chessNotation.turns.add(new String[] { "Nh5 check", "Re3" });

        //3 checks, one with the word, one with a +, and a ++
        assertEquals(3, this.chessNotation.checkAmount());
    }

    /**
     * Test for dumpNotation.
     */
    @Test
    public void testDumpNotation1WithMoves() {
        //set up test data: moves
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Nf3", "Nc6" });
        this.chessNotation.turns.add(new String[] { "d3", "d6" });

        //expected output without any extra newline at the end
        String expectedOutput = "Chess Notation Dump:\n"
                + "Turn 1: White: e4 | Black: e5\n"
                + "Turn 2: White: Nf3 | Black: Nc6\n"
                + "Turn 3: White: d3 | Black: d6";

        //capturing the printed output
        final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        //call the dumpNotation method
        this.chessNotation.dumpNotation();

        //assert output matches the expected output
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    /**
     * Test for dumpNotation.
     */
    @Test
    public void testDumpNotation2TwoMoves() {
        //set up test data: moves
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Nf3", "Nc6" });

        //expected output without any extra newline at the end
        String expectedOutput = "Chess Notation Dump:\n"
                + "Turn 1: White: e4 | Black: e5\n"
                + "Turn 2: White: Nf3 | Black: Nc6";

        //capturing the printed output
        final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        //call the dumpNotation method
        this.chessNotation.dumpNotation();

        //assert output matches the expected output
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    /**
     * Test for dumpNotation.
     */
    @Test
    public void testDumpNotation3NoMoves() {
        //set up test data: moves

        //expected output without any extra newline at the end
        String expectedOutput = "Chess Notation Dump:";

        //capturing the printed output
        final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        //call the dumpNotation method
        this.chessNotation.dumpNotation();

        //assert output matches the expected output
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    /**
     * Test for dumpNotation.
     */
    @Test
    public void testDumpNotation4OneMove() {
        //set up test data: one move
        this.chessNotation.turns.add(new String[] { "e4", "e5" });

        //expected output with one move
        String expectedOutput = "Chess Notation Dump:\n"
                + "Turn 1: White: e4 | Black: e5";

        //capturing the printed output
        final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        //call the dumpNotation method
        this.chessNotation.dumpNotation();

        //assert output matches the expected output
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    /**
     * Test for dumpNotation.
     */
    @Test
    public void testDumpNotation5MoreThanThreeMoves() {
        //set up test data: more than three moves
        this.chessNotation.turns.add(new String[] { "e4", "e5" });
        this.chessNotation.turns.add(new String[] { "Nf3", "Nc6" });
        this.chessNotation.turns.add(new String[] { "d3", "d6" });
        this.chessNotation.turns.add(new String[] { "c4", "c5" });
        this.chessNotation.turns.add(new String[] { "Bc4", "Bc5" });

        //expected output with more than three moves
        String expectedOutput = "Chess Notation Dump:\n"
                + "Turn 1: White: e4 | Black: e5\n"
                + "Turn 2: White: Nf3 | Black: Nc6\n"
                + "Turn 3: White: d3 | Black: d6\n"
                + "Turn 4: White: c4 | Black: c5\n"
                + "Turn 5: White: Bc4 | Black: Bc5";

        //capturing the printed output
        final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        //call the dumpNotation method
        this.chessNotation.dumpNotation();

        //assert output matches the expected output
        assertEquals(expectedOutput, outContent.toString().trim());
    }

}
