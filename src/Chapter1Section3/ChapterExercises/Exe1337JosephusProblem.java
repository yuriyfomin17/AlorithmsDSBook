package Chapter1Section3.ChapterExercises;

public class Exe1337JosephusProblem {
    static class Queue<Item>{
        private int N = 0;
        private Node first = null;
        private Node last = null;

        public void enqueue(Item item){
            Node oldLast = this.last;

            this.last = new Node();
            this.last.item = item;

            if (isEmpty()) this.first = this.last;
            else oldLast.next = this.last;
            N++;
        }
        public Node dequeue(){
            Node node = this.first;
            this.first = this.first.next;
            N--;
            return node;
        }
        public boolean isEmpty(){ return this.first == null; }
        public int size(){ return N; }
    }

    public static void main(String[] args) {
        testJoseph(41, 2);
    }

    public static void testJoseph(int numberOfPeople, int personOrder){
        Queue queue = new Queue();
        for (int i = 0; i < numberOfPeople; i++) queue.enqueue(i);
        int count = 1;
        int lastNumber = 0;
        while (!queue.isEmpty()){
            Node node = queue.dequeue();
            lastNumber = (int) node.item;
            if (count == personOrder ) {
                System.out.print(" " + node.item);
                count = 0;
            } else queue.enqueue(node.item);
            count += 1;
        }
        String correctResult = getJosephCorrectResult(numberOfPeople);

        // we are beginning with 0 hence to convert to human numbers add 1
        String lastNumberBinaryString = toBinaryString(lastNumber + 1);
        if (lastNumberBinaryString.equals(correctResult)) System.out.println("CORRECT!");

    }
    public static String toBinaryString(int num){
        System.out.println();
        String binaryNumber = "";
        while (num > 0){
            if (num % 2 == 0) binaryNumber = (num % 2) + binaryNumber;
            else binaryNumber = "1" + binaryNumber;
            num = num / 2;
        }
        return removeRedundantZeros(binaryNumber);

    }
    // Mathematically it can be proved that correct result can be achieved by
    // converting number into binary representation then shifting the last right bit
    // to the left
    public static String getJosephCorrectResult(int N){
        String binaryNumber = toBinaryString(N);
        String result = binaryNumber.substring(1) + binaryNumber.charAt(0);
        return removeRedundantZeros(result);
    }

    public static String removeRedundantZeros(String binaryNumber){
        if (!binaryNumber.startsWith("0")) return binaryNumber;
        return removeRedundantZeros(binaryNumber.substring(1));
    }
}
