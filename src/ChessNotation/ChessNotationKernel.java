/**
 * The ChessNotationKernel interface defines the operations for managing and
 * manipulating a chess game's move notation and metadata. It supports adding
 * and removing turns, querying the total number of turns, and managing
 * additional metadata associated with the game.
 *
 * This interface is designed to be implemented by classes that track the game's
 * progress through chess notations and metadata, allowing for modifications,
 * retrieval, and manipulation of the game's moves and associated information.
 *
 * This interface ensure the chess game's notation, maintaining valid indexing
 * for turns and ensuring correct metadata.
 *
 * This interface extends Iterable<ChessNotation>, allowing for easy iteration
 * through the game's recorded notations.
 */
public interface ChessNotationKernel extends Iterable<ChessNotation> {
    /**
     * Adds a chess turn to the notation.
     *
     * @requires x >= 0 && x <= numberOfTurns(), whiteMove != null &&
     *           !whiteMove.isEmpty(), blackMove != null &&
     *           !blackMove.isEmpty().
     * @param x
     *            the index at which the turn should be added (starts at 1)
     * @param whiteMove
     *            the notation for the white player's move.
     * @param blackMove
     *            the notation for the black player's move.
     * @updates the list of turns in a game, adds a new turn at index x.
     */
    void addTurn(int x, String whiteMove, String blackMove);

    /**
     * Removes a turn from the notation at the specified index.
     *
     * @requires i >= 0 && i < numberOfTurns().
     * @param i
     *            the index of the turn to remove.
     * @updates the list of turns, removes the turn at index i. shifting all
     *          subsequent turns up by one index.
     */
    void removeTurn(int i);

    /**
     * Returns the total number of turns in the chess game.
     *
     * @ensures the return value is always >= 0.
     * @return an int of how many turns were played in the game.
     */
    int numberOfTurns();

    /**
     * Adds metadata to the chess notation.
     *
     * @requires key != null && !key.isEmpty(), value != null &&
     *           !value.isEmpty().
     * @param key
     *            the metadata key (e.g., "gameId", "event").
     * @param value
     *            value the metadata value associated with the key (e.g.,
     *            "12345", "World Championship").
     * @updates the metadata map (or data structure used to store metadata).
     * @ensures adds the metadata with the provided key-value pair.
     */
    void addMetadata(String key, String value);

    /**
     * Removes metadata with the specified key.
     *
     * @requires key != null && !key.isEmpty().
     * @param key
     *            the key of the metadata to remove.
     * @updates removes Metadata from game.
     * @return the value associated with the key, or null if no such metadata
     *         existed.
     */
    String removeMetadata(String key);

    /**
     * Checks if metadata with the specified key exists.
     *
     * @requires key != null && !key.isEmpty().
     * @param key
     *            the key to check for existence in the metadata.
     * @return true if the metadata with the given key exists, false otherwise.
     * @ensures the return value is true if the key is found in the metadata,
     *          otherwise false.
     */
    boolean hasMetadata(String key);
}
