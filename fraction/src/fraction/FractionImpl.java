/**
 * Created by fquinn03 on 28/11/2018.
 */
package fraction;
import com.sun.jdi.IntegerValue;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class FractionImpl implements Fraction {
    /**
     * Individual fractions are made up of both numerator and denominator
     * @param numerator
     * @param denominator
     */
    private int numerator;
    private int denominator;

    /**
     * Euclid's theorem function to find GCD
     * @param numerator
     * @param denominator
     * @return the greatest common denominator(GCD) of both the integer and the numerator.
     * This GCD used to normalise the fraction as it is created.
     */

    private static int findGCD(int numerator, int denominator) {
        if(denominator == 0){
            return numerator;
        }
        return findGCD(denominator, numerator%denominator);
    }

    /**
     * Constructs a Fraction from the numerator and denominator.
     * Normalises the fraction at construction using the gcd.
     * Throws an arithmetic error if the denominator is zero
     * A negative fraction is represented with a negative numerator.
     * @param numerator
     * @param denominator
     */

    public FractionImpl(int numerator, int denominator) {
        int gcd = findGCD(numerator, denominator);
        this.numerator = (numerator/gcd);
        this.denominator = (denominator/gcd);
        if (this.denominator == 0){
            throw new ArithmeticException("The denominator can not be zero. ");
        }
        /* A negative fraction is represented with a negative numerator.*/
        if (this.denominator < 0){
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }
    /**
     * Constructs a Fraction from a whole number
     * The parameter is the numerator and 1 is the implicit denominator.
     * @param wholeNumber represents the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }
    /**
     * Constructs a Fraction from a string
     * The parameter is a string containing either a whole number, such as `5` or `-3`, or a fraction, such as "8/-12".
     * Blanks are allowed around (but not within) integers.
     * The constructor throws a NumberFormatException if blanks are found within the integers.
     * The constructor throws an ArithmeticException if given a string representing a fraction whose denominator is zero.
     * @param fraction the string representation of the fraction

     */

    public FractionImpl(String fraction) {
        /* if fraction is a whole number*/
        if(!fraction.contains("/")){
            /*use trim to remove space before and after integers in the string.*/
            String trim = fraction.trim();
            this.numerator = parseInt(trim);
            this.denominator = 1;
        }
        else
            try {
                /* If the fraction is a string. Break it into two strings. One before and after the "/"
                Then trim these strings and parsed for integers */
                String numeratorString = fraction.substring(0, fraction.indexOf("/"));
                numeratorString = numeratorString.trim();
                int numerator1 = parseInt(numeratorString);
                String denominatorString = (fraction.substring(fraction.indexOf("/") + 1));
                denominatorString = denominatorString.trim();
                int denominator1 = parseInt(denominatorString);
                /* Normalise fraction at creation */
                int gcd = findGCD(numerator1, denominator1);
                this.numerator = (numerator1/gcd);
                this.denominator = (denominator1/gcd);
            }
            /* If there are spaces between the integers in the fraction string. A number format error is thrown */
            catch(NumberFormatException e) {
                throw new NumberFormatException("Mixed fractions should be entered as improper fractions with no spaces. Input '7/4' rather than '1 3/4' ");
            }

            if (this.denominator == 0){
                throw new ArithmeticException("The denominator can not be zero. ");
            }
            /*If the denominator is negative. Represent the fraction with a negative numerator instead.*/
            if (this.denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
        }

    }

    /**
     * Adds a fraction to this fraction.
     * @param f the fraction to add to this fraction
     * @return new fraction which is the sum of the current fraction added to f
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int newNumerator = ((this.numerator*g.denominator)+(this.denominator*g.numerator));
        int newDenominator = (this.denominator*g.denominator);
        return new FractionImpl(newNumerator, newDenominator);
    }
    /**
     * Subracts a fraction from this fraction.
     * @param f the fraction to subtract from this fraction
     * @return a new fraction which is the sum of this fraction minus f
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int NewNumerator = ((this.numerator*g.denominator)-(this.denominator*g.numerator));
        int NewDenominator = (this.denominator*g.denominator);
        return new FractionImpl(NewNumerator, NewDenominator);

    }

    /**
     * Multiplies this fraction by Fraction f
     * @param f the fraction to multiply this fraction by.
     * @return a new fraction which is the sum of this fraction multiplied by f
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl g = (FractionImpl)(f);
        int NewNumerator = this.numerator*g.numerator;
        int NewDenominator = this.denominator*g.denominator;
        return new FractionImpl(NewNumerator, NewDenominator);
    }

    /**
     * Divides this fraction by Fraction f
     * @param f the fraction which this fraction is divided by.
     * @return a new fraction which is the sum of the current fraction divided by f
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
     * returns the absolute value of this fraction.
     * If this fraction is not negative, this fraction is returned.
     * If this fraction is negative, the negation of this fraction is returned.
     * @return a new fraction which is the absolute value of this fraction
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
     * Returns a fraction that has the same numeric value of the this fraction,
     * but the opposite sign.
     * @return  a new fraction which is the negation of this fraction
     */
    @Override
    public Fraction negate() {
        int newNumerator = this.numerator*-1;
        return new FractionImpl(newNumerator, this.denominator);

    }

    /**
     * @return Returns a hash code value for this fraction.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns true if o is a fraction and is equal to this fraction
     * otherwise it returns false.
     * @param o the object to compare this fraction to
     * @return boolean true or false
     */
    @Override
    public boolean equals(Object o) {
        /*checks if o is a fraction*/
        if (o instanceof Fraction){
            FractionImpl m = (FractionImpl) (o);
            if(this.numerator == m.numerator && this.denominator == m.denominator){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Creates and returns a copy of this object.
     * Throws CloneNotSupportedException throw this exception to indicate that an fraction cannot be cloned.
     * @return returns a copy of this fraction.
     * @throws CloneNotSupportedException if this fraction cannot be cloned.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Inverts this fraction
     * @return a new fraction which is the inverse of this fraction
     */
    @Override
    public Fraction inverse() {
       int newNumerator = this.denominator;
       int  newDenominator = this.numerator;
       return new FractionImpl(newNumerator, newDenominator);
    }

    /**
     * Compares this fraction to f.
     * If this fraction is greater than f, 1 is returned
     * If this fraction is equal to f, 0 is returned
     * If this fraction is less than f, -1 is returned
     * @param f the fraction to compare to this fraction
     * @return the comparison of this fraction with fraction f (1, 0, -1)
     */
    @Override
    public int compareTo(Fraction f) {
        FractionImpl g = (FractionImpl) (f);
        /* checks with fraction is larger by divding denominator into numerator */
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
     * Gives the string representation of this fraction,
     * As a whole number if the denominator is equal to zero
     * or as 0/1 if the numerator is zero
     * @return the string value of this fraction
     */
    @Override
    public String toString() {
        /* checks the fraction is not a whole number or zero */
        if(this.denominator != 1 || this.numerator == 0) {
            return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
        }
        else
            return String.valueOf(this.numerator);

    }

}