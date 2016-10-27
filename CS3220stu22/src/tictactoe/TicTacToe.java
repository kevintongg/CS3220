package tictactoe;

public class TicTacToe {

  private char[][] board;
  private boolean endOfGame;
  private int turn;
  private int winner;

  public TicTacToe() {

    board = new char[3][3];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = ' ';
      }
    }

    turn = 0;
  }

  public char[][] getBoard() {
    return board;
  }

  public void setBoard(char[][] board) {
    this.board = board;
  }

  public boolean isEndOfGame() {
    return endOfGame;
  }

  public void setEndOfGame(boolean endOfGame) {
    this.endOfGame = endOfGame;
  }

  public int getTurn() {
    return turn;
  }

  public void setTurn(int turn) {
    this.turn = turn;
  }

  public int getWinner() {
    return winner;
  }

  public void setWinner(int winner) {
    this.winner = winner;
  }
}
