package Chapter2.Section1.Exercises;

public class Exe211 {

    static class SelectionSort{
        public static void sort(String[] arr){
            int N = arr.length;
            for (int i = 0; i < N; i++) {
                int minIdx = i;
                for (int j = i + 1; j < N; j++) {
                    if (arr[minIdx].compareTo(arr[j]) > 0) minIdx = j;
                }

                String temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s", arr[i]);
        }
    }
}
