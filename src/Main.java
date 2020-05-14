public class Main {
    public static void main(String[] args) {
        Player player = new Player('X');
        Board b = new Board();

        while (true) {
            b.print();
            player.makeMove(b);
            if(player.isWinner(b)) {
                b.print();
                System.out.println(player.getFigure() + " wins");
                break;
            }
            if (b.isFinished()) {
                b.print();
                System.out.println("Draw");
                break;
            }
            player.next();
        }
    }
}


