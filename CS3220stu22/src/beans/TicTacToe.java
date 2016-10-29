package beans;

public class TicTacToe {

  private char[] board = new char[9];
  private char player = 'X';
  private char winner = ' ';

  private boolean activeGame = false;

  private String[] links = new String[9];

  public TicTacToe() {
    for (int i = 0; i < this.board.length; i++) {
      this.board[i] = ' ';
    }
  }

  /**
   * 0 1 2
   * 3 4 5
   * 6 7 8
   */

  private boolean check(char[] board) {

    if (board[0] == 'X' && board[1] == 'X' && board[2] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if (board[0] == 'O' && board[1] == 'O' && board[2] == 'O') {
      winner = 'O';
      return activeGame = true;
    }

    if (board[3] == 'X' && board[4] == 'X' && board[5] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if (board[3] == 'O' && board[4] == 'O' && board[5] == 'O') {
      winner = 'O';
      return activeGame = true;
    }

    if (board[0] == 'X' && board[3] == 'X' && board[6] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if (board[0] == 'O' && board[3] == 'O' && board[6] == 'O') {
      winner = 'O';
      return activeGame = true;
    }

    if (board[1] == 'X' && board[4] == 'X' && board[7] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if ((board[1] == 'O' && board[4] == 'O' && board[7] == 'O')) {
      winner = 'O';
      return activeGame = true;
    }

    if (board[2] == 'X' && board[5] == 'X' && board[8] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if (board[2] == 'O' && board[5] == 'O' && board[8] == 'O') {
      winner = 'O';
      return activeGame = true;
    }

    if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') {
      winner = 'X';
      return activeGame = true;
    }

    if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
      winner = 'X';
      return activeGame = true;
    } else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') {
      winner = 'O';
      return activeGame = true;
    }

    return activeGame = false;
  }

  public String[] getLinks() {

    for (int i = 0; i < links.length; i++) {
      if (board[i] == 'O') {
        links[i] = "http://cs3.calstatela.edu:8080/cs3220stu22/images/o.png";
      } else if (board[i] == 'X') {
        links[i] = "http://cs3.calstatela.edu:8080/cs3220stu22/images/x.png";
      } else if (board[i] == ' ') {
        links[i] = "http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png";
      }
    }

    return links;
  }

  public void setLinks(String[] links) {
    this.links = links;
  }

  public boolean isActiveGame() {
    return activeGame;
  }

  public void setActiveGame(boolean activeGame) {
    this.activeGame = activeGame;
  }

  public boolean getCheck(char[] board) {
    return check(board);
  }

  public void setMove(String move) {
    for (int i = 0; i < board.length; i++) {
      if (!check(board)) {
        if (board[i] == ' ') {
          board[Integer.parseInt(move)] = player;
          player = player == 'O' ? 'X' : 'O';
        } else {
          player = player == 'X' ? 'O' : 'X';
        }
      }
    }

    if (check(board)) {
      player = winner;
    }
  }

  public char display() {
    if (!check(board)) {
      return ' ';
    } else {
      return winner;
    }
  }

  public char getPlayer() {
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

    if (!activeGame) {
      for (int i = 0; i < board.length; i++) {
        board[i] = ' ';
      }

      player = 'X';
    }
  }

  public char getWinner() {
    return winner;
  }

  public void setWinner(char winner) {
    this.winner = winner;
  }
}