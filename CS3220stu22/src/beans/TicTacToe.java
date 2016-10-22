package beans;

public class TicTacToe {

  private char currentPlayer;
  private char[] board;

  public TicTacToe() {

    currentPlayer = 'X';

    board = new char[9];

    for (char i : board) {
      board[i] = ' ';
    }
  }

  public char getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(char currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public char[] getBoard() {
    return board;
  }

  public void setBoard(char[] board) {
    this.board = board;
  }

  public void setReset(String reset) {

  }
}

