/**
 * Created by ss030277 on 5/13/15.
 */
public class RotateImage {

    public static void main(String args[]) {
        Integer matrix[][] = { { 1,  2,  3,  4,  6},
                               { 5,  6,  7,  8,  7 },
                               { 9,  10, 11, 12, 8 },
                               { 13, 14, 15, 16, 9 },
                               { 10, 10, 10, 10, 10 }
                             };

        int n = matrix.length;
        double x = Math.ceil(((double) n) / 2.0);


        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < x; j++) {
                int temp = matrix[i][j];

                // Clockwise
//                matrix[i][j] = matrix[n-1-j][i];
//                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
//                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
//                matrix[j][n-1-i] = temp;

                // Counter-clockwise
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
