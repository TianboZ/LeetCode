package MianJing.Indeed;


import java.util.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class OA18mj {
    // [描述] [截屏]https://instant.1point3acres.com/thread/289597
    // You are painting on a piece of paper that is divided into a grid. The way you point on this grid is you drop ink on a specific grid cell.
    // Each ink blot has a darkness value. When the ink is dropped, it bleeds to adjacent (excluding diagonal) cells. Each cell it travels,
    // the darkness value drops by 1. If two blots bleed to the same cell, the cell's darkness value is the higher of the two.
    //
    // 1. Initially, all cells are unpainted, and have a darkness of 0;
    // 2. Once ink reaches 0 darkness, it will not bleed any further;
    // 3. If a dot was placed at (dot_row, dot_col), when it bleeds to the cell(row, col), the cell's new darkness will either be:
    // dot_darkness - abs(dot_row - row) - abs(dow_col - col) or the current darkness value of the cell whichever is larger.
    //
    // Your task is to calculate the total darkness for each sheet of paper in a task, after all dots are painted onto them.
    //
    // [Input]
    // In this problem, you will be given N subtasks in the following format, via standard input:
    // N
    // paperAndDots_1
    // paperAndDots_2
    // .
    // .
    // .
    // paperAndDots_N
    //
    // The format for a specific sheet of paper is as follows:
    // The first line contains two integers H W, the height and width of the grid, respectively.
    // The second line contains a single integer numDots, the number of dots that were painted.
    // The following numDots lines each describe a dot. A dot consists of row col darkness, the row, column, and darkness value of the dot when it
    // was dropped.
    // H W
    // numDots
    // row_1        col_1       darkness_1
    // row_2        col_2       darkness_2
    // .
    // .
    // .
    // row_numDots, col_numDots darkness_numDots
    //
    // [Output]
    // For each paper, output the total darkness of the paper, which is calculated as the sum of the darkness of all of the cells
    // after all of the dots have finished bleeding.
    //
    // [Constraints]
    // 1 <= N <= 10 (number of different papers)
    // For each paper:
    //    1 <= H <= 500 (height of grid)
    //    1 <= W <= 500 (weight of grid)
    //    1 <= dot_num <= 10000;
    //
    // [解释] http://www.1point3acres.com/bbs/thread-296273-1-1.html
    // Input：
    // 	2 #代表2张纸
    // 	3 4 # 第一张纸的高和宽
    // 	2 # 第一张纸的墨水点数
    // 	0 0 255 # 第一张纸上第一个墨水点的row col value
    // 	1 2 255 # 第一张纸上第二个墨水点的row col value
    // 	5 6 # 第二张纸的高和宽
    // 	4   # 第二张纸的墨水点数
    // 	1 0 10
    // 	2 2 9
    // 	2 3 5
    // 	4 2 9
    // Output：
    // 	3046 #第一张纸
    // 	217 #第二张纸
    //
    // [更多解释和思路]
    // http://www.1point3acres.com/bbs/thread-299566-1-1.html
    // https://instant.1point3acres.com/thread/303351
    // http://www.1point3acres.com/bbs/thread-296202-1-1.html
    // Test Case 和 Python参考代码 dfs [fail] http://www.1point3acres.com/bbs/thread-296273-1-1.html
    //
    // [HackerRank输入输出格式和处理，可以参考下面例子]
    // https://www.hackerrank.com/challenges/torque-and-development/problem

    /*
     * 问题：
     *     1. 网上不少人留言说BFS或者DFS的方法会超时，不确定他们是不是用的和我一样的方法，但有两个人都说solution3的方法可以过，不确定是不是只是test case的问题；
     *     2. 四种方法的时间复杂度都是O(H * W * N) ? 但后面3种会省掉一些搜索。然而我的测试里好像第一种更快。
     */



    /************************************************************
     * Solution 3: DFS v2  --- ? 为什么会快，or 只是test case问题
     *
     * https://instant.1point3acres.com/thread/303351
     * http://www.1point3acres.com/bbs/thread-299566-1-1.html
     * 一共有12个test case，最后两个无论用DFS还是BFS并且考虑了darkness的排序都超时了。最后用了上面帖子里面楼主的方法，
     * 对x,y所在的行和列直接计算出darkness然后对四个对角线点(x-1, y-1), (x-1, y + 1), (x+1, y-1), (x+1, y+1)递归。
     ***********************************************************/
    // 与totalDarknessII一样
    public static int totalDarknessIII(int H, int W, int[][] dots) {
        int[][] grid = new int[H][W];
        int[] result = new int[1];

        // 按dots中的darkness降序排序，当当前dot的darkness小于起始位置的darkness时，则skip
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int[] dot: dots) {
            heap.add(dot);
        }

        while (!heap.isEmpty()) {
            int[] dot = heap.poll();
            int x = dot[0];
            int y = dot[1];
            int darkness = dot[2];

            if (grid[x][y] >= darkness) {
                continue;
            }

            dfs2(grid, x, y, darkness, result);
        }

		/*
		for (int[] g: grid) {
			for (int j: g) {
				System.out.print(j + ", ");
			}
			System.out.println();
		}
		*/
        return result[0];
    }

    private static void dfs2(int[][] grid, int x, int y, int darkness, int[] result) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && darkness > grid[x][y]) {

            for (int i = 0; i < grid.length; i++) {
                if (darkness - Math.abs(i - x) > 0) {
                    int cur = darkness - Math.abs(i - x);
                    if (cur > grid[i][y]) {
                        result[0] += cur - grid[i][y];
                        grid[i][y] = cur;
                    }
                }
            }

            for (int j = 0; j < grid[0].length; j++) {
                if (darkness - Math.abs(j - y) > 0) {
                    int cur = darkness - Math.abs(j - y);
                    if (cur > grid[x][j]) {
                        result[0] += cur - grid[x][j];
                        grid[x][j] = cur;
                    }
                }
            }
        } else {
            return;
        }

        dfs2(grid, x + 1, y + 1, darkness - 2, result);
        dfs2(grid, x - 1, y - 1, darkness - 2, result);
        dfs2(grid, x + 1, y - 1, darkness - 2, result);
        dfs2(grid, x - 1, y + 1, darkness - 2, result);
    }

    /////////////////////////////////// my solution //////////////////////////////////////////////////
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};
    public static int totalDarkness(int H, int W, int[][] dots) {
        int[][] matrix = new int[H][W];
        int[] res = new int[1]; // count total darkness

        List<int[]> list = new ArrayList<>(Arrays.asList(dots));
        Collections.sort(list, new CP());
        for (int[] arr : list) {
            int x = arr[0];
            int y = arr[1];
            int dark = arr[2];

            if (matrix[x][y] >= dark) continue;

            dfs(matrix, x, y, dark, res);
        }

        return res[0];
    }
    private static class CP implements  Comparator<int[]> {
        @Override
        public int compare(int[] arr1, int[] arr2) {
            if (arr1[2] == arr2[2]) return 0;
            return arr1[2] < arr2[2] ? 1 : -1;
        }
    }



    private static void dfs(int[][] matrix, int x, int y, int dark, int[] res) {
        // base-case
        if (dark <= matrix[x][y]) return;

        // recursive rule
        for (int i = 0; i < matrix.length; i++) {
            if (dark - Math.abs(i - x) > 0) {
                int curr = dark - Math.abs(i - x);
                if (curr > matrix[i][y]) {
                    res[0] = res[0] + curr - matrix[i][y];
                    matrix[i][y] = curr;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (dark - Math.abs(j - y) > 0) {
                int curr = dark - Math.abs(j - y);
                if (curr > matrix[x][j]) {
                    res[0] = res[0] +  curr - matrix[x][j];
                    matrix[x][j] = curr;
                }
            }
        }

        // try 4 diagonal direction
        for (int k = 0; k < 4; k++) {
            int xx = x + dx[k];
            int yy = y + dy[k];
            if (xx >= 0 && yy >= 0 && xx < matrix.length && yy < matrix[0].length) {
                dfs(matrix, xx, yy, dark - 2, res);
            }
        }
    }


    public static void main(String[] args) {
		/*
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // N张纸

        for (int i = 0; i < N; i++) {
        	int H = in.nextInt(); // 第i张纸的高
        	int W = in.nextInt(); // 第i张纸的宽
        	int numDots = in.nextInt(); // 第i张纸的墨水点数
        	int[][] dots = new int[numDots][3];

        	for (int j = 0; j < numDots; j++) {
        		for (int k = 0; k <= 2; k++) {
        			dots[j][k] = in.nextInt();
        		}
        	}

        	int result = totalDarkness(H, W, dots);
        	System.out.println(result);
        }

        in.close();
        */

        // Test
        int[][] dots1 = {{0, 0, 255}, {1, 2, 255}}; // 3046
        int[][] dots2 = {{1, 0, 10}, {2, 2, 9}, {2, 3, 5}, {4, 2, 9}}; // 217
        int[][] dots3 = {{0, 0, 255}};
        int[][] dots4 = {{0, 0, 255}, {1, 2, 235}, {0, 0, 255}, {5, 6, 200}, {100, 300, 255}, {200, 200, 255}};
        int[][] dots5 = {{2, 3, 100}, {3, 4, 200}, {4, 1, 150}};


        // Solution 3
        long startTime1 = System.nanoTime();
        System.out.println("###### Solution 3 ######");
        System.out.println(totalDarknessIII(3, 4, dots1));
        System.out.println(totalDarknessIII(5, 6, dots2));
        System.out.println(totalDarknessIII(3, 4, dots3));
        System.out.println(totalDarknessIII(450, 350, dots4));
        System.out.println(totalDarknessIII(15, 15, dots5));
        long endTime1 = System.nanoTime();
        long runTime1 = endTime1 - startTime1;
        System.out.println("Run time1 : " + runTime1);
        System.out.println();

        // my solution
        long startTime2 = System.nanoTime();
        System.out.println("###### my solution ######");
        System.out.println(totalDarkness(3, 4, dots1));
        System.out.println(totalDarkness(5, 6, dots2));
        System.out.println(totalDarkness(3, 4, dots3));
        System.out.println(totalDarkness(450, 350, dots4));
        System.out.println(totalDarkness(15, 15, dots5));
        long endTime2 = System.nanoTime();
        long runTime2 = endTime2 - startTime2;
        System.out.println("Run time2: " + runTime2);
    }
}

class Solution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        System.out.println("aaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaa");
        System.out.println();
        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nmC_libC_road[0]);
            int m = Integer.parseInt(nmC_libC_road[1]);
            int c_lib = Integer.parseInt(nmC_libC_road[2]);
            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
