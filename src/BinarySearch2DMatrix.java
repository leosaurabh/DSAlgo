/**
 * Created by ss030277 on 5/12/15.
 */
public class BinarySearch2DMatrix {

    public static void main(String args[]) {
        Integer matrix[][] = {  { 1,  2,  3,  4,  6},
                                { 5,  6,  7,  8,  7 },
                                { 9,  10, 11, 12, 8 },
                                { 13, 14, 15, 16, 9 },
                                { 10, 10, 10, 10, 10 }
                            };

        int height = matrix.length;
        int width = matrix[0].length;

        int start = 0;
        int end = height*width - 1;

        int toFind = 15;
        int posI;
        int posJ;

        while (true) {
            int mid = (end+start)/2;

            int i = mid/width;
            int j = mid%width;

            if (matrix[i][j] < toFind) {
                start = mid+1;
            } else if (matrix[i][j] > toFind) {
                end = mid - 1;
            } else {
                posI = i;
                posJ = j;
                break;
            }
        }

        System.out.println(posI + ", " + posJ + " > " + matrix[posI][posJ]);
    }
}
