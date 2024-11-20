import java.util.Iterator;

/**
 *
 */
public abstract class ChessNotationSecondary implements ChessNotation {
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
        //if the objects are the same instance
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof ChessNotation)) {
            return false;
        }

        //create iterators for both collections
        Iterator<String> it1 = this.moves.iterator();
        Iterator<String> it2 = other.moves.iterator();

        //compare elements
        while (it1.hasNext() && it2.hasNext()) {
            String x1 = it1.next();
            String x2 = it2.next();

            //use equals method to compare the move strings
            if (!x1.equals(x2)) {
                return false;
            }
        }

        return true;
    }

}
