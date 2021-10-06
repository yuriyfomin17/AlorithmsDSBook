package Chapter1Section2.ChapterExercises;

public class Exe127Mystery {
    public static void main(String[] args) {
        int d = 2/ 3;
        System.out.println(d);
        // it reverses string
        System.out.println(mystery("abcdefg"));
    }
    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
}
