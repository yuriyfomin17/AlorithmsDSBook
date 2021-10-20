package Chapter1Section3.ChapterExercises;

public class Exe1333DequeArray {
    static class Deque<Item>{

        private Item[] leftArr = (Item[]) new Object[4];
        private int leftEnd = 0;
        private int leftStart = 0;
        private int leftSize = 0;

        private Item[] rightArr = (Item[]) new Object[4];
        private int rightEnd = 0;
        private int rightStart = 0;
        private int rightSize = 0;

        public void pushLeft(Item item) {
            if (leftEnd == leftArr.length) resizeLeft(leftArr.length * 2);
            leftArr[leftEnd++] = item;
            leftSize++;
        }
        public void pushRight(Item item) {
            if (rightEnd == rightArr.length) resizeRight(rightArr.length * 2);
             rightArr[rightEnd++] = item;
             rightSize++;
        }
        public Item popLeft() {
            Item item;
            if (leftEnd == leftArr.length / 4) resizeLeft(leftArr.length / 2);
            if (!leftIsEmpty()){
                item = leftArr[--leftEnd];
                leftArr[leftEnd] = null; // loitering
                leftSize--;
            } else {
                item = rightArr[rightStart];
                rightArr[rightStart] = null; // loitering
                rightStart+= 1;
                rightSize--;
            }

            return item;
        }
        public Item popRight() {
            Item item;
            if (rightEnd == rightArr.length / 4) resizeRight(rightArr.length / 2);
            if (!rightIsEmpty()){
                item = rightArr[--rightEnd];
                rightArr[rightEnd] = null; // loitering
                rightSize --;
            } else {
                item = leftArr[leftStart];
                leftArr[leftStart] = null; // loitering
                leftStart+=1;
                leftSize++;
            }

            return item;
        }

        @Override
        public String toString(){
            String result = "";
            for (int i = leftEnd - 1; i >= leftStart ; i--) result += " " + leftArr[i];
            for (int i = rightStart; i < rightEnd; i++) result += " " + rightArr[i];
            return result;
        }

        public boolean isEmpty(){ return (leftSize + rightSize) == 0; }
        public boolean leftIsEmpty(){ return leftSize == 0; }
        public boolean rightIsEmpty(){ return rightSize == 0; }
        public int size(){ return leftSize + rightSize; }
        public void resizeLeft(int size){
            Item[] newArr = (Item[]) new Object[size];
            int index = 0;
            for (int i = leftStart; i < leftEnd; i++) newArr[index++] = leftArr[i];

            leftStart = 0;
            leftEnd = index;
            leftArr = newArr;
        }
        public void resizeRight(int size){
            Item[] newArr = (Item[]) new Object[size];
            int index = 0;
            for (int i = rightStart; i < rightEnd ; i++) newArr[index++] = rightArr[i];
            rightStart = 0;
            rightEnd = index;
            rightArr = newArr;
        }
    }
    public static void main(String[] args) {
        testPushLeft();
        testPushRight();
        testPopLeftFullLeftArr();
        testPopLeftEmptyLeftArr();
        testPopRightFullRightArr();
        testPopRightEmptyRightArr();

    }
    public static void testPushLeft(){
        System.out.println("testPushLeft");
        Deque deque = new Deque();

        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushLeft("d");
        deque.pushLeft("e");
        System.out.println("Deque items: " + deque);
        System.out.println("Expected: e d c b a\n");

    }
    public static void testPushRight(){
        System.out.println("testPushRight");
        Deque deque = new Deque();

        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");
        deque.pushRight("d");
        deque.pushRight("e");
        System.out.println("Deque items: " + deque);
        System.out.println("Expected: a b c d e\n");
    }
    public static void testPopLeftFullLeftArr(){
        System.out.println("testPopLeftFullLeftArr");
        Deque deque = new Deque();

        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushLeft("d");
        deque.pushLeft("e");

        deque.popLeft();
        deque.popLeft();
        deque.popLeft();

        System.out.println("Deque items: " + deque);
        System.out.println("Expected: b a\n");
    }
    public static void testPopLeftEmptyLeftArr(){
        System.out.println("testPopLeftEmptyLeftArr");
        Deque deque = new Deque();

        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");
        deque.pushRight("d");
        deque.pushRight("e");

        deque.popLeft();
        deque.popLeft();
        deque.popLeft();

        System.out.println("Deque items: " + deque);
        System.out.println("Expected: d e\n");

    }
    public static void testPopRightFullRightArr(){
        System.out.println("testPopRightFullRightArr");

        Deque deque = new Deque();

        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");
        deque.pushRight("d");
        deque.pushRight("e");

        deque.popRight();
        deque.popRight();
        deque.popRight();
        System.out.println("Deque items: " + deque);
        System.out.println("Expected: a b\n");
    }
    public static void testPopRightEmptyRightArr(){
        System.out.println("testPopRightEmptyRightArr");

        Deque deque = new Deque();

        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushLeft("d");
        deque.pushLeft("e");

        deque.popRight();
        deque.popRight();
        deque.popRight();
        System.out.println("Deque items: " + deque);
        System.out.println("Expected: e d\n");
    }
}
