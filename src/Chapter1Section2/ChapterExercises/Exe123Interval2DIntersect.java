package Chapter1Section2.ChapterExercises;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class Exe123Interval2DIntersect {
    private static double min = 0;
    private static double max = 1;

    private static HashMap<Interval2D, Interval1D[]> hashMap = new HashMap<>();
    public static void main(String[] args) {
        checkThatTwoBoxContainedWithEachOther();
    }
    public static void generateSquare(){
        int N = 50;
        StdDraw.setCanvasSize(1024, 1024);
        Interval2D[] interval2D = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double[] minMax = maxMinGenerator();
            Interval1D xInterval = new Interval1D(minMax[0], minMax[1]);
            minMax = maxMinGenerator();
            Interval1D yInterval = new Interval1D(minMax[0], minMax[1]);
            Interval2D box = new Interval2D(xInterval, yInterval);

            Interval1D[] range = new Interval1D[2];
            range[0] = xInterval;
            range[1] = yInterval;
            hashMap.put(box, range);

            interval2D[i] = box;
            box.draw();
        }
        int countIntercept = 0;
        int countContainedWithinOneAnother = 0;
        HashSet<Interval2D> set = new HashSet<>();
        for (int i = 0; i < interval2D.length; i++) {
            Interval2D interval2D1 = interval2D[i];
            for (int j = 0; j < interval2D.length; j++) {
                Interval2D interval2D2 = interval2D[j];
                if (interval2D1.intersects(interval2D2)) countIntercept += 1;
                if (containedWithinEachOther(interval2D1, interval2D2)){
                    set.add(interval2D1);
                    set.add(interval2D2);
                    countContainedWithinOneAnother += 1;
                } else if (interval2D1.intersects(interval2D2)) {
                    countIntercept += 1;
                }
            }

        }
        System.out.printf("Number of intervals that intercept is %d\n", countIntercept);
        System.out.printf("Number of intervals that contained within one another is %d\n", countContainedWithinOneAnother);
    }
    public static boolean containedWithinEachOther(Interval2D interval2D1, Interval2D interval2D2){
        return interval2D1.area() == interval2D2.area() && interval2D1.equals(interval2D2);
    }
    public static double[] maxMinGenerator(){
        double aMin = StdRandom.uniform(min, max);
        double aMax = StdRandom.uniform(min, max);
        if (aMin > aMax){
            double temp = aMin;
            aMin = aMax;
            aMax = temp;
        }
        double[] result = new double[2];
        result[0] = aMin;
        result[1] = aMax;
        return result;
    }

    public static void  checkThatTwoBoxContainedWithEachOther(){
        int N = 2;

        double x1 = 0;
        double x2 = 0.5;

        double y1 = 0;
        double y2 = 0.5;

        Interval2D[] interval2DList = new Interval2D[N];
        double decrementor = 0;
        for (int i = 0; i < N; i++) {
            Interval1D xInterval = new Interval1D(x1 + decrementor, x2 - decrementor );
            Interval1D yInterval = new Interval1D(y1 + decrementor, y2 - decrementor);
            Interval2D box = new Interval2D(xInterval, yInterval);
            interval2DList[i] = box;
            Interval1D[] interval =  {xInterval, yInterval};
            hashMap.put(box, interval);
            box.draw();
            decrementor += 0.1;
        }
        Interval2D interval2D1 = interval2DList[0];
        Interval2D interval2D2 = interval2DList[1];
        if (interval2D1.area() == interval2D2.area() && interval2D1.equals(interval2D2)){
            System.out.println("They are equal");
        }
        if (isContained(interval2D1, interval2D2)){
            System.out.println("they are contained within one another ");
        }
    }
    public static boolean isContained(Interval2D interval2D1, Interval2D interval2D2){
        Interval1D[] interval1DS1 = hashMap.get(interval2D1);
        Interval1D[] interval1DS2 = hashMap.get(interval2D2);

        Interval1D interval1D1X = interval1DS1[0];
        Interval1D interval1D1Y = interval1DS1[1];

        Interval1D interval1D2X = interval1DS2[0];
        Interval1D interval1D2Y = interval1DS2[1];
        return (interval1D1X.min() > interval1D2X.min() && interval1D1X.max() < interval1D2X.max() && interval1D1Y.min() > interval1D2Y.min() && interval1D1Y.max() < interval1D2Y.max()) ||
                (interval1D2X.min() > interval1D1X.min() && interval1D2X.max() < interval1D1X.max() && interval1D2Y.min() > interval1D1Y.min() && interval1D2Y.max() < interval1D1Y.max());
    }

}
