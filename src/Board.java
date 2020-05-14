public class Board {
    char[][] board = new char[3][3];

    public Board () {

        for (int i=0; i<9; i++) {
            board [i/3][i%3] = '_';
        }
    }

    public void print () {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", board[0][0],board[0][1],board[0][2]);
        System.out.printf("| %c %c %c |\n", board[1][0],board[1][1],board[1][2]);
        System.out.printf("| %c %c %c |\n", board[2][0],board[2][1],board[2][2]);
        System.out.println("---------");
    }

    public boolean isValid() {
        int countX = 0;
        int countO = 0;

        for (char[] arr : board) {
            for (char c : arr) {
                if (c != 'X' && c != 'O' && c != '_') {
                    return false;
                }
                if (c == 'X') {
                    countX++;
                }
                if (c == 'O') {
                    countO++;
                }
            }
        }

        return Math.abs(countO - countX) <= 1;
    }

    public char getValue (int i, int j) {
        return board[i][j];
    }

    public boolean isPlayerWin(char player) {
        if(board[0][0] == player && board[0][1] == player && board[0][2] == player ) {
            return true;
        }
        if(board[1][0] == player && board[1][1] == player && board[1][2] == player ) {
            return true;
        }
        if(board[2][0] == player && board[2][1] == player && board[2][2] == player ) {
            return true;
        }
        if(board[0][0] == player && board[1][0] == player && board[2][0] == player ) {
            return true;
        }
        if(board[0][1] == player && board[1][1] == player && board[2][1] == player ) {
            return true;
        }
        if(board[0][2] == player && board[1][2] == player && board[2][2] == player ) {
            return true;
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public boolean isFinished () {
        int count = 0;
        for (char[] arr : board) {
            for (char c : arr) {
                if (c == '_') {
                    count++;
                }
            }
        }

        return count==0;
    }

    public void move (Player player, int posX, int posY) {
        board[3-posY][posX-1] = player.getFigure();
    }

    public boolean isFree (int posX, int posY) {
        return board[3-posY][posX-1] == '_';
    }
}
