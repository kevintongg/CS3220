package beans;

public class TicTacToe {

  private int turn = 0;
  private char player = 'X';
  private char[] board = new char[9];
  private boolean winner = false;

  private String[] links = new String[9];

  public TicTacToe() {
    for (char i : this.board) {
      this.board[i] = ' ';
    }
  }

  /**
   * 0 1 2
   * 3 4 5
   * 6 7 8
   */

  public boolean check(char[] board) {

    if (board[0] == 'X' && board[1] == 'X' && board[2] == 'X') {
      return true;
    } else if (board[0] == 'O' && board[1] == 'O' && board[2] == 'O') {
      return true;
    }

    if (board[3] == 'X' && board[4] == 'X' && board[5] == 'X') {
      return true;
    } else if (board[3] == 'O' && board[4] == 'O' && board[5] == 'O') {
      return true;
    }

    if (board[0] == 'X' && board[3] == 'X' && board[6] == 'X') {
      return true;
    } else if (board[0] == 'O' && board[3] == 'O' && board[6] == 'O') {
      return true;
    }

    if (board[1] == 'X' && board[4] == 'X' && board[7] == 'X') {
      return true;
    } else if ((board[1] == 'O' && board[4] == 'O' && board[7] == 'O')) {
      return true;
    }

    if (board[2] == 'X' && board[5] == 'X' && board[8] == 'X') {
      return true;
    } else if (board[2] == 'O' && board[5] == 'O' && board[8] == 'O') {
      return true;
    }

    if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
      return true;
    } else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') {
      return true;
    }

    if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
      return true;
    } else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') {
      return true;
    }

    return false;
  }

//  public void setLocation(String location) {
//    location;
//  }


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

  public boolean isWinner() {
    return winner;
  }

  public void setWinner(boolean winner) {
    this.winner = winner;
  }

  public boolean getCheck(char[] board) {
    return check(board);
  }

  public void setMove(String move) {
    board[Integer.parseInt(move)] = player;
    player = player == 'O' ? 'X' : 'O';
  }

  public char getPlayer() {

    return player;
//    return player == 'O' ? 'X' : 'O';

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

    for (char i : board) {
      board[i] = ' ';
    }

    player = 'X';
  }

  public int getTurn() {
    return turn;
  }

  public void setTurn(int turn) {
    this.turn = turn;
  }
}

