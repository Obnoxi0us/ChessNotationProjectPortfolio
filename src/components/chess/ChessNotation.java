package components.chess;

/**
 * The ChessNotation interface extends ChessNotationKernel and adds additional
 * functionalities specific to displaying and analyzing chess games. It includes
 * methods to display the game, dump the notation, and calculate the number of
 * checks (including checkmate) in the game.
 */
public interface ChessNotation extends ChessNotationKernel {

    /**
     * Dumps the chess notation, providing a detailed or raw textual
     * representation of the moves and metadata for the game. This method can be
     * used for debugging or exporting the game notation.
     */
    void dumpNotation();

    /**
     * Obtains the total number of checks in the game, including checkmate. A
     * check is counted each time a player is in check, and checkmate is counted
     * as a final check that ends the game.
     *
     * @requires the game must exist and have played turns
     * @return an integer representing the total number of checks in the game
     */
    int checkAmount();
}
