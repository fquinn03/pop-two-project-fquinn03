/**
 * Created by fquinn03 on 28/11/2018.
 */
package fraction;

import static java.lang.Integer.parseInt;


public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    private int numerator;
    private int denominator;

    private static int findGCD(int numerator, int denominator) {

        if(denominator == 0){
            return numerator;
        }
        return findGCD(denominator, numerator%denominator);
    }

    public FractionImpl(int numerator, int denominator) {
        this.numerator = (numerator/findGCD(numerator, denominator));
        this.denominator = (denominator/findGCD(numerator, denominator));
        if (this.denominator == 0){
            throw new ArithmeticException("The denominator can not be zero. ");
        }
        if (this.denominator < 0){
            this.numerator*=-1;
            this.denominator*=-1;
        }
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */

    public FractionImpl(String fraction) {

       try {
            numerator = parseInt(fraction.substring(0, fraction.indexOf("/")));
            denominator = parseInt(fraction.substring(fraction.indexOf("/") + 1));
            this.numerator = (numerator/findGCD(numerator, denominator));
            this.denominator = (denominator/findGCD(numerator, denominator));
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Mixed fractions should be entered as improper fractions with no spaces. Input '7/4' rather than '1 3/4' ");
        }

        if (this.denominator == 0){
            throw new ArithmeticException("The denominator can not be zero. ");
        }
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(FractionImpl f) {
        int NewNumerator = ((this.numerator*f.denominator)+(this.denominator*f.numerator));
        int NewDenominator = (this.denominator*f.denominator);
        return new FractionImpl(NewNumerator, NewDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(FractionImpl f) {
        int NewNumerator = ((this.numerator*f.denominator)-(this.denominator*f.numerator));
        int NewDenominator = (this.denominator*f.denominator);
        return new FractionImpl(NewNumerator, NewDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(FractionImpl f) {
        int NewNumerator = this.numerator*f.numerator;
        int NewDenominator = this.denominator*f.denominator;
        return new FractionImpl(NewNumerator, NewDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(FractionImpl f) {
        int NewNumerator = this.numerator*f.denominator;
        int NewDenominator = this.denominator*f.numerator;
        if (NewDenominator == 0){
            throw new ArithmeticException("You can not divide by zero. ");
        }
        return new FractionImpl(NewNumerator, NewDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        if(this.numerator < 0) {
            this.numerator *= -1;
        }
        if(this.denominator < 0){
            this.denominator *= -1;
        }

        return new FractionImpl(this.numerator, this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int newNumerator = this.numerator*-1;
        return new FractionImpl(newNumerator, this.denominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
       int newNumerator = this.denominator;
       int  newDenomintor = this.numerator;
        return new FractionImpl(newNumerator, newDenomintor);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if(this.denominator != 1 || this.numerator == 0) {
            String s = String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
            return s;
        }
        else
            return String.valueOf(this.numerator);

    }

}