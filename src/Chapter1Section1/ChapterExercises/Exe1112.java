package Chapter1Section1.ChapterExercises;

public class Exe1112 {
    public static void main(String[] args) {
        exe1112();
    }

    static public void exe1112() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
