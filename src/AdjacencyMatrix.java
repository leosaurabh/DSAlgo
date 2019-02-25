import java.util.Arrays;
import java.util.List;

public class AdjacencyMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] { {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 0} };
        System.out.println(isCylic(matrix));
    }

    static boolean isCylic(int[][] matrix) {
        if (matrix == null) {
            return false;
        }

        int length = matrix.length;
        if (length == 0) {
            return false;
        }

        boolean[] visited = new boolean[length];
        return check(matrix, visited, length, 0);
    }

    private static boolean check(int[][] matrix, boolean[] visited, int length, int index) {
        if (visited[index]) {
            return true;
        } else {
            for (int i = 0; i < length; i++) {
                if (matrix[index][i] == 1) {
                    visited[index] = true;

                    if (check(matrix, visited, length, i)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private static void shortestPath(int[][] matrix, List<Integer> path, List<Integer> temp, int cx, int cy, int x, int y) {
        if (cx >= 0 && cx < matrix.length && cy >= 0 && cy < matrix[0].length) {
            if (matrix[cx][cy] == 1) {
                return;
            } else {
                if (cx == x && cy == y) {
                    if (temp.size() < path.size()) {
                        path.clear();
                        path.addAll(temp);
                        temp.remove(temp.size() - 1);
                    }
                } else {
                    temp.add(10 * cx + cy);
                }
            }

            shortestPath(matrix, path, temp, cx, cy - 1, x, y);
            shortestPath(matrix, path, temp, cx, cy + 1, x, y);
            shortestPath(matrix, path, temp, cx - 1, cy, x, y);
            shortestPath(matrix, path, temp, cx + 1, cy, x, y);
        }
    }
}
