# LLD Question 2: Tic-Tac-Toe

## Problem Statement

Design a Tic-Tac-Toe game.

The game should allow:
1. Two players to play against each other.
2. Players to take turns.
3. The board to accept valid moves.
4. The game to detect win, draw, and ongoing states.

---

## Clarifying Questions To Think About

Before coding, think through these:

1. Is the board always 3x3 or should it support N x N?
2. Are there exactly two players?
3. Can both players have custom symbols?
4. Should the game reject invalid moves?
5. Should the game support replay or only one match?
6. Should moves be entered through console input or hardcoded demo moves?
7. Do we need AI/bot support?

---

## Required Features

For your first version, support:

1. 3x3 board.
2. Two players.
3. Alternating turns.
4. Move validation.
5. Win detection.
6. Draw detection.

---

## Suggested Entities

You may use these, or design your own:

1. `Player`
2. `Board`
3. `Cell`
4. `Move`
5. `Game`
6. `GameStatus`

---

## Design Hints

Useful ideas:

1. Keep board validation inside `Board`.
2. Keep game flow inside `Game`.
3. Keep player details inside `Player`.
4. Avoid putting all logic in `main`.

---

## Edge Cases

Think about:

1. Move outside the board.
2. Move on an already occupied cell.
3. Win after row, column, or diagonal.
4. Draw when board is full.
5. Trying to play after game is already over.

---

## Your Task

Create your solution in:

```text
module7/tictactoe/TicTacToeSolution.java
```

When you are done, ask me to review it.
