package Chapter1Section3.ChapterExercises;

public class MyCircularQueue{
    private int read = 0;
    private int write = 0;
    private int last = 0;
    private int size = 0;
    private final int[] ringBuffer;

    public MyCircularQueue(int k) {
        ringBuffer = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        last = write;
        ringBuffer[write++] = value;
        write = write % ringBuffer.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        read++;
        read = read % ringBuffer.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return 0;
        return ringBuffer[read];
    }

    public int Rear() {
        if (isEmpty()) return 0;
        return ringBuffer[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == ringBuffer.length;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());

    }
}


