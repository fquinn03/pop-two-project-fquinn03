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
        if(!fraction.contains("/")){
            numerator = parseInt(fraction);
            denominator = 1;
        }
        else
            try {
                String numeratorString = fraction.substring(0, fraction.indexOf("/"));
                numeratorString = numeratorString.trim();
                int numerator1 = parseInt(numeratorString);
                String denominatorString = (fraction.substring(fraction.indexOf("/") + 1));
                denominatorString = denominatorString.trim();
                int denominator1 = parseInt(denominatorString);
                this.numerator = (numerator1/findGCD(numerator1, denominator1));
                this.denominator = (denominator1/findGCD(numerator1, denominator1));
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
    public Fraction add(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int newNumerator = ((this.numerator*g.denominator)+(this.denominator*g.numerator));
        int newDenominator = (this.denominator*g.denominator);
        return new FractionImpl(newNumerator, newDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int NewNumerator = ((this.numerator*g.denominator)-(this.denominator*g.numerator));
        int NewDenominator = (this.denominator*g.denominator);
        return new FractionImpl(NewNumerator, NewDenominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int NewNumerator = this.numerator*g.numerator;
        int NewDenominator = this.denominator*g.denominator;
        return new FractionImpl(NewNumerator, NewDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int NewNumerator = this.numerator*g.denominator;
        int NewDenominator = this.denominator*g.numerator;
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
        if (obj instanceof Fraction) {
            double fractionAsDecimal = (double) (this.numerator) / (double) (this.denominator);
            FractionImpl m = (FractionImpl) (obj);
            double objectAsDecimal = (double) (m.numerator) / (double) (m.denominator);
            if (fractionAsDecimal == objectAsDecimal)
                return true;
        } else
            return false;
        return false;
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
       int  newDenominator = this.numerator;
       return new FractionImpl(newNumerator, newDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction f) {
        FractionImpl g = (FractionImpl) (f);
        double fractionAsDecimal = (double) (this.numerator) / (double) (this.denominator);
        double objectAsDecimal = (double) (g.numerator) / (double) (g.denominator);
        if (fractionAsDecimal > objectAsDecimal) {
            return 1;
        }
        else if (fractionAsDecimal < objectAsDecimal) {
            return -1;
        } else
            return 0;
   }
    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if(this.denominator != 1 || this.numerator == 0) {
            return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
        }
        else
            return String.valueOf(this.numerator);

    }

}