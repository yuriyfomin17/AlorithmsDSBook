package Chapter1Section1.CreativeProblems;

import edu.princeton.cs.algs4.StdOut;

public class Exe1133MatrixAPI {
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
    public static double dot(double[]x, double[]y){  // ✅ checked
        if ((x == null || y == null) || (x.length != y.length)) throw new IllegalArgumentException();
        double sum = 0.0;
        for (int i = 0; i < y.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }

    public static double[] matrixVectorProduct(double[][] x, double[] y){ // ✅ checked
        // (numRows1 * numCols1) x (numRows2 * 1) = numRows1 * 1
        if (x == null || y == null || x[0].length != y.length ) throw new IllegalArgumentException();

        int numRows1 = x.length;
        int numCols1 = x[0].length;

        int numRows2 = y.length;
        int numCols2 = 1;

        double[] matrixResult = new double[numRows1];
        for (int r = 0; r < numRows1; r++) {
            for (int c = 0; c < numCols1; c++) {
                matrixResult[r] += x[r][c] * y[c];
            }
        }
        return matrixResult;
    }

    // transpose matrix
    public static double[][] transpose(double[][]a){ // ✅ checked
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
    public static double[] mult(double[][]x, double[] y){ // ✅ checked
        if ((x == null || y == null || x.length == 0 || y.length == 0)  || (x[0].length != y.length )) throw new IllegalArgumentException();
        int numRows1 = x.length;
        int numCols1 = x[0].length;

        int numCols2 = 1;
        int numRows2 = y.length;
        double[] matrixResult = new double[numRows1];
        // (numRows1 * numCols1) x (numRows2* 1) = numRows1 * 1
        for (int c = 0; c < numCols1; c++) {
            for (int r = 0; r < numRows1; r++) {
                matrixResult[r] += x[r][c] * y[c];
            }
        }
        return matrixResult;

    }
    // vector - matrix product
    public static double[] mult(double[] y, double[][]a){ // ✅ checked
        if ((y == null || a == null) || (y.length != a.length) ) throw new IllegalArgumentException();

        int numRows1 = 1;
        int numCols1 = y.length;

        int numRows2 = a.length;
        int numCols2 = a[0].length;
        // (1 * numCols1) x (numRows2 * numCols2) = 1 * numCols2
        double[] matrixResult = new double[numCols2];
        for (int c = 0; c < numCols2; c++) {
            for (int c1 = 0; c1 < numCols1; c1++) {
                matrixResult[c] += y[c1] * a[c1][c];
            }
        }
        return matrixResult;
    }
    public static double[] vectorMatrixProd(double[] y, double[][]x){ // ✅ checked
        // (1 * numCols1) x (numRows2 * numCols2) = 1 * numCols2
        if (y == null || x == null || y.length != x.length) throw new IllegalArgumentException();

        int numRows1 = 1;
        int numCols1 = y.length;

        int numRows2 = x.length;
        int numCols2 = x[0].length;

        double[] matrixResult = new double[x[0].length];

        for (int c = 0; c < numCols2; c++) {
            for (int r = 0; r < numRows2; r++) {
                matrixResult[c] += y[r] * x[r][c];
            }
        }
        return matrixResult;
    }
    public static  double[][] matrixMatrixProduct(double[][] x, double[][] y){ // ✅ checked
        // (numRows1 * numCols1) x (numRows2 * numCols2) = numRows1 * numCols2
        if (x == null || y == null || x[0].length != y.length ) throw new IllegalArgumentException();

        int numRows1 = x.length;
        int numCols1 = x[0].length;

        int numRows2 = y.length;
        int numCols2 = y[0].length;

        double[][] matrixResult = new double[numRows1][numCols2];

        for (int r = 0; r < numRows1; r++) {
            for (int c = 0; c < numCols2; c++) {
                for (int i = 0; i < numRows2; i++) {
                    matrixResult[r][c] += x[r][i] * y[i][c];
                }
            }
        }
        return matrixResult;
    }

    public static void main(String[] args) {
        double[][] matrix1 = {
                {1, 2 ,3},
                {4, 5 ,6},
                {7, 8 ,9},
        };
        double[] matrix2 = {1, 2, 3};
        Printer.print(vectorMatrixProd(matrix2, matrix1 ));
    }
}
