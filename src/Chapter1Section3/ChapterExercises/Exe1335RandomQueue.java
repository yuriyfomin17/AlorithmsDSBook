package Chapter1Section3.ChapterExercises;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Exe1335RandomQueue {
    static class RandomQueue<Item>{
        private int N = 0;
        private int last = 0;
        private int first = 0;
        private Item[] randomQueue = (Item[]) new Object[4];
        // is queue empty
        public boolean isEmpty(){ return N == 0; }

        // add an item
        public void enqueue(Item item){
            if (last == randomQueue.length) resize(randomQueue.length * 2);
            randomQueue[last++] = item;
            N++;
        }

        // remove and return random item
        // (sample without replacement)
        public Item dequeue(){
            if (isEmpty()) return null;
            if ((last - first) == randomQueue.length / 4) resize(randomQueue.length / 2);
            int index = randomIndex();

            Item temp = randomQueue[index];
            randomQueue[index] = randomQueue[first];
            randomQueue[first] = temp;
            randomQueue[first++] = null; // avoid loitering

            N--;

            return temp;
        }

        // return a random item, but do not remove
        // (sample with replacement)
        public Item sample(){
            if (isEmpty()) return null;
            int index = randomIndex();

            Item temp = randomQueue[index];
            randomQueue[index] = randomQueue[first];
            randomQueue[first] = temp;
            return temp;
        }

        // generate random possible index
        public int randomIndex(){ return StdRandom.uniform(first, last); }

        // resize if size is too small or too big
        public void resize(int size){
            Item[] newArr = (Item[]) new Object[size];
            int index = 0;
            for (int i = first; i < last; i++) newArr[index++] = randomQueue[i];
            first = 0;
            last = index;
            randomQueue = newArr;
        }

        @Override
        public String toString(){
            String result = "";
            RandomQueueIterator randomQueueIterator = new RandomQueueIterator();
            while (randomQueueIterator.hasNext()) result += " " + randomQueueIterator.next();
            return result;
        }

        private class RandomQueueIterator implements Iterator<Item>{
            private int current = first;

            @Override
            public boolean hasNext() {
                return current != last;
            }

            @Override
            public Item next() {
                return randomQueue[current++];
            }
        }
    }

    public static void main(String[] args) { testRandomQueue(); }

    public static void testRandomQueue(){
        int[] numbers = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10};
        RandomQueue randomQueue = new RandomQueue();
        for (int i = 0; i < numbers.length; i++) randomQueue.enqueue(numbers[i]);

        int count = 0;
        System.out.print("Random Iteration:");
        while (count != 10) {
            System.out.print(" " + randomQueue.sample());
            count+= 1;
        }
        System.out.println();
        System.out.println("Random Queue: " + randomQueue);
        System.out.print("Dequeue Queue:");
        while (!randomQueue.isEmpty()) System.out.print(" " + randomQueue.dequeue());
    }
}
