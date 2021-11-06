package Chapter1Section1.ChapterNotes;

public class HarmonicNumber {
    public static void main(String[] args) {
        System.out.println(HarmonicNum(5));
        int [] arr = {2, 1, 3, 6, 5, 4};
        sortArr(arr);
        System.out.println(arr);
    }
    public static double HarmonicNum(int N){
        double sum = 0;
        for (int i = 1; i <= N ; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
    public static void sortArr(int[] arr){
        arr = new int[]{1};
    }
}
