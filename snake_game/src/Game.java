import java.util.Scanner;

public class Game {
    Board board;
    Snake snake;
    Cell food;
    boolean isGameOver;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Cell getFood() {
        return food;
    }

    public void setFood(Cell food) {
        this.food = food;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    Game(Board board) {
        this.board = board;
        this.snake = new Snake(new Cell(0 , 0));
        System.out.println("snake head at 0 0");
        this.food = board.generateFood();
        System.out.println("Food at " + food.getRow() + " " + food.getCol());
        this.isGameOver = false;
    }

    private void update(int direction){
        Cell snakeHead = snake.getHead();
        Cell next = null;
        switch (direction) {
            case 1:
                System.out.println("Moving to direction UP");
                next = board.getCells()[snakeHead.getRow() - 1][snakeHead.getCol()];
                break;
            case 2:
                System.out.println("Moving to direction DOWN");
                next = board.getCells()[snakeHead.getRow() + 1][snakeHead.getCol()];
                break;
            case 3:
                System.out.println("Moving to direction LEFT");
                next = board.getCells()[snakeHead.getRow()][snakeHead.getCol() - 1];
                break;
            case 4:
                System.out.println("Moving to direction RIGHT");
                next = board.getCells()[snakeHead.getRow()][snakeHead.getCol() + 1];
                break;
        }
        if(next != null && board.isValid(next)){
            if (snake.isCrash(next)) {
                System.out.println("GAME OVER");
                this.setGameOver(true);
            } else if (next.getCellType().equals(CellType.FOOD)) {
                System.out.println("Eating food at " + next.getRow() + " " + next.getCol());
                snake.grow(next);
                this.food = board.generateFood();
                System.out.println("New food at " + food.getRow() + " " + food.getCol());
            } else {
                snake.move(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows of board");
        int i = scanner.nextInt();
        System.out.println("Enter the number of cols of board");
        int j = scanner.nextInt();
        Game game = new Game(new Board(i, j));

        while (!game.isGameOver()) {
            System.out.println("Enter 1 for UP, Enter 2 for DOWN, Enter 3 for LEFT or Enter 4 for RIGHT");
            int input = scanner.nextInt();
            game.update(input);
        }

    }
}
