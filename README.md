# Tic Tac Toe: An OOP Implementation

This folder contains a Java implementation of the classic Tic Tac Toe game, demonstrating key principles of Object-Oriented Programming.

## Problem Statement

Create a Tic Tac Toe game where two players take turns marking spaces on a 3x3 grid. The first player to get three in a row (horizontally, vertically, or diagonally) wins. The game should also detect draws.  The game should support playing against another human player or against a simple AI.

## OOP Concepts Illustrated

This implementation demonstrates the following OOP principles:

*   **Abstraction:** The `Player` class is abstract, defining the common behavior of any player (making a move) without specifying how that move is determined.
*   **Encapsulation:** The `TicTacToe` class encapsulates the game board and the logic for manipulating it.  Direct access to the `board` is restricted, and operations are performed through methods.  The `isValidMove` method inside the player class checks the valid move.
*   **Inheritance:** The `HumanPlayer` and `AIPlayer` classes inherit from the `Player` class, providing specific implementations for making a move.
*   **Polymorphism:** The `makeMove()` method is an example of polymorphism. The abstract `Player` class defines the method, but the concrete `HumanPlayer` and `AIPlayer` classes implement it differently based on their specific logic.

## Class Breakdown

*   **`TicTacToe`:**
    *   Represents the game board and game logic.
    *   `board`: A 2D char array representing the Tic Tac Toe board.
    *   `initBoard()`: Initializes the board with empty spaces.
    *   `displayBoard()`: Prints the current state of the board.
    *   `placeMark(int row, int col, char mark)`: Places a player's mark on the board.
    *   `checkRowWin()`, `checkColWin()`, `checkDiagonalWin()`:  Check if there is any win.
    *   `checkDraw()`: Checks if the board is full, resulting in a draw.

*   **`Player` (abstract):**
    *   Abstract class representing a player.
    *   `name`: Player's name.
    *   `mark`:  Player's symbol ('X' or 'O').
    *   `makeMove()`: Abstract method to define how a player makes a move.
    *   `isValidMove(int row, int col)`: Checks if a given move is valid.

*   **`HumanPlayer`:**
    *   Concrete class representing a human player.
    *   Extends the `Player` class.
    *   `makeMove()`: Implements the move by prompting the user for input.

*   **`AIPlayer`:**
    *   Concrete class representing an AI player.
    *   Extends the `Player` class.
    *   `makeMove()`: Implements the move by randomly selecting an open space on the board.

*   **`Main`:**
    *   Contains the `main` method to run the game.
    *   Handles game setup, player selection (Human vs. AI), and the main game loop.

## Folder Contents

*   `Main.java`: The main Java file containing the code for the Tic Tac Toe game.
*   `README.md`: This file.
*   `output.txt`: A sample output of a game session.

## How to Run

1.  Compile the `Main.java` file:  `javac Main.java`
2.  Run the compiled code:  `java Main`

