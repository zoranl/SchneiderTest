public class GameBoard {
    private final int size;
    private final char[][] board;
    private final boolean[][] mines;
    private int playerRow;
    private int playerCol;
    private int lives;
    private int moves;

    public GameBoard(int size, int lives) {
        this.size = size;
        this.lives = lives;
        this.moves = 0;
        board = new char[size][size];
        mines = new boolean[size][size];
        initializeBoard();
        placeMines();
        playerRow = 0;
        playerCol = 0;
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
    }

    private void placeMines() {
        // Randomly place mines on the board
        int mineCount = size; // Example: one mine per row
        while (mineCount > 0) {
            int row = (int) (Math.random() * size);
            int col = (int) (Math.random() * size);
            if (!mines[row][col]) {
                mines[row][col] = true;
                mineCount--;
            }
        }
    }

    public boolean movePlayer(String direction) {
        switch (direction.toLowerCase()) {
            case "up":
                if (playerRow > 0) 
					playerRow--;
                break;
            case "down":
                if (playerRow < size - 1) 
					playerRow++;
                break;
            case "left":
                if (playerCol > 0) 
					playerCol--;
                break;
            case "right":
                if (playerCol < size - 1) 
					playerCol++;
                break;
            default:
                System.out.println("Invalid move. Use up, down, left, or right.");
                return false;
        }
        moves++;
        if (mines[playerRow][playerCol]) {
            lives--;
            System.out.println("Hit a mine! Lives left: " + lives);
            return false;
        }
        return true;
    }

    public boolean isGameOver() {
        return lives <= 0 || (playerRow == size - 1 && playerCol == size - 1);
    }

	public int getMoves(){
		return moves;
	}
	
	public int getLives(){
		return lives;
	}
	
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print('P');
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Moves: " + moves + ", Lives: " + lives);
    }
}