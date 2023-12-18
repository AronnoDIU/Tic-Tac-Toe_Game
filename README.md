# Tic Tac Toe Game

## Description

This is a simple implementation of the classic Tic-Tac-Toe game in Java. The game is played on a 3x3 grid, and the goal
is to get three of your marks (either X or O) in a row, either horizontally, vertically, or diagonally.

## Table of Contents

- [Tic Tac Toe Game](#tic-tac-toe-game)
    - [Description](#description)
    - [Table of Contents](#table-of-contents)
    - [Features](#features)
    - [Installation](#installation)
        - [How to Run](#how-to-run)
    - [Game Rules](#game-rules)
    - [Code Structure](#code-structure)
    - [Contributing](#contributing)
    - [License](#license)

## Features

- Player vs AI gameplay: The user plays against a simple AI that makes its moves randomly.
- Console-based user interface: The game board and prompts for user input are displayed in the console.
- Input validation: The game checks if the user's input is valid (i.e., within the range of the board and the chosen
  cell is not yet occupied).

## Installation

### How to Run

- To run the game, you need to have Java installed on your machine. You can download it from the official Oracle
  website.
- Once you have Java installed, you can compile and run the game using the following commands in your terminal:

```bash
javac TicTacToe.java
java TicTacToe
```

## Game Rules

1. The game starts with an empty 3x3 board.
2. The user (Player X) makes the first move. The user is prompted to enter the row and column (1-3) where they want to
   place their mark.
3. The AI (Player O) makes its move. The AI chooses a random unoccupied cell on the board.
4. Steps 2 and 3 are repeated until the game ends.
5. The game ends when one player has three of their marks in a row (horizontally, vertically, or diagonally) or the
   board is full (in which case, the game is a tie).

## Code Structure

- TicTacToe.java: This file contains the TicTacToe class, which includes all the logic for the game. The main method,
  which starts the game, is also in this class.

## Contributing

- Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the terms of the MIT license.