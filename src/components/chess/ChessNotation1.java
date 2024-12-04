package components.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Implementation of the ChessNotation1 class.
 */
public abstract class ChessNotation1 extends ChessNotationSecondary {

    /*
     * Internal storage for chess turns.
     */
    private final List<String[]> turns;

    /*
     * Internal storage for metadata.
     */
    private final Map<String, String> metadata;

    /*
     * Constructor to initialize the internal structures.
     */
    protected ChessNotation1() {
        this.turns = new ArrayList<>();
        this.metadata = new HashMap<>();
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    @Override
    public void addTurn(int x, String whiteMove, String blackMove) {
        //check preconditions
        if (x < 0 || x > this.turns.size()) {
            throw new IndexOutOfBoundsException("Index x out of bounds");
        }
        if (whiteMove == null || whiteMove.isEmpty() || blackMove == null
                || blackMove.isEmpty()) {
            throw new IllegalArgumentException(
                    "Move notation cannot be null or empty");
        }

        //add the turn at the specified index
        this.turns.add(x, new String[] { whiteMove, blackMove });
    }

    @Override
    public int numberOfTurns() {
        //returns the number of turns played
        return this.turns.size();
    }

    @Override
    public void removeTurn(int i) {
        //checks if the index is valid
        if (i < 0 || i >= this.turns.size()) {
            throw new IndexOutOfBoundsException("Invalid turn index");
        }

        //removes the turn at i
        this.turns.remove(i);
    }

    @Override
    public void addMetadata(String key, String value) {
        //checks the preconditions
        if (key == null || key.isEmpty() || value == null || value.isEmpty()) {
            throw new IllegalArgumentException(
                    "Key and value must not be null or empty");
        }

        //adds metadata to the map
        this.metadata.put(key, value);
    }

    @Override
    public String removeMetadata(String key) {
        //checks the precondition
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key must not be null or empty");
        }

        //removes and returns the value from the key or null if it doesn't exist
        return this.metadata.remove(key);
    }

    @Override
    public boolean hasMetadata(String key) {
        //checks the precondition
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key must not be null or empty");
        }

        //returns true or false if the key exists in the metadata map
        return this.metadata.containsKey(key);
    }
}