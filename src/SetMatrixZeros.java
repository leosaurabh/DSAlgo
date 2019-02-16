public class SetMatrixZeros {

    public void matrixMod(Integer[][] mat) {
        if (mat == null) {
            return;
        }

        int numRows = mat.length;
        int numCols = mat[0].length;

        boolean markFirstRowZero = false;
        for (int i =0; i<numCols; i++) {
            if (mat[0][i] == 0) {
                markFirstRowZero = true;
                break;
            }
        }

        boolean markFirstColZero = false;
        for (int i =0; i<numRows; i++) {
            if (mat[i][0] == 0) {
                markFirstColZero = true;
                break;
            }
        }

        // set markers to row and col
        for (int i =0; i<numRows; i++) {
            for (int j =0; j<numCols; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // if marked, set element to 0
        for (int i =0; i<numRows; i++) {
            for (int j =0; j<numCols; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (markFirstRowZero) {
            for (int i =0; i<numCols; i++) {
                mat[0][i] = 0;
            }
        }

        if (markFirstColZero) {
            for (int i =0; i<numRows; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
