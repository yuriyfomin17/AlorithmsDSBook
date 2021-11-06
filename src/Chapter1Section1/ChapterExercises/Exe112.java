package Chapter1Section1.ChapterExercises;

public class Exe112 {
    public static void main(String[] args) {
        exe112();
    }

    static public void exe112() { // ✅ checked
        System.out.println((1 + 2.236) / 2); // a double 1.618
        System.out.println((1 + 2 + 3 + 4.0)); // b double 10.0
        System.out.println(4.1 >= 4); // c compares by converting 4 ro double
        System.out.println((1 + 2 + "3")); // d string "33"
    }
}
