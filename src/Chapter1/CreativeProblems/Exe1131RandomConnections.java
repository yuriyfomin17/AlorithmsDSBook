package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdDraw;

public class Exe1131RandomConnections {
    public static void main(String[] args) {
//        double step = 2.5 / 50;
//        StdDraw.setYscale(-0.1, 2.1);
//        StdDraw.setXscale(-0.1, 2.1);
//        for (double i = 0; i <= 2; i+= step) {
//            StdDraw.point(i, circleFuncNeg(i));
//            StdDraw.point(i, circleFuncPos(i));
//        }
        drawCircle(1, 1, 1, 5);

    }
    public static void drawCircle(double centerX, double centerY, double r, int numberOfPoints){
        // for each x value we plot two points
        double step = ((centerX + r) - (centerX - r)) / (numberOfPoints / 2);
        StdDraw.setYscale(centerY - r - 0.2, centerY + r + 0.2);
        StdDraw.setXscale(centerX - r - 0.2, centerX + r + 0.2);
        StdDraw.setPenRadius(.01);
        for (double i = centerX - r; i <= centerX + r; i+= step) {
            StdDraw.point(i, circleFuncNeg(i, centerX, centerY));
            StdDraw.point(i, circleFuncPos(i, centerX, centerY));
        }
    }
    public static double circleFuncNeg(double x, double centerX, double centerY){
        return centerY - Math.sqrt(1 - (x - centerX) * (x - centerX));
    }
    public static double circleFuncPos(double x, double centerX, double centerY){
        return centerY + Math.sqrt(1 - (x - centerX) * (x - centerX));
    }
}
