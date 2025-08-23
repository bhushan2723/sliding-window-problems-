import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;

        Queue<int[]> q = new ArrayDeque<>(); // LinkedList नाही
        q.offer(new int[]{0, 0, k});

        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;

        int steps = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            while (size-- > 0) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1], rem = cur[2];

                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;

                    if (ni == m-1 && nj == n-1) return steps;

                    int nk = rem - grid[ni][nj];
                    if (nk >= 0 && !visited[ni][nj][nk]) {
                        visited[ni][nj][nk] = true;
                        q.offer(new int[]{ni, nj, nk});
                    }
                }
            }
        }
        return -1;
    }
}
