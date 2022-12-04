public class MovingAverage {
    private final double[] window; // use this data structure

    // you can add other fields here
    private int index = 0;
    private boolean full = false;


    /*
     * Always invoked with windowSize > 0
     */
    public MovingAverage(int windowSize) {
        if(!(windowSize > 0)) throw new RuntimeException("Incorrect parameter!");
        window = new double[windowSize];
    }

    /*
     * Adds the number to window if it is larger than the value of 2.0d.
     * If window is full then replace the oldest added number in the window with the number provided.
     */
    public void addNumberToWindow(double number) {
        //TODO
        if (number > 2.0) {


            window[index++] = number;
            if (index == window.length){
                full = true;
                index  = index % (window.length);
            }
        }

    }

    /*
     * Return the average of the numbers added that are currently present in the window.
     * Otherwise when no numbers in window return 0.0d
     */
    public double getAverage() {
        //TODO
        double sum = 0;
        if (full){
            for (int i =0; i< window.length; i++){
                sum += window[i];
            }
        }else {
            for (int i =0; i<= index; i++){
                sum += window[i];
            }
        }

        if (full) return  sum / window.length;
        return sum / (index);
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(4);
        movingAverage.addNumberToWindow(1.5d);
        movingAverage.addNumberToWindow(2.5d);
        System.out.println(movingAverage.getAverage()); // prints 2.5
        movingAverage.addNumberToWindow(3.0d);
        movingAverage.addNumberToWindow(3.5d);
        System.out.println(movingAverage.getAverage()); // prints 3.0
        movingAverage.addNumberToWindow(2.0d);
        System.out.println(movingAverage.getAverage()); // prints 3.0
        movingAverage.addNumberToWindow(7.0d);
        System.out.println(movingAverage.getAverage()); // prints 4.0
        movingAverage.addNumberToWindow(6.5d);
        System.out.println(movingAverage.getAverage()); // prints 5.0
    }
}