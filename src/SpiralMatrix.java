/**
 * Created by ss030277 on 5/8/15.
 */
public class SpiralMatrix {

    public static void main(String args[]) {
        Integer matrix[][] = { { 1,  2,  3,  4,  6},
                               { 5,  6,  7,  8,  7 },
                               { 9,  10, 11, 12, 8 },
                               { 13, 14, 15, 16, 9 },
                               { 10, 10, 10, 10, 10 }
        };
        printSpiralMatrix(matrix);
    }

    private static void printSpiralMatrix(Integer[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int i = 0;
        int j = 0;
        int xLimit = matrix.length;
        int xStart = 0;
        int yLimit = matrix[xStart].length;
        int yStart = 0;

        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;

        while (i < xLimit && j < yLimit) {
            if (right) {
                if (j < yLimit) {
                    System.out.println(matrix[i][j]);
                }
                if (j == yLimit-1) {
                    right = false;
                    down = true;
                    ++i;
                } else {
                    ++j;
                }
            }
            if (down) {
                if (i < xLimit) {
                    System.out.println(matrix[i][j]);
                }
                if (i == xLimit-1) {
                    left = true;
                    down = false;
                    --j;
                } else {
                    ++i;
                }
            }
            if (left) {
                if (j >= yStart) {
                    System.out.println(matrix[i][j]);
                }
                if (j == yStart) {
                    up = true;
                    left = false;
                    ++yStart;
                    ++xStart;
                    --yLimit;
                    --xLimit;
                    --i;
                } else {
                    --j;
                }
            }
            if (up) {
                if (i >= xStart) {
                    System.out.println(matrix[i][j]);
                }
                if (i == xStart) {
                    right = true;
                    up = false;
                    i = xStart;
                    j = yStart;
                } else {
                    --i;
                }
            }
        }
    }
}
