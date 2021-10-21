package Chapter1Section3.ChapterExercises;

import java.util.Iterator;

public class Exe1339RingBuffer {
    static class RingBuffer<Item>{
        private int writePos = 0;
        private int readPos = 0;
        private int last = 0;
        private int size = 0;
        private int[] ringBuffer;
        public RingBuffer(int size){
            ringBuffer = new int[size];
        }

        public boolean enQueue(int item){
            if (isFull()) return false;

            last = writePos;
            ringBuffer[writePos++] = item;
            writePos = writePos % ringBuffer.length;
            size++;
            return true;
        }

        public boolean deQueue(){
            if (isEmpty()) return false;
            readPos++;
            readPos = readPos % ringBuffer.length;
            size--;
            return true;
        }
        // return first element
        public int Front(){
            if (isEmpty()) return -1;
            return ringBuffer[readPos];
        }
        // return last element
        public int Rear(){
            if (isEmpty()) return -1;
            return ringBuffer[last];
        }

        public boolean isEmpty(){
            return size == 0;
        }
        public boolean isFull(){
            return size == ringBuffer.length;
        }

    }

}
