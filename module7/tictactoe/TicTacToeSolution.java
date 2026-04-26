package module7.tictactoe;

import java.util.Scanner;

/**
 * PRACTICE SOLUTION AREA: Tic-Tac-Toe
 *
 * Read TicTacToeQuestion.md first.
 *
 * Keep the first version simple:
 * 1. Player
 * 2. Board
 * 3. Game
 * 4. GameStatus
 */

enum Symbols {
    CROSS('X'),
    ZERO('O');

    private final char value;

    Symbols(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }
}

enum GameStatus {
    IN_PROGRESS,
    WON,
    DRAW
}

class Player {
    private final String name;
    private final char symbol;

    Player(String name, char symbols) {
        this.name = name;
        this.symbol = symbols;
    }

    public String getPlayerName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }
}

class Board {
    private final char[][] board;
    Board() {
        board = new char[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = '.';
            }
        }
    }

    public char[][] getBoard() {
        return this.board;
    }

    public void printBoard() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(" | " + board[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    public boolean isFull() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i][j] == '.') return false;
            }
        }
        return true;
    }

    public boolean isValidMove(int i, int j) {
        if(i<0 || j<0 || i>=3 || j>=3) {
            System.out.println("Position is invalid to update");
            return false;
        }

        if(board[i][j]!='.') {
            System.out.println("Cell is already acquired");
            return false;
        }

        return true;
    }

    public boolean placeMove(int i, int j, char symbol) {
        boolean isValidMove = isValidMove(i, j);
        if(!isValidMove) return false;
        board[i][j] = symbol;
        return true;
    }
}

class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    private GameStatus status;
    private Player winner;

    Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        currentPlayer = p1;
        board = new Board();
        status = GameStatus.IN_PROGRESS;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return status != GameStatus.IN_PROGRESS;
    }

    public void switchTurn() {
        if(currentPlayer.equals(player1)) currentPlayer = player2;
        else currentPlayer = player1;
    }

    public boolean move(int i, int j) {
        if(isGameOver()) {
            System.out.println("Game is already finished.");
            return false;
        }

        boolean moved = board.placeMove(i, j, currentPlayer.getSymbol());
        if(!moved) {
            System.out.println("Wrong move, Select correct move.");
            return false;
        }

        Player possibleWinner = checkWinner();
        if(possibleWinner != null) {
            winner = possibleWinner;
            status = GameStatus.WON;
            return true;
        }

        if(board.isFull()) {
            status = GameStatus.DRAW;
            return true;
        }

        switchTurn();
        return true;
    }

    public Player checkWinner() {
        // rows
        char[][] brd = board.getBoard();
        for (int i = 0; i < 3; i++) {
            if (brd[i][0] != '.' &&
                brd[i][0] == brd[i][1] &&
                brd[i][1] == brd[i][2]) {
                return brd[i][0] == player1.getSymbol() ? player1 : player2;
            }
        }

        // columns
        for (int j = 0; j < 3; j++) {
            if (brd[0][j] != '.' &&
                brd[0][j] == brd[1][j] &&
                brd[1][j] == brd[2][j]) {
                return brd[0][j] == player1.getSymbol() ? player1 : player2;
            }
        }

        // diagonal: top-left to bottom-right
        if (brd[0][0] != '.' &&
            brd[0][0] == brd[1][1] &&
            brd[1][1] == brd[2][2]) {
            return brd[0][0] == player1.getSymbol() ? player1 : player2;
        }

        // diagonal: top-right to bottom-left
        if (brd[0][2] != '.' &&
            brd[0][2] == brd[1][1] &&
            brd[1][1] == brd[2][0]) {
            return brd[0][2] == player1.getSymbol() ? player1 : player2;
        }

        return null; 
    }

}

public class TicTacToeSolution {
    public static void main(String[] args) {
        System.out.println("--- Tic-Tac-Toe Solution ---");

        // TODO:
        // 1. Create two players.
        // 2. Create the board.
        // 3. Alternate turns.
        // 4. Validate moves.
        // 5. Detect win/draw.
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert Player1 name and Symbol");
        String name1 = sc.nextLine();
        char symbol1 = sc.next().charAt(0);
        sc.nextLine();
        if(symbol1 != Symbols.CROSS.getValue() &&  symbol1 != Symbols.ZERO.getValue()) {
            System.out.println("Invalid input symbol");
            return;
        }

        System.out.println("Insert Player2 name and Symbol");
        String name2 = sc.nextLine();
        char symbol2 = sc.next().charAt(0);
        sc.nextLine();
        if((symbol2 != Symbols.CROSS.getValue() &&  symbol2 != Symbols.ZERO.getValue()) || (symbol1==symbol2)) {
            System.out.println("Invalid input symbol");
            return;
        }

        Player player1 = new Player(name1, symbol1);
        Player player2 = new Player(name2, symbol2);
        Game game = new Game(player1, player2);

        while(!game.isGameOver()) {
            game.getBoard().printBoard();
            System.out.println(game.getCurrentPlayer().getPlayerName() + " Move your turn with symbol " + game.getCurrentPlayer().getSymbol());
            int i = sc.nextInt();
            int j = sc.nextInt();
            boolean isValidMove = game.move(i, j);
            while(!isValidMove) {
                System.out.println(game.getCurrentPlayer().getPlayerName() + " Please choose valid move");
                game.getBoard().printBoard();
                i = sc.nextInt();
                j = sc.nextInt();
                isValidMove = game.move(i, j);
            }

        }

        if(game.getStatus() == GameStatus.DRAW) {
            System.out.println("Game is: " + game.getStatus());
        } else {
            System.out.println(game.getWinner().getPlayerName() + " won!!!");
        }

        System.out.println("Tic-Tac-Toe game completed.");
    }
}
