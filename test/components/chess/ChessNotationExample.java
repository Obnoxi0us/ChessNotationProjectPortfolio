package components.chess;

import java.util.Scanner;

/**
 * An example of ChessNotation components in real use.
 */
public class ChessNotationExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //creates instance of a concrete subclass of ChessNotation1.
        ChessNotation1 game = new ChessNotation1() {
            @Override
            public void addTurn(int x, String whiteMove, String blackMove) {
                super.addTurn(x, whiteMove, blackMove);
            }

            @Override
            public int numberOfTurns() {
                return super.numberOfTurns();
            }

            @Override
            public void removeTurn(int i) {
                super.removeTurn(i);
            }

            @Override
            public void addMetadata(String key, String value) {
                super.addMetadata(key, value);
            }

            @Override
            public String removeMetadata(String key) {
                return super.removeMetadata(key);
            }

            @Override
            public boolean hasMetadata(String key) {
                return super.hasMetadata(key);
            }

            @Override
            public ChessNotation newInstance() {
                //creates and return a new instance of ChessNotation1
                return new ChessNotation1() {
                    @Override
                    public ChessNotation newInstance() {
                        return null; //new implementation for testing
                    }

                    @Override
                    public void addTurn(int x, String whiteMove,
                            String blackMove) {
                        super.addTurn(x, whiteMove, blackMove);
                    }

                    @Override
                    public int numberOfTurns() {
                        return super.numberOfTurns();
                    }

                    @Override
                    public void removeTurn(int i) {
                        super.removeTurn(i);
                    }

                    @Override
                    public void addMetadata(String key, String value) {
                        super.addMetadata(key, value);
                    }

                    @Override
                    public String removeMetadata(String key) {
                        return super.removeMetadata(key);
                    }

                    @Override
                    public boolean hasMetadata(String key) {
                        return super.hasMetadata(key);
                    }

                    @Override
                    public void clear() {
                        //no-op implementation for testing
                    }

                    @Override
                    public void transferFrom(ChessNotation chessNotation) {
                        //no-op implementation for testing
                    }
                };
            }

            @Override
            public void clear() {
                //concrete implementation if needed
            }

            @Override
            public void transferFrom(ChessNotation chessNotation) {
                //concrete implementation if needed
            }

            @Override
            public void dumpNotation() {
                if (this.turns.isEmpty()) {
                    System.out.println("No moves recorded yet.");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Chess Notation Dump:\n");
                for (int i = 0; i < this.turns.size(); i++) {
                    String[] turn = this.turns.get(i);
                    sb.append("Turn ").append(i + 1).append(": ");
                    sb.append("White: ").append(turn[0]).append(" | Black: ")
                            .append(turn[1]).append("\n");
                }
                sb.append("\n"); //adding the newline at the end
                System.out.println(sb.toString());
            }
        };

        //instructions for the user
        System.out.println("Real Use of Chess Notation Component");
        System.out.println(
                "Please enter your moves formatted (WhiteMove BlackMove): ");
        System.out.println("Type 'checkmate' to end the game.");
        System.out.println("Type 'remove <turnNumber>' to remove a turn.");

        int turnCount = 0;
        while (true) {
            System.out.print("Enter turn " + (turnCount + 1) + ": ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("checkmate")) {
                break;
            }

            //option to remove turn
            if (input.toLowerCase().startsWith("remove")) {
                try {
                    String[] parts = input.split("\\s+");
                    if (parts.length == 2) {
                        int turnToRemove = Integer.parseInt(parts[1]) - 1;
                        if (turnToRemove >= 0 && turnToRemove < turnCount) {
                            game.removeTurn(turnToRemove);
                            turnCount--;
                            System.out.println(
                                    "Turn " + (turnToRemove + 1) + " removed.");
                        } else {
                            System.out.println("Invalid turn number!");
                        }
                    } else {
                        System.out.println(
                                "Invalid remove command. Usage: remove <turnNumber>");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid turn number format.");
                }
                continue;
            }

            //split the input into white and black moves
            String[] moves = input.split("\\s+");
            if (moves.length == 2) {
                String whiteMove = moves[0];
                String blackMove = moves[1];

                //add the turn to the game
                game.addTurn(turnCount, whiteMove, blackMove);
                turnCount++;
            } else {
                System.out.println(
                        "Invalid input! Please enter both white and black moves.");
            }
        }

        //display the notation dump after the game ends
        game.dumpNotation();

        //example of adding metadata
        game.addMetadata("Style of Chess", "Standard Chess");
        game.addMetadata("Location", "OSU Stadium");
        game.addMetadata("Player (White)", "Othon");
        game.addMetadata("Player (Black)", "Elliott");

        //print metadata (if given)
        System.out.println("Metadata: " + game.getMetadata());

        scanner.close();
    }
}
