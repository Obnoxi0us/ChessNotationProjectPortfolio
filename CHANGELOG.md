# Changelog

Othon DeAssis 12/04/2024

I have completed:
-Finalized ChessNotation.java
-Finalized ChessNotation1.java
-Finalized ChessNotationKernel.java
-Finalized ChessNotationSecondary.java

I have created:
-ChessNotationKernelTest.java: Developed a comprehensive test suite to validate the behavior and functionality of methods defined in the ChessNotationKernel class, ensuring all edge cases and expected behaviors are properly tested.

-ChessNotationSecondaryTest.java: Created detailed tests for the ChessNotationSecondary class, covering all possible scenarios for methods like addTurn, removeTurn, dumpNotation, and metadata handling.

## 2024.12.04

### Added

- 5 tests per method: Implemented a thorough set of tests for every method in ChessNotationKernel and ChessNotationSecondary, covering all possible conditions and edge cases (e.g., empty inputs, invalid values, and boundary conditions).

- Test example for real-world use: Developed a sample test case that demonstrates the practical use of the chess notation components, simulating a full chess game with move inputs, metadata addition, and turn removals

### Updated

- Fixed checkAmount in ChessNotationSecondary: Corrected the logic for counting turns in ChessNotationSecondary, ensuring accurate tracking of the number of turns played in the game.

- Fixed dumpNotation in ChessNotationSecondary: Addressed an issue where the chess notation dump failed to display correctly when no turns were added or when the list was empty. Now provides a clear message when there are no recorded moves.

- Fixed addMetadata in ChessNotationKernel: Resolved a bug in the addMetadata method, ensuring that metadata is properly stored and retrieved in the ChessNotationKernel class, allowing for more efficient data management.
