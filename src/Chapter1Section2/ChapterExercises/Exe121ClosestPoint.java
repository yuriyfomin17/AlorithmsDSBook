package Chapter1Section2.ChapterExercises;

import edu.princeton.cs.algs4.StdDraw;

public class Exe121ClosestPoint {
    // Conclusion as you increase number of points minimum distance between them decreases
    public static void main(String[] args) {
        int N = 500; // num of points
        StdDraw.setScale(0, 1);
        StdDraw.setPenRadius(0.01);
        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            double randPointX = Math.random();
            double randPointY = Math.random();
            points[i][0] = randPointX;
            points[i][1] = randPointY;
            StdDraw.point(randPointX, randPointY);
        }

        double minDistance = Double.POSITIVE_INFINITY;
        for (double[] point: points) {
            for (int r = 0; r < points.length; r++) {
                double[] currPoint = points[r];
                if (point[0] != currPoint[0] || point[1] != currPoint[1])
                    minDistance = Math.min(minDistance, minDistance(point[0], point[1], currPoint[0], currPoint[1]));
            }
        }
        System.out.printf("Minimum distance from one pair of points is %.6f", minDistance);
    }
    public static double minDistance(double curX1, double curY1, double curX2, double curY2){
        return Math.sqrt((curX2 - curX1) * (curX2 - curX1) + (curY2 - curY1) * (curY2 - curY1));
    }
}
