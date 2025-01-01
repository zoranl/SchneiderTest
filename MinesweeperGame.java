import java.util.Scanner;

public class MinesweeperGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard(8, 3); // 8x8 board with 3 lives

        while (!gameBoard.isGameOver()) {
            gameBoard.printBoard();
            System.out.print("Enter move (up, down, left, right): ");
            String move = scanner.nextLine();
            gameBoard.movePlayer(move);
        }

        if (gameBoard.isGameOver()) {
            System.out.println("Game Over! Total moves: " + gameBoard.getMoves()
				+ "Total lives left: " + gameBoard.getLives());
        }
    }
}