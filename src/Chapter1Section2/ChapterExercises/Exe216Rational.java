package Chapter1Section2.ChapterExercises;

public class Exe216Rational {
    private long numerator;
    private long denominator;
    public static void main(String[] args) {
        Exe216Rational rationalNumber1 = new Exe216Rational(5, 18);
        Exe216Rational rationalNumber2 = new Exe216Rational(3, 7);

        System.out.println(rationalNumber1.plus(rationalNumber2)+ ": expected 89/126");
        System.out.println(rationalNumber1.minus(rationalNumber2) + ": expected -19/126");
        System.out.println(rationalNumber1.times(rationalNumber2) + ": expected 5/42");
        System.out.println(rationalNumber1.divides(rationalNumber2) + ": expected 35/54");
        System.out.println(rationalNumber1.equals(rationalNumber2) + ": expected false");
        System.out.println(rationalNumber1);
        System.out.println(rationalNumber2);
        System.out.println();

        Exe216Rational rationalNumber3 = new Exe216Rational(2, 6);
        Exe216Rational rationalNumber4 = new Exe216Rational(3, 18);

        System.out.println(rationalNumber3.plus(rationalNumber4)+ ": expected 1/2");
        System.out.println(rationalNumber3.minus(rationalNumber4) + ": expected 1/6");
        System.out.println(rationalNumber3.times(rationalNumber4) + ": expected 1/18");
        System.out.println(rationalNumber3.divides(rationalNumber4) + ": expected 2");
        System.out.println(rationalNumber3.equals(rationalNumber4) + ": expected false");
        System.out.println(rationalNumber3);
        System.out.println(rationalNumber4);
        System.out.println();

        Exe216Rational rationalNumber5 = new Exe216Rational(1, 3);
        Exe216Rational rationalNumber6 = new Exe216Rational(1, 3);

        System.out.println(rationalNumber5.plus(rationalNumber6)+ ": expected 2/3");
        System.out.println(rationalNumber5.minus(rationalNumber6) + ": expected 0/1");
        System.out.println(rationalNumber5.times(rationalNumber6) + ": expected 1/9");
        System.out.println(rationalNumber5.divides(rationalNumber6) + ": expected 1/1");
        System.out.println(rationalNumber5.equals(rationalNumber6) + ": expected true");
        System.out.println(rationalNumber5);
        System.out.println(rationalNumber6);
        System.out.println();

        Exe216Rational rationalNumber7 = new Exe216Rational(1, 4);
        Exe216Rational rationalNumber8 = new Exe216Rational(2, 3);

        System.out.println(rationalNumber7.plus(rationalNumber8)+ ": expected 11/12");
        System.out.println(rationalNumber7.minus(rationalNumber8) + ": expected -5/12");
        System.out.println(rationalNumber7.times(rationalNumber8) + ": expected 1/6");
        System.out.println(rationalNumber7.divides(rationalNumber8) + ": expected 3/8");
        System.out.println(rationalNumber7.equals(rationalNumber8) + ": expected false");
        System.out.println(rationalNumber7);
        System.out.println(rationalNumber8);
        System.out.println();
    }
    public Exe216Rational(long numerator, long denominator){

        if (denominator == 0) throw new RuntimeException("Denominator cannot be 0");

        long commonFactor = euclidAlgorithm(numerator, denominator);
        numerator /= commonFactor;
        denominator /= commonFactor;

        this.numerator = numerator;
        this.denominator = denominator;
        if (this.denominator < 0) {
            this.denominator = -1 * this.denominator;
            this.numerator = -1 * this.numerator;
        }
    }

    public Exe216Rational plus(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long newDenominator = aDenominator * this.denominator;
        long newNumerator = aNumerator * (newDenominator / aDenominator) +  this.numerator * (newDenominator / this.denominator);

        return new Exe216Rational(newNumerator, newDenominator);
    }

    public Exe216Rational minus(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long newDenominator = aDenominator * this.denominator;
        long newNumerator = this.numerator * (newDenominator / this.denominator) - aNumerator * (newDenominator / aDenominator);

        return new Exe216Rational(newNumerator, newDenominator);
    }
    public Exe216Rational times(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long newNumerator = aNumerator * this.numerator;
        long newDenominator = aDenominator * this.denominator;

        return new Exe216Rational(newNumerator, newDenominator);

    }

    public Exe216Rational divides(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long newNumerator = this.numerator * aDenominator;
        long newDenominator = this.denominator * aNumerator;

        return new Exe216Rational(newNumerator, newDenominator);

    }

    @Override public boolean equals(Object aRationalNumber){
        if (this == aRationalNumber) return true;
        if (aRationalNumber == null) return false;
        if (getClass() != aRationalNumber.getClass()) return false;

        Exe216Rational exe216Rational =  (Exe216Rational) aRationalNumber;
        long aNumerator = exe216Rational.getNumerator();
        long aDenominator = exe216Rational.getDenominator();

        return this.numerator == aNumerator && this.denominator == aDenominator;
    }

    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public static long euclidAlgorithm(long numerator, long denominator){
        if (numerator % denominator == 0) return denominator;
        long remainder = numerator % denominator;
        return euclidAlgorithm(denominator, remainder);
    }
}
