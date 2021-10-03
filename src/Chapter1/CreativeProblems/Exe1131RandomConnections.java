package Chapter1.CreativeProblems;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exe1131RandomConnections {
    public static void main(String[] args) {
        double probability = 1;
        int numberOfPoints = 10;
        drawCircle(numberOfPoints, probability);

    }
    public static void drawCircle(int numberOfPoints, double probability) {
        StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenRadius(.005);
        double[][] points = new double[numberOfPoints][2];
        for (int i = 0; i < numberOfPoints; i++) {
            double y = Math.sin(2 * Math.PI * i / numberOfPoints);
            double x = Math.cos(2 * Math.PI * i / numberOfPoints);
            StdDraw.point(x, y);
            points[i][0] = x;
            points[i][1] = y;
        }
        StdDraw.setPenRadius();
        randomlyConnect(points, probability);
    }
    public static void randomlyConnect(double[][] points, double probability){
        for (int i = 0; i < points.length; i++) {
            double curX = points[i][0];
            double curY = points[i][1];
            for (int j = 0; j < points.length; j++) {
                if (StdRandom.bernoulli(probability)) StdDraw.line(curX, curY, points[j][0], points[j][1]);
            }
        }
    }
}
