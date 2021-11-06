package Chapter1Section1.ChapterExercises;

import edu.princeton.cs.algs4.StdOut;

public class Exe1113 {
    public static void main(String[] args) {
        exe1113();
    }

    static public void exe1113() { // ✅ checked -> transpose matrix
        class Printer {
            public static void print(int[][] mat) {
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        StdOut.print(mat[i][j] + " ");
                    }
                    StdOut.println();
                }

            }
        }
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Printer.print(matrix);
        System.out.println();
        int rowLength = matrix[0].length;
        int columnLength = matrix.length;
        int[][] transposeMatrix = new int[rowLength][columnLength];
        for (int r = 0; r < columnLength; r++) {
            for (int c = 0; c < rowLength; c++) {
                transposeMatrix[c][r] = matrix[r][c];
            }
        }
        Printer.print(transposeMatrix);


    }
}
