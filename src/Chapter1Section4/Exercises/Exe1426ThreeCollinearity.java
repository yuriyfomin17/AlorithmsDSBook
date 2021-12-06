package Chapter1Section4.Exercises;

import java.util.HashMap;

public class Exe1426ThreeCollinearity {

    public static void main(String[] args) {
        int[] arr = { -1, -2, 3, -1};
        System.out.println("Simple");
        System.out.println(threeSumSimple(arr));
        System.out.println("Scalar");
        System.out.println(threeSumScalarValue(arr));

    }
    public static boolean isCollinear(int a, int b, int c){
        double abDistance = (a - b) / (Math.pow(a, 3) - Math.pow(b, 3));
        double bcDistance = (b - c) / (Math.pow(b, 3) - Math.pow(c, 3));
        return abDistance == bcDistance;
    }
    public static double getScalarValue(int a, int b){
        return (a - b) / (Math.pow(a, 3) - Math.pow(b, 3));
    }
    public static int threeSumSimple(int[] arr){
        int cnt = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length ; b++) {
                for (int c = b + 1; c < arr.length; c++) {
//                    System.out.println("a: " +  arr[a]);
//                    System.out.println("b: " +  arr[b]);
//                    System.out.println("c: " +  arr[c]);
//                    System.out.println();
                    if (arr[a] + arr[b] + arr[c] == 0) {
//                        System.out.println("a: " +  arr[a]);
//                        System.out.println("b: " +  arr[b]);
//                        System.out.println("c: " +  arr[c]);
//                        System.out.println();
                        cnt++;
                    }

                }
            }
        }
        return cnt;
    }

    public static int threeSumScalarValue(int[] arr){
        int cnt = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length ; b++) {
                for (int c = b + 1; c < arr.length; c++) {
                    if (arr[a] + arr[b] +  arr[c] == 0 && isCollinear(arr[a], arr[b],  arr[c]) ) {
                        System.out.println("a: " +  arr[a]);
                        System.out.println("b: " +  arr[b]);
                        System.out.println("c: " +  arr[c]);
                        System.out.println();
                        cnt++;
                    }

                }
            }
        }
        return cnt;
    }
}
