import java.util.Scanner;

public class Game {

    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col;
    private static int row;

    public static void main(String[] args) {
        ox = new OX();
        while (true){
            printTable();
            input();
            if(ox.checkWin(col,row)){
                printTable();
                System.out.println(ox.getCurrentPlayer() + " " + "Win");
                System.out.println("X win : " + ox.getScoreX());
                System.out.println("O win : " + ox.getScoreO());
                System.out.println("Draw  : " + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printTable();
                System.out.println(ox.getCurrentPlayer() + " " + "Win");
                System.out.println("X win : " + ox.getScoreX());
                System.out.println("O win : " + ox.getScoreO());
                System.out.println("Draw  : " + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void input() {
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " Col :");
            col = sc.nextInt();
            System.out.print(ox.getCurrentPlayer() + " Row :");
            row = sc.nextInt();
            canPut = ox.put(col, row);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }
        }while(!canPut);
    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}
