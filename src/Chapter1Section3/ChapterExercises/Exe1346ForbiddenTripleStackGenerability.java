package Chapter1Section3.ChapterExercises;

public class Exe1346ForbiddenTripleStackGenerability {
    public static void main(String[] args) {

        // Suppose that there is a forbidden triple (a, b, c) i.e. a < b < c. c is popped first which means that
        // stack already has a and b since a and b were pushed before c. Therefore a can't be popped before b

        // suppose that number 1, 2, 3 ... N-1 are pushed in order to the stack.
        // It can be proved that last popped item will be always bigger then current numbers in the stack
        // E.g. N is popped from the stack this means that N - 1 and N - 2 were pushed before N to the stack. Hence, N is popped first.
        // Therefore N - 2 can't be popped before N - 1
    }
}
