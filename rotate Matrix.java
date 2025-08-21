class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        
        // Step 1: Transpose of matrix
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row (for clockwise rotation)
        for (int i = 0; i < N; i++) {
            int left = 0, right = N - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
        /*
        // Alternative: Flip vertically (for anti-clockwise rotation)
        for (int col = 0; col < N; col++) {
            int top = 0, bottom = N - 1;
            while (top < bottom) {
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;
                top++;
                bottom--;
            }
        }
        */
    }
}
