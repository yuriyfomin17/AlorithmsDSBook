package Chapter1Section3.ChapterExercises;

public class Exe131FixedCapacityStackOfStrings {
    private int N = 0;
    private String[] a;

    public Exe131FixedCapacityStackOfStrings(int size){
        a = new String[size];
    }
    public void push(String s){
        if (N == a.length) resize(2 * a.length);
        a[N++] = s;
    }
    public String pop(){
        String s = a[--N];
        a[N] = null; // loitering
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return s;
    }
    public boolean isEmpty(){ return N == 0;}
    public int size(){ return N;}
    public boolean isFull(){ return N == a.length; }

    public void resize(int size){
        String[] newArray = new String[size];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }
        a = newArray;
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4"};
        Exe131FixedCapacityStackOfStrings exe131FixedCapacityStackOfStrings = new Exe131FixedCapacityStackOfStrings(4);
        for (int i = 0; i < arr.length; i++) {
            exe131FixedCapacityStackOfStrings.push(arr[i]);
        }
        System.out.println(exe131FixedCapacityStackOfStrings.isFull());
    }
}
