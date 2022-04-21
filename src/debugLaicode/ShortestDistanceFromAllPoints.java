package debugLaicode;

import java.util.*;


public class ShortestDistanceFromAllPoints {
    int[] dx = {0,0,1,-1};
    int[] dy = {-1,1,0,0};

    public int shortestDistance(int[][] grid) {
        // initial cell
        Cell[][] cell = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cell[i][j] = new Cell();
            }
        }
        int house = 0;
        // run bfs on each house
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid, cell);
                    house++;
                }
            }
        }



        int min = Integer.MAX_VALUE;
        // on each empty land, get sum of distance to all houses, find the min
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && cell[i][j].list.size() == house) {
                    int sum = 0;
                    for (Integer e : cell[i][j].list) {
                        sum = sum + e;
                    }
                    min = Math.min(min, sum);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int i, int j, int[][] grid, Cell[][] cell) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int dis = 0;
        // initial
        q.offer(new Point(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                // expand
                Point curr = q.poll();
                cell[curr.x][curr.y].list.add(dis);
                // generate
                for (int c = 0; c < 4; c++) {
                    int newX = curr.x + dx[c];
                    int newY= curr.y + dy[c];
                    if (newX >= 0 && newY >= 0 && newX < cell.length && newY < cell[0].length && !visited[newX][newY] && grid[newX][newY] == 0) {
                        q.offer(new Point(newX, newY));
                        visited[newX][newY] = true;

                    }
                }
            }
            dis++;
        }
    }
    private class Cell {
        // fields
        private List<Integer> list;

        // constructor
        private Cell() {
            this.list = new ArrayList<>();
        }
    }

    private class Point {
        // fields
        private int x;
        private int y;

        // constructor
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllPoints shortestDistanceFromAllPoints = new ShortestDistanceFromAllPoints();
        shortestDistanceFromAllPoints.shortestDistance(new int[][]{{0,2,1},{1,0,2},{0,1,0}});


    }
}
