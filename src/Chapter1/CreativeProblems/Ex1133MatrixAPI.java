package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;

public class Ex1133MatrixAPI {
    class Printer {
        public static void print(double[][] mat) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    StdOut.print(mat[i][j] + " ");
                }
                StdOut.println();
            }

        }
        public static void print(double[] mat) {
            for (int i = 0; i < mat.length; i++) {
                StdOut.print(mat[i] + " ");
                StdOut.println();
            }

        }
    }
    // vector dot product
    public static double dot(double[]x, double[]y){
        if ((x == null || y == null) || (x.length != y.length)) throw new IllegalArgumentException();
        double sum = 0.0;
        for (int i = 0; i < y.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }
    // multiplying matrix by another matrix
    public static double[][] mult(double[][] x, double[][] y){
        if ((x == null || y == null) || (x[0].length != y.length)) throw new IllegalArgumentException();
        int numRows1 = x.length;
        int numCols1 = x[0].length;

        int numRows2 = y.length;
        int numCols2 = y[0].length;
        // (numRows1 * numCols1) x (numRows2 * numCols2) = numRows1 * numCols2
        double[][] resultMatrix = new double[numRows1][numCols2];
        for (int r = 0; r < numRows1; r++) {
            for (int c = 0; c < numCols2; c++) {
                for (int i = 0; i < numCols1; i++) {
                    resultMatrix[r][c] += x[r][i] * y[i][c];
                }
            }

        }
        return resultMatrix;
    }

    // transpose matrix
    public static double[][] transpose(double[][]a){
        if (a == null) throw new IllegalArgumentException();
        int numRows = a.length;
        int numCols = a[0].length;

        double[][] transposeMatrix = new double[numCols][numRows];

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                transposeMatrix[c][r] = a[r][c];
            }
        }
        return transposeMatrix;
    }
    // matrix-vector product
    public static double[] mult(double[][]x, double[] y){
        if ((x == null || y == null) || (x[0].length != y.length )) throw new IllegalArgumentException();
        int numRows1 = x.length;
        int numCols1 = x[0].length;

        int numRows2 = y.length;
        int numCols2 = 1;
        double[] matrixResult = new double[numRows1];
        // (numRows1 * numCols1) x (numRows2 * numCols2) = numRows1 * numCols2
        for (int r = 0; r < numRows1; r++) {
            for (int c = 0; c < numCols2; c++) {
                for (int i = 0; i < numRows2; i++) {
                    matrixResult[r] += x[r][i] * y[i];
                }
            }

        }
        return matrixResult;

    }
    // vector - matrix product
    public static double[] mult(double[] y, double[][]a){
        if ((y == null || a == null) || (y.length != a.length) ) throw new IllegalArgumentException();

        int numRows1 = y.length;
        int numCols1 = 1;

        int numRows2 = a.length;
        int numCols2 = a[0].length;
        // (numRows1 * numCols1) x (numRows2 * numCols2) = numRows1 * numCols2
        double[] matrixResult = new double[numCols2];
        for (int r = 0; r < numRows1; r++) {
            for (int c = 0; c < numCols2; c++) {
                for (int i = 0; i < numCols1; i++) {
                    matrixResult[c] += y[c] * a[r][i];
                }
            }
        }
        return matrixResult;
    }

    public static void main(String[] args) {
        double[][] matrix1 = {
                {1, 2 ,3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] matrix2 = {
                {1, 2 ,3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Printer.print(mult(matrix1, matrix2 ));
    }
}
