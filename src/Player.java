import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {
    private char figure;
    Scanner sc = new Scanner(System.in);

    public Player (char figure) {
        this.figure = figure;
    }

    public char getFigure () {
        return figure;
    }

    public void makeMove(Board b) {

        System.out.print("Enter the coordinates: ");

        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int x;
        int y;
        if(arr.length>0 && Pattern.matches("\\d+", arr[0])) {
            x = Integer.parseInt(arr[0]);
        } else {
            System.out.println("You should enter numbers!");
            makeMove(b);
            return;
        }
        if(arr.length>1 && Pattern.matches("\\d+", arr[1])) {
            y = Integer.parseInt(arr[1]);
        } else {
            System.out.println("You should enter numbers!");
            makeMove(b);
            return;
        }

        if(x>3 || y>3 || x<1 || y<1) {
            System.out.println("Coordinates should be from 1 to 3!");
            makeMove(b);
            return;
        }

        if(b.isFree(x,y)) {
            b.move(this, x,y);
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            makeMove(b);
        }
    }

    public boolean isWinner(Board b) {
        if(b.getValue(0,0) == this.getFigure() && b.getValue(0,1) == this.getFigure() && b.getValue(0,2) == this.getFigure()) {
            return true;
        }
        if(b.getValue(1,0) == this.getFigure() && b.getValue(1,1) == this.getFigure() && b.getValue(1,2) == this.getFigure()) {
            return true;
        }
        if(b.getValue(2,0) == this.getFigure() && b.getValue(2,1) == this.getFigure() && b.getValue(2,2) == this.getFigure()) {
            return true;
        }
        if(b.getValue(0,0) == this.getFigure() && b.getValue(1,0) == this.getFigure() && b.getValue(2,0) == this.getFigure()) {
            return true;
        }
        if(b.getValue(0,1) == this.getFigure() && b.getValue(1,1) == this.getFigure() && b.getValue(2,1) == this.getFigure()) {
            return true;
        }
        if(b.getValue(0,2) == this.getFigure() && b.getValue(1,2) == this.getFigure() && b.getValue(2,2) == this.getFigure()) {
            return true;
        }
        if(b.getValue(0,0) == this.getFigure() && b.getValue(1,1) == this.getFigure() && b.getValue(2,2) == this.getFigure()) {
            return true;
        }
        return b.getValue(0, 2) == this.getFigure() && b.getValue(1, 1) == this.getFigure() && b.getValue(2, 0) == this.getFigure();
    }

    public void next() {
        if (this.getFigure() == 'X') {
            this.setFigure('O');
        } else {
            this.setFigure('X');
        }
    }

    private void setFigure(char c) {
        this.figure = c;
    }
}
