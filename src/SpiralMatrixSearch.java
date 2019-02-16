public class SpiralMatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        int colCount = matrix[0].length;
        return search(matrix, target, 0, matrix.length * colCount - 1, colCount);
    }

    private boolean search(int[][] matrix, int target, int start, int end, int colCount) {
        if (start >= end) {
            return false;
        }

        if (value(matrix, start , colCount) == target || value(matrix, end , colCount) == target) {
            return true;
        }

        int mid = (end - start)/2;
        if (value(matrix, mid, colCount) == target) {
            return true;
        } else {
            if (value(matrix, mid, colCount) > target) {
               return search(matrix, target, start, mid - 1, colCount);
            } else {
                return search(matrix, target, start, mid + 1, colCount);
            }
        }
    }

    private int value(int[][] matrix, int index, int n) {
        int row = index/n;
        int col = index % n;
        return matrix[row][col];
    }
}
