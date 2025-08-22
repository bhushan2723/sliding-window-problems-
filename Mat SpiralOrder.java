import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) 
            return result;

        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns

        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        int id = 0;
        // id = 0 → left  to right
        // id = 1 → top   to down
        // id = 2 → right to left
        // id = 3 → down  to top

        while (top <= down && left <= right) {
            if (id == 0) {
                // left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } 
            else if (id == 1) {
                // top to down
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } 
            else if (id == 2) {
                // right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            } 
            else if (id == 3) {
                // down to top
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            id = (id + 1) % 4;
        }

        return result;
    }
}
