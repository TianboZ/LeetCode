package debugLaicode;

import java.util.*;

public class SevenPuzzle {
    private static class Board {
        // fields
        int[][] m = new int[2][4];

        // constructor
        Board(int[] arr) {
            int k = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    m[i][j] = arr[k];
                    k++;
                }
            }
        }

        Board() {}

        // method
        public Board copy(Board b) {
            Board copy = new Board();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    copy.m[i][j] = b.m[i][j];
                }
            }
            return copy;
        }

        public void swap(int x, int y, int x2, int y2) {
            int tmpt = m[x][y];
            m[x][y] = m[x2][y2];
            m[x2][y2] = tmpt;
        }

        public int[] findZero() {
            int[] res = new int[2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (m[i][j] == 0) {
                        res[0] = i;
                        res[1] = j;
                        break;
                    }
                }
            }
            return res;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Board board = (Board) o;
            // https://stackoverflow.com/questions/2721033/java-arrays-equals-returns-false-for-two-dimensional-arrays
            return Arrays.deepEquals(m, board.m);
        }

        @Override
        public int hashCode() {
            // https://stackoverflow.com/questions/4003745/how-do-i-hash-a-2-d-array-efficiently-to-be-stored-in-a-hashset
            return Arrays.deepHashCode(m);
        }
    }
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int numOfSteps(int[] values) {
        // Write your solution here
        Board start = new Board(values);
        Board s2 = new Board(values);
        System.out.println(start.equals(s2));
        System.out.println(start.hashCode());
        System.out.println(s2.hashCode());


        Board end = new Board(new int[]{0, 1,2,3,4,5,6,7});

        Queue<Board> q = new LinkedList<>();
        Set<Board> set = new HashSet<>();
        int step = 0;

        // initial
        q.offer(start);
        set.add(start);

        // terminate
        label:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                // expand
                Board curr = q.poll();
                if (curr.equals(end)) {
                    break label;
                };
                // `0` coordinate
                int[] zero = curr.findZero();

                // generate
                for (int i = 0; i < 4; i++) {
                    // `0` surrounding coordinates
                    int x = zero[0] + dx[i];
                    int y = zero[1] + dy[i];
                    if (x >= 0 && x < 2 && y >= 0 && y < 4) {
                        Board next = new Board();
                        next = next.copy(curr);
                        next.swap(x, y, zero[0], zero[1]);
                        if (!set.contains(next)) {
                            set.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,3,5,0,6,7};
        SevenPuzzle sol  = new SevenPuzzle();
        int res = sol.numOfSteps(arr);
        System.out.println(res);
    }
}
