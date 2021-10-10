package Chapter1Section3.ChapterExercises;

public class Exe134Parentheses {
    private int N = 0;
    private String[] a;

    public Exe134Parentheses(int size){
        a = new String[size];
    }
    public boolean isEmpty(){ return N == 0; }
    public int size(){ return N; }
    public void push(String s){
        if (N == a.length) resize(2 * a.length);
        a[N++] = s;
    }
    public String pop(){
        String s = a[--N];
        a[N] = null; // lotering
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return s;
    }
    public void resize(int size){
        String[] newArr = new String[size];
        for (int i = 0; i < N; i++) {
            newArr[i] = a[i];
        }
        a = newArr;
    }

    public static void main(String[] args) {
        String s = "[()][()()]()";
        System.out.println(isParenthesesClosed(s));
    }

    public static boolean isParenthesesClosed(String s){
        Exe134Parentheses exe134Parentheses = new Exe134Parentheses(s.length());
        for (int i = 0; i < s.length(); i++) {
            String s1 = Character.toString(s.charAt(i));
            if (!isClosingBracket(s1)) {
                exe134Parentheses.push(s1);
            } else {
                String openingBracket = exe134Parentheses.pop();
                if (openingBracket.equals("(") && !s1.equals(")")) return false;
                if (openingBracket.equals("{") && !s1.equals("}")) return false;
                if (openingBracket.equals("[") && !s1.equals("]")) return false;
            }
        }
        return exe134Parentheses.isEmpty();
    }

    public static boolean isClosingBracket(String s){
        if (s.equals("]") || s.equals(")") || s.equals("}")) return true;
        return false;
    }
}
