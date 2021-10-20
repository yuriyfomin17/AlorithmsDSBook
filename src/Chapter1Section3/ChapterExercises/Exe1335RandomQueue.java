package Chapter1Section3.ChapterExercises;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Exe1335RandomQueue {
    private static final String[] SUITS = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private static class Card{
        String suit;
        String value;

        public Card(String aSuit, String aValue){
            this.suit = aSuit;
            this.value = aValue;
        }
        @Override
        public String toString(){
            return this.suit + "-" + this.value;
        }
    }
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

        public int size(){ return N; }

        @Override
        public String toString(){
            String result = "";
            RandomQueueIterator randomQueueIterator = new RandomQueueIterator(false);
            while (randomQueueIterator.hasNext()) result += " " + randomQueueIterator.next();
            return result;
        }

        public String toStringRandomOrder(){
            String result = "";
            RandomQueueIterator randomQueueIterator = new RandomQueueIterator(true);
            while (randomQueueIterator.hasNext()) result += " " + randomQueueIterator.next();
            return result;
        }

        private class RandomQueueIterator implements Iterator<Item>{
            private int current = first;

            public RandomQueueIterator(boolean randomOrder){
                if (randomOrder){
                    for (int i = 0; i < N; i++) {
                        int randomIndex = i + StdRandom.uniform(N - i);

                        Item temp = randomQueue[randomIndex];
                        randomQueue[randomIndex] = randomQueue[i];
                        randomQueue[i] = temp;
                    }
                }
            }
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
        testSample();
        testDequeue();
        testCards();
    }

    public static void testDequeue(){
        System.out.println("\n");
        System.out.println("Test Dequeue\n");
        int[] numbers = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10};
        RandomQueue randomQueue = new RandomQueue();
        for (int i = 0; i < numbers.length; i++) randomQueue.enqueue(numbers[i]);

        System.out.println("Random Queue: " + randomQueue);

        System.out.print("Dequeue Queue:");
        while (!randomQueue.isEmpty()) System.out.print(" " + randomQueue.dequeue());
    }

    public static void testSample(){
        System.out.println("Test Sample");
        int[] numbers = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10};
        RandomQueue randomQueue = new RandomQueue();
        for (int i = 0; i < numbers.length; i++) randomQueue.enqueue(numbers[i]);

        System.out.println();
        System.out.println("Random Queue: " + randomQueue);

        System.out.print("Test Sample: ");
        int count = 0;
        while ( count++ != 10) System.out.print(" " + randomQueue.sample());
    }

    public static void testCards(){
        System.out.println("\n");
        System.out.println("Test Cards\n");
        RandomQueue randomQueue = new RandomQueue();
        for (int i = 0; i < SUITS.length; i++) {
            randomQueue.enqueue(new Card(SUITS[i], "A"));
            randomQueue.enqueue(new Card(SUITS[i], "K"));
            randomQueue.enqueue(new Card(SUITS[i], "Q"));
            randomQueue.enqueue(new Card(SUITS[i], "J"));
            randomQueue.enqueue(new Card(SUITS[i], "10"));
            randomQueue.enqueue(new Card(SUITS[i], "9"));
            randomQueue.enqueue(new Card(SUITS[i], "8"));
            randomQueue.enqueue(new Card(SUITS[i], "7"));
            randomQueue.enqueue(new Card(SUITS[i], "6"));
            randomQueue.enqueue(new Card(SUITS[i], "5"));
            randomQueue.enqueue(new Card(SUITS[i], "4"));
            randomQueue.enqueue(new Card(SUITS[i], "3"));
            randomQueue.enqueue(new Card(SUITS[i], "2"));
        }
        giveCards(randomQueue);
        giveRandomCard(randomQueue);
    }
    public static void giveCards(RandomQueue randomQueue){
        for (int i = 0; i < 2; i++) {
            int count = 0;
            System.out.println("Hand " + (i + 1) + "\n");
            // Bridge - 13 cards are given in game
            while (count++ < 13){
                System.out.println(randomQueue.dequeue());
            }
            System.out.println();
        }
    }
    public static void giveRandomCard(RandomQueue randomQueue){
        Card randomCard = (Card) randomQueue.sample();
        System.out.println("Size Before sample: " + randomQueue.size() + " Expected: 26");
        System.out.println("Random card: " + randomCard);
        System.out.println("Size after sample: " + randomQueue.size() + " Expected: 26");
    }
}
