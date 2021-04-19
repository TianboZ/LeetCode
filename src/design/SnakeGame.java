package design;

import java.util.LinkedList;

public class SnakeGame {

    private int m;
    private int n;
    private LinkedList<int[]> snake;
    private int[][] food;
    private int i;

    public SnakeGame(int width, int height, int[][] food) {
        m = height;
        n = width;
        this.food = food;
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.getFirst();
        int x = head[0];
        int y = head[1];

        if (direction.equals("U")) {
            x--;
        } else if (direction.equals("L")) {
            y--;
        } else if (direction.equals("R")) {
            y++;
        } else {
            x++;
        }

        // check if will hit wall
        if (x < 0 || y < 0 || x == m || y == n) {
            return -1;
        }

        // check if will hit body

        // not eat food, remvoe tail
        if(i < food.length && x == food[i][0] && y == food[i][1]) {
            // food
            i++;
        } else {
            snake.removeLast();
        }

        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) return -1; // hit body
        }

        // add new head
        snake.addFirst(new int[] {x, y});

        return snake.size()  -1;
    }
}
