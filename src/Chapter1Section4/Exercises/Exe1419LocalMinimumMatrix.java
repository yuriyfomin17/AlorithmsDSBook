package Chapter1Section4.Exercises;

public class Exe1419LocalMinimumMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {9, 3, 5, 2, 4, 9, 8},
                {7, 2, 5, 1, 4, 0, 3},
                {9, 8, 9, 3, 2, 4, 8},
                {7, 6, 3, 1, 3, 2, 3},
                {9, 0, 6, 0, 4, 6, 4},
                {8, 9, 8, 0, 5, 3, 0},
                {2, 1, 2, 1, 1, 1, 1}
        };
        int matrix1[][] = {{1}};

        int matrix2[][] = {
                {4, 1},
                {3, -2}
        };
        int matrix3[][] = {
                {5, 2, 3},
                {4, 6, 1},
                {7, 8, 9}
        };
        int matrix4[][] = {
                {5, 90, 3, 10},
                {4, -9, 1, 15},
                {7, -1, 9, 19},
                {12, 8, 13, 99}
        };
        int matrix5[][] = {
                {5, 90, 3, 10},
                {4, 1, -7, 15},
                {7, -1, -8, 19},
                {12, 8, 13, 99}
        };
//        System.out.println("<-------------Matrix Maximum------------->");
//        System.out.println("Matrix Peak: " + localMaximumMatrix(matrix, 0, matrix[0].length) + " Expected: 9 or 8 or 5");
//        System.out.println("Matrix Peak: " + localMaximumMatrix(matrix1, 0, matrix1[0].length) + " Expected: 1");
//        System.out.println("Matrix Peak: " + localMaximumMatrix(matrix2, 0, matrix2[0].length) + " Expected: 4");
//        System.out.println("Matrix Peak: " + localMaximumMatrix(matrix3, 0, matrix3[0].length) + " Expected: 5 or 9");
//        System.out.println("Matrix Peak: " + localMaximumMatrix(matrix4, 0, matrix4[0].length) + " Expected: 90 or 12 or 99");
//        System.out.println("Matrix Peak: " + localMaximumMatrix(matrix5, 0, matrix5[0].length) + " Expected: 90 or 12 or 99\n");
//
//        System.out.println("<-------------Matrix Minimum------------->");
//        System.out.println("Matrix Minimum: " + localMinimumMatrix(matrix, 0, matrix[0].length) + " Expected: 0 or 1 or 2");
//        System.out.println("Matrix Minimum: " + localMinimumMatrix(matrix1, 0, matrix1[0].length) + " Expected: 1");
//        System.out.println("Matrix Minimum: " + localMinimumMatrix(matrix2, 0, matrix2[0].length) + " Expected: -2");
//        System.out.println("Matrix Minimum: " + localMinimumMatrix(matrix3, 0, matrix3[0].length) + " Expected: 1 or 2 or 4");
//        System.out.println("Matrix Minimum: " + localMinimumMatrix(matrix4, 0, matrix4[0].length) + " Expected: -9");
//        System.out.println("Matrix Minimum: " + localMinimumMatrix(matrix5, 0, matrix5[0].length) + " Expected: -8\n");
//
        System.out.println("<---------Matrix Maximum faster-------------> ");
        System.out.println("Matrix Maximum: " + localMaximumMatrixFaster(matrix, 0, matrix.length, 0, matrix[0].length) + " Expected: 9 or 5 or 8 or 6\n");
        System.out.println("Matrix Maximum: " + localMaximumMatrixFaster(matrix1, 0, matrix1.length, 0, matrix1[0].length) + " Expected: 1\n");
        System.out.println("Matrix Maximum: " + localMaximumMatrixFaster(matrix2, 0, matrix2.length, 0, matrix2[0].length) + " Expected: 4\n");
        System.out.println("Matrix Maximum: " + localMaximumMatrixFaster(matrix3, 0, matrix3.length, 0, matrix3[0].length) + " Expected: 3 or 5 or 9\n");
        System.out.println("Matrix Maximum: " + localMaximumMatrixFaster(matrix4, 0, matrix4.length, 0, matrix4[0].length) + " Expected: 90 or 12 or 99\n");
        System.out.println("Matrix Maximum: " + localMaximumMatrixFaster(matrix5, 0, matrix5.length, 0, matrix5[0].length) + " Expected: 90 or 12 or 99\n");

        System.out.println("<-------------Matrix Minimum------------->");
        System.out.println("Matrix Minimum: " + localMinimumMatrixFaster(matrix, 0, matrix.length, 0, matrix[0].length) + " Expected: 0 or 1 or 2");
        System.out.println("Matrix Minimum: " + localMinimumMatrixFaster(matrix1, 0, matrix1.length, 0, matrix1[0].length) + " Expected: 1");
        System.out.println("Matrix Minimum: " + localMinimumMatrixFaster(matrix2, 0, matrix2.length, 0, matrix2[0].length) + " Expected: -2");
        System.out.println("Matrix Minimum: " + localMinimumMatrixFaster(matrix3, 0, matrix3.length, 0, matrix3[0].length) + " Expected: 1 or 2 or 4");
        System.out.println("Matrix Minimum: " + localMinimumMatrixFaster(matrix4, 0, matrix4.length, 0, matrix4[0].length) + " Expected: -9");
        System.out.println("Matrix Minimum: " + localMinimumMatrixFaster(matrix5, 0, matrix5.length, 0, matrix5[0].length) + " Expected: -8\n");

    }

    // To find max element in column we would need O(N). Moving left or right would take O(log(N)) iterations
    // => O(N log(N)) time total. Also, assumed that out of matrix boundaries we have negative infinity
    public static Object localMaximumMatrix(int[][] matrix, int low, int high) {
        int columnMid = low + (high - low) / 2;
        int columnMax = matrix[0][columnMid];
        int rowMaxIdx = 0;
        int colMaxIdx = columnMid;
        for (int r = 1; r < matrix.length; r++)
            if (matrix[r][columnMid] > columnMax) {
                columnMax = matrix[r][columnMid];
                rowMaxIdx = r;
                colMaxIdx = columnMid;
            }

        int topNum = rowMaxIdx - 1 >= 0 ? matrix[rowMaxIdx - 1][columnMid] : -Integer.MAX_VALUE;
        int botNum = rowMaxIdx + 1 < matrix.length ? matrix[rowMaxIdx + 1][columnMid] : -Integer.MAX_VALUE;
        int leftNum = colMaxIdx - 1 >= 0 ? matrix[rowMaxIdx][colMaxIdx - 1] : -Integer.MAX_VALUE;
        int rightNum = colMaxIdx + 1 < matrix.length ? matrix[rowMaxIdx][colMaxIdx + 1] : -Integer.MAX_VALUE;

        int midPeak = matrix[rowMaxIdx][colMaxIdx];
        if (midPeak > topNum && midPeak > botNum && midPeak > leftNum && midPeak > rightNum) return midPeak;
        else if (rightNum > midPeak) return localMaximumMatrix(matrix, columnMid + 1, high);
        else if (leftNum > midPeak) return localMaximumMatrix(matrix, low, columnMid - 1);
        return null;
    }

    // to find min element in column we would need O(N). Moving to the left or right would take O(log(N)) iterations
    // => O(Nlog(N)) time total. Also, assumed that out of matrix boundaries we have positive infinity
    public static Object localMinimumMatrix(int[][] matrix, int low, int high) {
        int columnMidIdx = low + (high - low) / 2;

        int currentMin = matrix[0][columnMidIdx];
        int minRowIdx = 0;
        for (int r = 1; r < matrix.length; r++) {
            if (currentMin > matrix[r][columnMidIdx]) {
                minRowIdx = r;
                currentMin = matrix[r][columnMidIdx];
            }
        }

        int leftNum = columnMidIdx - 1 >= 0 ? matrix[minRowIdx][columnMidIdx - 1] : Integer.MAX_VALUE;
        int rightNum = columnMidIdx + 1 < matrix[0].length ? matrix[minRowIdx][columnMidIdx + 1] : Integer.MAX_VALUE;

        int localMin = matrix[minRowIdx][columnMidIdx];
        if (localMin < leftNum && localMin < rightNum) {

            return localMin;
        } else if (localMin > rightNum) return localMinimumMatrix(matrix, columnMidIdx + 1, high);
        else if (localMin > leftNum) return localMinimumMatrix(matrix, low, columnMidIdx - 1);
        else return null;

    }

    // to find local maximum we would need an O(N). We take the middle column and row. Find the maximum in this cross
    // Check neighbour elements for bigger element. If we find a bigger one then we move to this quadrant and repeat the process again
    // Find maximum in new smaller cross
    //
    public static Object localMaximumMatrixFaster(int[][] matrix, int lowR, int highR, int lowC, int highC)  {
        int midR = lowR + (highR - lowR) / 2;
        int midC = lowC + (highC - lowC) / 2;

        int maxMidNum = matrix[midR][midC];
        int maxRIdx = midR;
        int maxCIdx = midC;

        int topItem = midR - 1 >= 0 ? matrix[midR - 1][midC] : -Integer.MAX_VALUE;
        int botItem = midR + 1 < matrix.length ? matrix[midR + 1][midC] : -Integer.MAX_VALUE;
        int leftItem = midC - 1 >= 0 ? matrix[midR][midC - 1] : -Integer.MAX_VALUE;
        int rightItem = midC + 1 < matrix[0].length ? matrix[midR][midC + 1] : -Integer.MAX_VALUE;
        int midItem = matrix[midR][midC];

        if (midItem > topItem && midItem > botItem && midItem > leftItem && midItem > rightItem) return midItem;

        // find max from bottom -> down in middle column
        for (int r = lowR; r < highR; r++) {
            if (maxMidNum < matrix[r][midC]) {
                maxMidNum = matrix[r][midC];
                maxRIdx = r;
            }
        }
        // find max from left -> right in middle row
        for (int c = lowC; c < highC; c++) {
            if (maxMidNum < matrix[midR][c]) {
                maxMidNum = matrix[midR][c];
                maxCIdx = c;
                maxRIdx = midR;
            }

        }

        boolean top = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        // find left, right, top, bottom neighbour numbers
        topItem = maxRIdx - 1 >= 0 ? matrix[maxRIdx - 1][maxCIdx] : -Integer.MAX_VALUE;
        botItem = maxRIdx + 1 < matrix.length ? matrix[maxRIdx + 1][maxCIdx]: -Integer.MAX_VALUE;
        leftItem = maxCIdx - 1 >= 0 ? matrix[maxRIdx][maxCIdx - 1] : -Integer.MAX_VALUE;
        rightItem = maxCIdx + 1 < matrix[0].length ? matrix[maxRIdx][maxCIdx + 1] : -Integer.MAX_VALUE;


        // determine where to go. if mid row index is equal to the max row index. Then you can go only top or bottom
        //                     *
        //                     *
        //                     *      up
        // row index * * * * * * * *  here  * * *
        //                     *      down
        //                     *
        //                     *
        if (maxRIdx == midR && maxCIdx != midC && topItem > maxMidNum) top = true;
        else if (maxRIdx == midR && maxCIdx != midC && botItem > maxMidNum) down = true;
        else top = true;

        // determine where to go. if mid col index is equal to the max col index. Then you can go only left or right
        //                 col index
        //                     *
        //             left   here   right
        //                     *
        //           * * * * * * * * * * * *
        //                     *
        //                     *
        //                     *
        if (maxCIdx == midC && maxRIdx != midR && leftItem > maxMidNum) left = true;
        else if (maxCIdx == midC && maxRIdx != midR && rightItem > maxMidNum) right = true;
        else left = true;

        if (top && left) return localMaximumMatrixFaster(matrix, lowR, midR - 1, lowC, midC - 1);
        else if (top && right) return localMaximumMatrixFaster(matrix, lowR, midR - 1, midC + 1, highC);
        else if (down && left) return localMaximumMatrixFaster(matrix, midR + 1, highR, lowC, midC - 1);
        else if (down && right) return localMaximumMatrixFaster(matrix, midR + 1, highR, midC + 1, highC);
        return null;
    }

    public static Object localMinimumMatrixFaster(int[][] matrix, int lowR, int highR, int lowC, int highC) {
//        System.out.println("lowC: " + lowC);
//        System.out.println("highC: " + highC);
        int midR = lowR + (highR - lowR) / 2;
        int midC = lowC + (highC - lowC) / 2;
//        System.out.println("midR: " + midR);
//        System.out.println("midC: " + midC);
//        System.out.println();
        int midNum = matrix[midR][midC];

        int topNum = midR - 1 >= 0 ? matrix[midR - 1][midC] : Integer.MAX_VALUE;
        int botNum = midR + 1 < matrix.length ? matrix[midR + 1][midC] : Integer.MAX_VALUE;
        int leftNum = midC - 1 >= 0 ? matrix[midR][midC - 1] : Integer.MAX_VALUE;
        int rightNum = midC + 1 < matrix[0].length ? matrix[midR][midC + 1] : Integer.MAX_VALUE;

//        System.out.println("Mid Num: " + midNum);
//        System.out.println("Left Num: " + leftNum);
//        System.out.println("Right Num: " + rightNum);
//        System.out.println("Top Num: " + topNum);
//        System.out.println("Bot Num: " + botNum);
//        System.out.println();
        if (midNum < topNum && midNum < botNum && midNum < leftNum && midNum < rightNum) return midNum;

        int minRowIdx = midR;
        int minColIdx = midC;
        // find minimum number in the current matrix cross
        for (int r = 0; r < matrix.length; r++) {
//            System.out.println("Row: " + r);
            if (matrix[r][midC] < midNum) {
                midNum = matrix[r][midC];
                minRowIdx = r;
            }
        }
//        System.out.println();
        for (int c = 0; c < matrix[0].length; c++) {
//            System.out.println("Col: " + c);
            if (matrix[midR][c] < midNum) {
                midNum = matrix[midR][c];
                minRowIdx = midR;
                minColIdx = c;
            }
        }

        boolean top = false;
        boolean bot = false;
        boolean left = false;
        boolean right = false;
        leftNum = minColIdx - 1 >= 0  ? matrix[minRowIdx][minColIdx - 1] : Integer.MAX_VALUE;
        rightNum = minColIdx + 1 < matrix[0].length ? matrix[minRowIdx][minColIdx + 1] : Integer.MAX_VALUE;
        topNum = minRowIdx - 1 >= 0 ? matrix[minRowIdx - 1][minColIdx] : Integer.MAX_VALUE;
        botNum = minRowIdx + 1 < matrix.length ? matrix[minRowIdx + 1][minColIdx] : Integer.MAX_VALUE;
        if (midNum < topNum && midNum < botNum && midNum < leftNum && midNum < rightNum) return midNum;

        if (minRowIdx == midR && minColIdx != midC && topNum < midNum) top = true;
        else if (minRowIdx == midR && minColIdx != midC && botNum < midNum) bot = true;
        else top = true;

        if (minColIdx == midC && minRowIdx != midR && leftNum < midNum) left = true;
        else if (minColIdx == midC && minRowIdx != midC && rightNum < midNum) right = true;
        else left = true;

        if (top && left) return localMinimumMatrixFaster(matrix, lowR, midR - 1, lowC, midC - 1);
        else if (top && right) return localMinimumMatrixFaster(matrix, lowR, midR - 1, midC + 1, highC);
        else if (bot && left) return localMinimumMatrixFaster(matrix, midR + 1, highR, lowC, midC - 1);
        else if (bot && right) return localMinimumMatrixFaster(matrix, midR + 1, highR, midC + 1, highC);

        return null;
    }
}
