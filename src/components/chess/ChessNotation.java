package components.chess;

/**
 *
 */
public interface ChessNotation extends ChessNotationKernel {
    void displayGame();

    void dumpNotation();

    /**
     * Obtain the amount of checks were in the game (including checkmate).
     *
     * @requires game existence
     * @return int of amount of checks in chessgame (including checkmate).
     */
    int checkAmount();
}
