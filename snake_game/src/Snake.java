import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Snake {

    Queue<Cell> snakeParts;
    Cell head;

    public Cell getHead() {
        return head;
    }

    public Snake(Cell initPos) {
        snakeParts = new LinkedList<>();
        snakeParts.offer(initPos);
        head = initPos;
        initPos.setCellType(CellType.SNAKE_BODY);
    }

    public void move(Cell cell) {
        head = cell;
        head.setCellType(CellType.SNAKE_BODY);
        snakeParts.offer(cell);
        if (!snakeParts.isEmpty()) {
            Cell last = snakeParts.poll();
            last.setCellType(CellType.EMPTY);
            System.out.println("Snake head moved to " + head.getRow() + " " + head.getCol());
        }

    }

    public void grow(Cell head) {
        this.head = head;
        head.setCellType(CellType.SNAKE_BODY);
        snakeParts.offer(head);
        System.out.println("Snake head moved to " + head.getRow() + " " + head.getCol());
    }

    public boolean isCrash(Cell cell) {
        return cell.getCellType().equals(CellType.SNAKE_BODY);
    }

}
