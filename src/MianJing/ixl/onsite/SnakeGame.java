package MianJing.ixl.onsite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnakeGame {
    // fields
    int m;
    int n;
    LinkedList<int[]> snake;

    // constructor
    // pos is snake initial position
    SnakeGame(int m, int n, int[][] pos) {
        this.m = m;
        this.n = n;
        snake = new LinkedList<>();
        for (int[] p : pos) {
            snake.add(p);
        }
    }
    // APIs
    public void move(char dir) { // U, L, R, D
        int[] head = snake.get(0);
        int headx= head[0];
        int heady= head[1];

        if(dir == 'U') {
            headx--;
        } else if(dir == 'L') {
            heady--;
        } else if (dir == 'R') {
            heady++;
        } else {
            headx++;
        }

        if (headx < 0 || headx >= m || heady < 0 || heady >= n) {
            System.out.println("hit walls");
            return;
        }

        // move tail
        //snake.remove(snake.size() - 1);
        snake.removeLast();

        // check new head if will hit body
        for (int i = 0; i < snake.size(); i++) {
            int[] body = snake.get(i);
            if (body[0] == headx && body[1] == heady) {
                System.out.println("snake hit itself");
                return;
            }
        }

        // add new head
        int[] curr = {headx, heady};
        snake.addFirst(curr);

        System.out.println("snake moved new pos: ");
        System.out.println("head: " + curr[0] + ", " + curr[1]);;

        int[] tail = snake.getLast();
        System.out.println("tail: " + tail[0] + ", " + tail[1]);

    }

    public static void main(String[] args) {

        /*
        * H S S X
        * X X X X
        * X X X X
        * X X X X
        *
        * // after 'D' 'D'
        *  S X X X
         * S X X X
         * H X X X
         * X X X X
         *
         *
         * // move 'U' , should dead
        *
        *
        * */
        int[][] snake = {{0,0}, {0,1}, {0,2}};
        SnakeGame sol = new SnakeGame(3, 4, snake );

        sol.move('D');  // head:  [1 , 0]  tail: [0, 1]
        sol.move('D');  // head:  [2 , 0]  tail: [0, 0]
        //sol.move('L');  // dead

        sol.move('U'); // hit body
    }
}
