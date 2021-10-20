package Chapter1Section3.ChapterExercises;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Exe1334RandomBag {
    static class RandomBag<Item>{
        private int N = 0;
        private Item[] bag = (Item[]) new Object[4];

        public boolean isEmpty(){ return N == 0; }
        public int size(){ return N; }
        public void add(Item item){
            if (N == bag.length) resize(2 * bag.length);
            bag[N++] = item;
        }
        public void resize(int size){
            Item[] newArr = (Item[]) new Object[size];
            for (int i = 0; i < N; i++) newArr[i] = bag[i];
            bag = newArr;
        }

        private class RandomBagIterator implements Iterator<Item>{
            private int current = 0;
            public RandomBagIterator(){
                for (int i = 0; i < N; i++) {
                    int r = i + StdRandom.uniform(N - i);
                    Item temp = bag[i];
                    bag[i] = bag[r];
                    bag[r] = temp;
                }

            }
            @Override
            public boolean hasNext() {
                return current != N;
            }

            @Override
            public Item next() {
                return bag[current++];
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        RandomBag randomBag = new RandomBag();
        for (int i = 0; i < numbers.length; i++) randomBag.add(numbers[i]);

        RandomBag.RandomBagIterator randomBagIterator = randomBag.new RandomBagIterator();

        while (randomBagIterator.hasNext()) System.out.print(" "+ randomBagIterator.next());
    }
}
