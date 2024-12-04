package components.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ChessNotationSecondaryTest {

    private ChessNotationSecondary chessNotation;

    @Before
    public void setUp() {
        // Initialize a chess notation object for testing
        this.chessNotation = new ChessNotationSecondary() {
            // Concrete implementation for the abstract class (this could be a mock or a real implementation)
        };

        // Add some moves to the chessNotation object for testing
        String[] move1 = { "e4", "e5" };
        String[] move2 = { "Nf3", "Nc6" };
        this.chessNotation.turns.add(move1);
        this.chessNotation.turns.add(move2);
    }

    @Test
    public void testEquals() {
        // Test if the equals method works correctly
        ChessNotationSecondary otherNotation = new ChessNotationSecondary() {
            // Concrete implementation for the abstract class
        };
        String[] move1 = { "e4", "e5" };
        String[] move2 = { "Nf3", "Nc6" };
        otherNotation.turns.add(move1);
        otherNotation.turns.add(move2);

        assertTrue(this.chessNotation.equals(otherNotation)); // Should be true

        // Modify otherNotation to make them different
        String[] move3 = { "d4", "d5" };
        otherNotation.turns.add(move3);
        assertFalse(this.chessNotation.equals(otherNotation)); // Should be false
    }

    @Test
    public void testHashCode() {
        // Test if the hashCode method works correctly
        ChessNotationSecondary otherNotation = new ChessNotationSecondary() {
            // Concrete implementation for the abstract class
        };
        String[] move1 = { "e4", "e5" };
        String[] move2 = { "Nf3", "Nc6" };
        otherNotation.turns.add(move1);
        otherNotation.turns.add(move2);

        assertEquals(this.chessNotation.hashCode(), otherNotation.hashCode());
    }

    @Test
    public void testToString() {
        // Test if the toString method generates correct output
        String expectedString = "e4\n" + "e5\n" + "Nf3\n" + "Nc6\n";
        assertEquals(expectedString, this.chessNotation.toString());
    }

    @Test
    public void testDisplayGame() {
        // Test if the displayGame method displays the game correctly
        // This is just a print test, you'd usually mock or capture the output in a real-world test case
        this.chessNotation.displayGame(); // Ensure it prints correctly to the console (or validate the printed output manually)
    }

    @Test
    public void testDumpNotation() {
        // Test if the dumpNotation method works correctly
        // This is also a print test, typically checked manually
        this.chessNotation.dumpNotation(); // Ensure it prints the correct dump
    }

    @Test
    public void testCheckAmount() {
        // Test if the checkAmount method works correctly
        String[] move1 = { "e4 check", "e5" };
        String[] move2 = { "Nf3", "Nc6 check" };
        this.chessNotation.turns.clear(); // Clear existing turns
        this.chessNotation.turns.add(move1);
        this.chessNotation.turns.add(move2);

        assertEquals(2, this.chessNotation.checkAmount()); // Should return 2 for 2 checks
    }

    @Test
    public void testIterator() {
        // Test if the iterator returns moves correctly
        Iterator<String> iterator = this.chessNotation.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("e4", iterator.next());
        assertEquals("e5", iterator.next());
        assertEquals("Nf3", iterator.next());
        assertEquals("Nc6", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
