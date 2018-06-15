package debugLaicode;


import java.util.*;

public class PutChairII {
    public List<Integer> putChair(char[][] gym) {
        if (gym.length == 0 || gym[0].length == 0) {
            return null;
        }
        // Write your solution here
        // initial
        Cell[][] cell = new Cell[gym.length][gym[0].length];
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                cell[i][j] = new Cell();
            }
        }

        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (gym[i][j] == 'E') {
                    //System.out.printf("a");
                    bfs(gym, cell, i, j);
                }
            }
        }
        //System.out.printf("a");
        // largestSmaller final sol
        int min = 100000;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (gym[i][j] == 'C') {
                    int sum = getSum(cell[i][j].list);
                    if (sum < min) {
                        min = sum;
                        res.clear();
                        res.add(i);
                        res.add(j);
                    }
                }
            }
        }
        return res.size() > 0 ? res : null;
        //return res;
    }
    public int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum = sum + i;
        }
        return sum;
    }
    public void bfs(char[][] gym, Cell[][] cell, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int dis = 1;
        Set<Point> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // expand
                Point cur = queue.poll();
                cell[cur.x][cur.y].list.add(dis);
                // generate
                if (cur.x + 1 < gym.length && gym[cur.x + 1][cur.y] != 'O' && !visited.contains(new Point(cur.x + 1, cur.y))) {
                    queue.offer(new Point(cur.x + 1, cur.y));
                    visited.add(new Point(cur.x + 1, cur.y));
                }
                if (cur.x - 1 >= 0 && gym[cur.x - 1][cur.y] != 'O' && !visited.contains(new Point(cur.x - 1, cur.y))) {
                    queue.offer(new Point(cur.x - 1, cur.y));
                    visited.add(new Point(cur.x - 1, cur.y));
                }
                if (cur.y + 1 < gym[0].length && gym[cur.x][cur.y + 1] != 'O' && !visited.contains(new Point(cur.x, cur.y + 1))) {
                    queue.offer(new Point(cur.x, cur.y + 1));
                    visited.add(new Point(cur.x, cur.y + 1));
                }
                if (cur.y - 1 >= 0 && gym[cur.x][cur.y - 1] != 'O' && !visited.contains(new Point(cur.x, cur.y - 1))) {
                    queue.offer(new Point(cur.x, cur.y - 1));
                    visited.add(new Point(cur.x, cur.y - 1));
                }
            }
            dis++;
        }
    }
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }
        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
    class Cell {
        List<Integer> list;
        public Cell() {
            this.list = new ArrayList<>();
        }
    }
}
