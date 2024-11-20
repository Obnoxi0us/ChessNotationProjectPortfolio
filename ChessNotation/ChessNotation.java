/**
 *
 */
public interface ChessNotation extends ChessNotationKernel {

    /**
     * Obtain the amount of checks were in the game (including checkmate).
     *
     * @requires game existence
     * @return int of amount of checks in chessgame (including checkmate).
     * 
     * Contract for secondary
     */
    int checkAmount();
}
