package beans;

public class TicTacToe {

  private int turn;
  private char player;
  private char[] board;

  public TicTacToe() {

    player = 'X';

    turn = 0;

    board = new char[9];

    for (char i : board) {
      board[i] = ' ';
    }
  }

  public char getPlayer() {

    if (turn % 2 == 0) {
      player = 'X';
    } else if (turn % 2 != 0) {
      player = 'O';
    }

    return player;

  }

  public void setPlayer(char player) {
    this.player = player;
  }

  public char[] getBoard() {
    return board;
  }

  public void setBoard(char[] board) {
    this.board = board;
  }

  public void setReset(String reset) {

  }

  public int getTurn() {
    return turn;
  }

  public void setTurn(int turn) {
    this.turn = turn;
  }
}

