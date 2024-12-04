package components.chess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract class for implementing chess notation functionality.
 */
public abstract class ChessNotationSecondary implements ChessNotation {

    //list to hold the turns of chess game (white and black moves)
    protected List<String[]> turns;

    public ChessNotationSecondary() {
        this.turns = new ArrayList<>();
    }

    /**
     * Compares 'this' object to the object for equality. Checks if both objects
     * are of the same type and if their contained move collections (or any
     * other relevant state) are equal.
     *
     * @param o
     *            The object to compare with.
     * @return true if both objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        ChessNotationSecondary that = (ChessNotationSecondary) o;

        //checks if turns are equal
        return this.turns.equals(that.turns);
    }

    /**
     * Generates a hashCode for the object based on its internal state (number
     * of turns).
     *
     * @return a hash code value.
     */
    @Override
    public int hashCode() {
        return this.turns.hashCode();
    }

    /**
     * Returns a string representation of the chess game, including moves and
     * metadata.
     *
     * @return A string representation of the entire game, moves, and metadata.
     */
    @Override
    public String toString() {
        StringBuilder gameRepresentation = new StringBuilder();

        //add all turns to the string
        Iterator<String> iterator = this.iterator();
        while (iterator.hasNext()) {
            gameRepresentation.append(iterator.next()).append("\n");
        }

        return gameRepresentation.toString();
    }

    /**
     * Dumps the chess notation, providing a detailed or raw textual
     * representation of the moves.
     */
    @Override
    public void dumpNotation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chess Notation Dump:\n");
        for (int i = 0; i < this.turns.size(); i++) {
            String[] turn = this.turns.get(i);
            sb.append("Turn ").append(i + 1).append(": ");
            sb.append("White: ").append(turn[0]).append(" | Black: ")
                    .append(turn[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    @Override
    public int checkAmount() {
        int checkCount = 0;

        // Loop through all turns
        for (String[] turn : this.turns) {
            // Print the turn as a list of two elements (move and description)
            System.out.println("Checking turn: Move: " + turn[0]
                    + ", Description: " + turn[1]);

            // Check for "check" in move or description
            if (turn[0].contains("check") || turn[0].contains("+")
                    || turn[0].contains("++") || turn[1].contains("check")
                    || turn[1].contains("+") || turn[1].contains("++")) {
                checkCount++;
            }
        }
        return checkCount;
    }

    /**
     * Custom iterator method to iterate through the turns and return individual
     * moves (as strings). Each turn is represented as an array of two strings
     * (white and black moves). The iterator will flatten the turns into
     * individual strings (white and black moves).
     *
     * @return an iterator for the moves in the game.
     */
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int turnIndex = 0;
            private int moveIndex = 0;

            @Override
            public boolean hasNext() {
                return this.turnIndex < ChessNotationSecondary.this.turns.size()
                        && (this.moveIndex < 2
                                || this.turnIndex < +ChessNotationSecondary.this.turns
                                        .size() - 1);
            }

            @Override
            public String next() {
                String move = ChessNotationSecondary.this.turns
                        .get(this.turnIndex)[this.moveIndex];
                this.moveIndex++;
                if (this.moveIndex == 2) {
                    this.moveIndex = 0;
                    this.turnIndex++;
                }
                return move;
            }
        };
    }
}
