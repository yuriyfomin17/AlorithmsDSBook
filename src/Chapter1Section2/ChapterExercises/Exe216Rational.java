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

        Exe216Rational rationalNumber3 = new Exe216Rational(2, 6);
        Exe216Rational rationalNumber4 = new Exe216Rational(3, 18);

        System.out.println(rationalNumber3.plus(rationalNumber4)+ ": expected 1/2");
        System.out.println(rationalNumber3.minus(rationalNumber4) + ": expected 1/6");
        System.out.println(rationalNumber3.times(rationalNumber4) + ": expected 1/18");
        System.out.println(rationalNumber3.divides(rationalNumber4) + ": expected 2");
        System.out.println(rationalNumber3.equals(rationalNumber4) + ": expected false");
        System.out.println(rationalNumber3);
        System.out.println(rationalNumber4);
    }
    public Exe216Rational(long numerator, long denominator){
        long commonFactor = euclidAlgorithm(numerator, denominator);
        numerator /= commonFactor;
        denominator /= commonFactor;

        if (euclidAlgorithm(numerator, denominator) != 1) throw new IllegalArgumentException("This is not rational number!");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Exe216Rational plus(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long commonDenominator;
        if (aDenominator > this.denominator && aDenominator % this.denominator == 0) commonDenominator = aDenominator;
        else if (this.denominator > aDenominator && this.denominator % aDenominator == 0) commonDenominator = this.denominator;
        else commonDenominator = this.denominator * aDenominator;

        long numerator1 = (commonDenominator / aDenominator) * aNumerator;
        long numerator2 = (commonDenominator / this.denominator) * this.numerator;

        return new Exe216Rational(numerator1 + numerator2, commonDenominator);
    }

    public Exe216Rational minus(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long commonDenominator;
        if (aDenominator > this.denominator && aDenominator % this.denominator == 0) commonDenominator = aDenominator;
        else if (this.denominator > aDenominator && this.denominator % aDenominator == 0) commonDenominator = this.denominator;
        else commonDenominator = this.denominator * aDenominator;

        long numerator1 = (commonDenominator / aDenominator) * aNumerator;
        long numerator2 = (commonDenominator / this.denominator) * this.numerator;

        return new Exe216Rational(numerator2 - numerator1, commonDenominator);
    }
    public Exe216Rational times(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

        long newNumerator = aNumerator * this.numerator;
        long newDenominator = aDenominator * this.denominator;

        long commonFactor = euclidAlgorithm(newNumerator, newDenominator);

        newNumerator /= commonFactor;
        newDenominator /= commonFactor;

        return new Exe216Rational(newNumerator, newDenominator);

    }

    public Exe216Rational divides(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();


        long commonFactorNumeratorNumerator = euclidAlgorithm(aNumerator, this.numerator);
        long commonFactorDenominatorDenominator = euclidAlgorithm(aDenominator, this.denominator);

        long newNumerator = (this.numerator / commonFactorNumeratorNumerator) * (aDenominator / commonFactorDenominatorDenominator);

        long newDenominator = (this.denominator / commonFactorDenominatorDenominator) * (aNumerator / commonFactorNumeratorNumerator);

        return new Exe216Rational(newNumerator, newDenominator);

    }

    public boolean equals(Exe216Rational aRationalNumber){
        long aNumerator = aRationalNumber.getNumerator();
        long aDenominator = aRationalNumber.getDenominator();

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
