package components.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test cases for ChessNotationKernel.
 */
public class ChessNotationKernelTest {

    /**
     * Creates brand new ChessNotation slate for testing.
     *
     * @return correct assertEquals with correct logic / correctness.
     */
    private ChessNotation1 createNewChessNotation() {
        return new ChessNotation1() {
            @Override
            public ChessNotation newInstance() {
                return null; //new implementation for testing
            }

            @Override
            public void clear() {
                //no-op implementation for testin
            }

            @Override
            public void transferFrom(ChessNotation chessNotation) {
                //no-op implementation for testing
            }
        };
    }

    /**
     * Test for addTurn.
     */
    @Test
    public void testAddTurn1OneTurnAdded() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //test adding valid turns
        chessNotation.addTurn(0, "e4", "e5");
        assertEquals(1, chessNotation.numberOfTurns()); //one turn should be added
    }

    /**
     * Test for addTurn.
     */
    @Test
    public void testAddTurn2TwoTurnsAdded() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //test adding valid turns
        chessNotation.addTurn(0, "e4", "e5");
        assertEquals(1, chessNotation.numberOfTurns()); //one turn should be added

        chessNotation.addTurn(1, "Nf3", "Nc6");
        assertEquals(2, chessNotation.numberOfTurns()); //two turns should be added
    }

    /**
     * Test for addTurn.
     */
    @Test
    public void testAddTurn3MultipleTurnsAdded() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //test adding multiple turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        chessNotation.addTurn(2, "Bb5", "a6");

        //check if the number of turns is 3
        assertEquals(3, chessNotation.numberOfTurns()); //three turns should be added
    }

    /**
     * Test for addTurn.
     */
    @Test
    public void testAddTurn4AddTurnAtIndex1() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //test adding valid turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");

        assertEquals(2, chessNotation.numberOfTurns()); //two turns should be added

        //now add a turn at index 1, this will shift the second turn to index 2
        chessNotation.addTurn(1, "Bb5", "a6");

        assertEquals(3, chessNotation.numberOfTurns()); //three turns should be added
    }

    /**
     * Test for addTurn.
     */
    @Test
    public void testAddTurn5RemoveTurn() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //test adding valid turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");

        assertEquals(2, chessNotation.numberOfTurns()); //two turns should be added

        //remove the first turn
        chessNotation.removeTurn(0);
        assertEquals(1, chessNotation.numberOfTurns()); //one turn should remain

        //remove the last remaining turn
        chessNotation.removeTurn(0);
        assertEquals(0, chessNotation.numberOfTurns()); //no turns should remain
    }

    /**
     * Test for addTurn.
     */
    @Test
    public void testRemoveTurn1BasicCase() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add turns first
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        chessNotation.addTurn(2, "Bb5", "a6");
        assertEquals(3, chessNotation.numberOfTurns()); //there should be 3 turns

        //remove the second turn (index 1)
        chessNotation.removeTurn(1);
        assertEquals(2, chessNotation.numberOfTurns()); //now there should be 2 turns

    }

    /**
     * Test for removeTurn.
     */
    @Test
    public void testRemoveTurn2EmptyList() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //the number of turns should be 0
        assertEquals(0, chessNotation.numberOfTurns());

        //try removing a turn from an empty list
        try {
            chessNotation.removeTurn(0);
            fail("Expected exception for removing from empty list");
        } catch (IndexOutOfBoundsException e) {
            //expected exception, test should pass
        }

        //verify the number of turns is still 0
        assertEquals(0, chessNotation.numberOfTurns());
    }

    /**
     * Test for removeTurn.
     */
    @Test
    public void testRemoveTurn3Index0() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add three turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        chessNotation.addTurn(2, "Bb5", "a6");
        assertEquals(3, chessNotation.numberOfTurns()); //should be 3 turns

        //remove the first turn (index 0)
        chessNotation.removeTurn(0);
        assertEquals(2, chessNotation.numberOfTurns()); //now there should be 2 turns
    }

    /**
     * Test for removeTurn.
     */
    @Test
    public void testRemoveTurn4LastIndex() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add three turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        chessNotation.addTurn(2, "Bb5", "a6");
        assertEquals(3, chessNotation.numberOfTurns()); //should be 3 turns

        //remove the last turn (index 2)
        chessNotation.removeTurn(2);
        assertEquals(2, chessNotation.numberOfTurns()); //now there should be 2 turns
    }

    /**
     * Test for removeTurn.
     */
    @Test
    public void testRemoveTurn5InvalidIndex() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add two turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        assertEquals(2, chessNotation.numberOfTurns()); //should be 2 turns

        //try removing a turn with an invalid index (greater than the number of turns)
        try {
            chessNotation.removeTurn(5);
            fail("Expected exception for invalid index");
        } catch (IndexOutOfBoundsException e) {
            //expected exception, test should pass
        }

        //verify the number of turns is still 2
        assertEquals(2, chessNotation.numberOfTurns());
    }

    /**
     * Test for numberOfTurns.
     */
    @Test
    public void testNumberOfTurns1BasicCase() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //the number of turns should be 0
        assertEquals(0, chessNotation.numberOfTurns());

        //add turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        chessNotation.addTurn(2, "Bb5", "a6");

        //verify the number of turns is 3
        assertEquals(3, chessNotation.numberOfTurns());

        //remove one turn
        chessNotation.removeTurn(1);

        //verify the number of turns is now 2
        assertEquals(2, chessNotation.numberOfTurns());
    }

    /**
     * Test for numberOfTurns.
     */
    @Test
    public void testNumberOfTurns2NoTurns() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //the number of turns should be 0
        assertEquals(0, chessNotation.numberOfTurns());
    }

    /**
     * Test for numberOfTurns.
     */
    @Test
    public void testNumberOfTurns3OneTurn() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //the number of turns should be 0 initially
        assertEquals(0, chessNotation.numberOfTurns());

        //add one turn
        chessNotation.addTurn(0, "e4", "e5");

        //verify the number of turns is 1
        assertEquals(1, chessNotation.numberOfTurns());
    }

    /**
     * Test for numberOfTurns.
     */
    @Test
    public void testNumberOfTurns4AddRemoveMultipleTurns() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //the number of turns should be 0 initially
        assertEquals(0, chessNotation.numberOfTurns());

        //add three turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");
        chessNotation.addTurn(2, "Bb5", "a6");

        //verify the number of turns is 3
        assertEquals(3, chessNotation.numberOfTurns());

        //remove all turns
        chessNotation.removeTurn(0);
        chessNotation.removeTurn(0);
        chessNotation.removeTurn(0);

        //verify the number of turns is now 0
        assertEquals(0, chessNotation.numberOfTurns());
    }

    /**
     * Test for numberOfTurns.
     */
    @Test
    public void testNumberOfTurns5RemoveInvalidIndex() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //the number of turns should be 0 initially
        assertEquals(0, chessNotation.numberOfTurns());

        //add two turns
        chessNotation.addTurn(0, "e4", "e5");
        chessNotation.addTurn(1, "Nf3", "Nc6");

        //verify the number of turns is 2
        assertEquals(2, chessNotation.numberOfTurns());

        //attempt to remove a turn with an index greater than the number of turns
        try {
            chessNotation.removeTurn(5);
            fail("Expected exception for invalid index");
        } catch (IndexOutOfBoundsException e) {
            //expected exception, test should pass
        }

        //verify the number of turns is still 2
        assertEquals(2, chessNotation.numberOfTurns());
    }

    /**
     * Test for addMetadata.
     */
    @Test
    public void testAddMetadata1SingleEntry() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add a single metadata entry
        chessNotation.addMetadata("gameId", "12345");

        //verify the metadata has been added
        assertEquals("12345", chessNotation.getMetadata().get("gameId"));
    }

    /**
     * Test for addMetadata.
     */
    @Test
    public void testAddMetadata2TwoDataEntries() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");

        //check if metadata has been added correctly
        assertEquals("12345", chessNotation.getMetadata().get("gameId"));
        assertEquals("World Championship",
                chessNotation.getMetadata().get("event"));
    }

    /**
     * Test for addMetadata.
     */
    @Test
    public void testAddMetadata3Overwrite() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata entry
        chessNotation.addMetadata("gameId", "12345");

        //add a new value for the same key (should overwrite)
        chessNotation.addMetadata("gameId", "67890");

        //verify that the new value has overwritten the old one
        assertEquals("67890", chessNotation.getMetadata().get("gameId"));
    }

    /**
     * Test for addMetadata.
     */
    @Test
    public void testAddMetadata4MultipleEntries() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add multiple metadata entries
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");
        chessNotation.addMetadata("date", "2024-12-04");

        //verify that all metadata entries were added correctly
        assertEquals("12345", chessNotation.getMetadata().get("gameId"));
        assertEquals("World Championship",
                chessNotation.getMetadata().get("event"));
        assertEquals("2024-12-04", chessNotation.getMetadata().get("date"));
    }

    /**
     * Test for addMetadata.
     */
    @Test
    public void testAddMetadata5ValidKeyValue() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add valid metadata
        chessNotation.addMetadata("player1", "Magnus Carlsen");
        chessNotation.addMetadata("player2", "Hikaru Nakamura");

        //verify that the metadata has been added correctly
        assertEquals("Magnus Carlsen",
                chessNotation.getMetadata().get("player1"));
        assertEquals("Hikaru Nakamura",
                chessNotation.getMetadata().get("player2"));
    }

    /**
     * Test for removeMetadata.
     */
    @Test
    public void testRemoveMetadata1BasicCase() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");

        //verify metadata has been added
        assertEquals("12345", chessNotation.getMetadata().get("gameId"));
        assertEquals("World Championship",
                chessNotation.getMetadata().get("event"));

        //remove the "gameId" metadata
        chessNotation.removeMetadata("gameId");

        //check if "gameId" has been removed
        assertEquals(null, chessNotation.getMetadata().get("gameId"));

        //check that "event" still exists
        assertEquals("World Championship",
                chessNotation.getMetadata().get("event"));
    }

    /**
     * Test for removeMetadata.
     */
    @Test
    public void testRemoveMetadata2Nonexistent() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");

        //try to remove non-existent metadata
        chessNotation.removeMetadata("event");

        //verify that "gameId" still exists
        assertEquals("12345", chessNotation.getMetadata().get("gameId"));

        //ensure no changes for non-existent key
        assertEquals(null, chessNotation.getMetadata().get("event"));
    }

    /**
     * Test for removeMetadata.
     */
    @Test
    public void testRemoveMetadata3All() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add multiple metadata entries
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");

        // remove all metadata
        chessNotation.removeMetadata("gameId");
        chessNotation.removeMetadata("event");

        //check that both keys are removed
        assertEquals(null, chessNotation.getMetadata().get("gameId"));
        assertEquals(null, chessNotation.getMetadata().get("event"));
    }

    /**
     * Test for removeMetadata.
     */
    @Test
    public void testRemoveMetadata4AfterClear() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");

        //clear metadata
        chessNotation.clear();

        //try removing metadata after clear
        chessNotation.removeMetadata("gameId");

        //verify that "gameId" is still removed (since it's cleared)
        assertEquals(null, chessNotation.getMetadata().get("gameId"));
    }

    /**
     * Test for removeMetadata.
     */
    @Test
    public void testRemoveMetadata5FromEmptyMap() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //remove metadata when there is no metadata
        chessNotation.removeMetadata("nonExistentKey");

        //ensure no metadata exists
        assertEquals(null, chessNotation.getMetadata().get("nonExistentKey"));
    }

    /**
     * Test for hasMetadata.
     */
    @Test
    public void testHasMetadata1AddMetadata() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");

        //check if metadata exists
        assertTrue(chessNotation.hasMetadata("gameId")); //return true
        assertTrue(chessNotation.hasMetadata("event")); //return true
    }

    /**
     * Test for hasMetadata.
     */
    @Test
    public void testHasMetadata2NonExistentKey() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");

        //check for a non-existent key
        assertFalse(chessNotation.hasMetadata("nonExistentKey")); //should return false
    }

    /**
     * Test for hasMetadata.
     */
    @Test
    public void testHasMetadata3EmptyCase() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //ensure metadata is empty
        assertFalse(chessNotation.hasMetadata("gameId")); //should return false
        assertFalse(chessNotation.hasMetadata("event")); //should return false
    }

    /**
     * Test for hasMetadata.
     */
    @Test
    public void testHasMetadata4CaseSensitivity() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");

        //check for the key with different case
        assertFalse(chessNotation.hasMetadata("GameId")); //return false
    }

    /**
     * Test for hasMetadata.
     */
    @Test
    public void testHasMetadata5AfterRemove() {
        ChessNotation1 chessNotation = this.createNewChessNotation();

        //add metadata
        chessNotation.addMetadata("gameId", "12345");
        chessNotation.addMetadata("event", "World Championship");

        //remove metadata
        chessNotation.removeMetadata("gameId");

        //check if the removed metadata still exists
        assertFalse(chessNotation.hasMetadata("gameId")); //should return false
        assertTrue(chessNotation.hasMetadata("event")); //should return true
    }
}
