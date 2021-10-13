package Chapter1Section3.ChapterExercises;

public class Exe138DoublingStackOfStrings {
    private int N = 0;
    private String[] a;

    Exe138DoublingStackOfStrings(){
        this.a = new String[5];
    }

    public void push(String item){
        a[N++] = item;
        if (N == a.length) resize(a.length * 2);
    }
    public String pop(){
        String item = a[--N];
        if (N > 0 && N == a.length / 4 ) resize(a.length / 2);
        return item;
    }
    public void resize(int size){
        String[] newArr = new String[size];
        for (int i = 0; i < N; i++) {
            newArr[i] = a[i];
        }
        a = newArr;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    public static void main(String[] args) {
        String s = "it was - the best - of times - - - it was - the - -";
        Exe138DoublingStackOfStrings exe138DoublingStackOfStrings = new Exe138DoublingStackOfStrings();
        for (int i = 0; i < s.length(); i++) {
            String currString = Character.toString(s.charAt(i));
            if (!currString.equals("-")) exe138DoublingStackOfStrings.push(currString);
            else if (!exe138DoublingStackOfStrings.isEmpty()) System.out.println(exe138DoublingStackOfStrings.pop());
        }
        System.out.println(exe138DoublingStackOfStrings.size());
    }
}
