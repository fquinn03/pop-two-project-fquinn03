package fraction;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class Tests {

/*GCD testing passed as package protected method. Changed to Private now as required by specification.*/
    @Test
        public void TestingGCDFunction(){
        assertThat(FractionImpl.findGCD(6, 9), is(3));
        assertThat(FractionImpl.findGCD(16, 4), is(4));
        assertThat(FractionImpl.findGCD(24, 16), is(8));
        assertThat(FractionImpl.findGCD(-35, 20), is(5));
    }

    @Test
        public void wholeNumberFromAString(){
        Fraction f = new FractionImpl("3");
        assertThat(f.toString(), is("3"));
    }

    @Test
    public void fractionFromTwoInts(){
        Fraction f = new FractionImpl(6,7);
        assertThat(f.toString(), is("6/7"));
    }

    @Test(expected = ArithmeticException.class)
        public void zeroDenomiatorIsNotAllowed(){
        FractionImpl f = new FractionImpl(3,0);
    }

    @Test
        public void fractionsAsString() {
        Fraction f = new FractionImpl(3, 4);
        assertThat(f.toString(), is("3/4"));
    }

    @Test
        public void wholeNumFractionAsString(){
        Fraction g = new FractionImpl(7);
        assertThat(g.toString(), is("7"));
        Fraction h = new FractionImpl(-7);
        assertThat(h.toString(), is("-7"));
    }

    @Test
    public void negativeNumeratorToString(){
        Fraction n = new FractionImpl(-5, 6);
        assertThat(n.toString(), is("-5/6"));
    }

    @Test
    public void negativeDenominatorToString(){
        FractionImpl n = new FractionImpl(2, -3);
        assertThat(n.toString(), is("-2/3"));
    }

    @Test
    public void zeroAsAFraction(){
        Fraction f = new FractionImpl(0);
        assertThat(f.toString(), is("0/1"));
    }

    @Test
    public void normaliseFraction(){
        Fraction f = new fraction.FractionImpl(9, 12);
        assertThat(f.toString(), is("3/4"));
    }

    @Test
    public void normaliseNegativeFraction(){
        Fraction f = new fraction.FractionImpl(-9, 12);
        assertThat(f.toString(), is("-3/4"));
    }

    @Test
    public void normaliseLargeNumeratorFraction(){
        Fraction f = new fraction.FractionImpl(16, 4);
        assertThat(f.toString(), is("4"));
    }

    @Test
    public void normaliseLargeNumeratorNegativeDenominatrFraction(){
        Fraction f = new fraction.FractionImpl(15, -3);
        assertThat(f.toString(), is("-5"));
    }

    @Test
    public void normaliseNegativeDenominatorFraction(){
        Fraction f = new fraction.FractionImpl(6, -18);
        assertThat(f.toString(), is("-1/3"));
    }

    @Test(expected = ArithmeticException.class)
    public void stringToFractionZeroDenominator(){
        FractionImpl f = new FractionImpl("3/0");
    }

    @Test(expected = NumberFormatException.class)
        public void mixedFractionStringtoFractionImpl() {
            FractionImpl f = new FractionImpl("1 3/4");

    }
    @Test
    public void addTwoPositiveFractionsSameDenominator(){
        FractionImpl f = new FractionImpl(1, 4);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.add(g).toString(), is("3/4"));
    }

    @Test
    public void addTwoPositiveFractionsDifferentDenominator(){
        FractionImpl f = new FractionImpl(1, 3);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.add(g).toString(), is("5/6"));
    }
    @Test
    public void addOneNegativeOnePositiveFraction(){
        FractionImpl f = new FractionImpl(1, -3);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.add(g).toString(), is("1/6"));
    }
    @Test
    public void addOneNegativeOnePositiveFractionLargeNumerator(){
        FractionImpl f = new FractionImpl(10, 2);
        FractionImpl g = new FractionImpl(9, -3);
        assertThat(f.add(g).toString(), is("2"));
    }

    @Test
    public void addTwoNegativeOneFractions(){
        FractionImpl f = new FractionImpl(-7, 10);
        FractionImpl g = new FractionImpl(2, -15);
        assertThat(f.add(g).toString(), is("-5/6"));
    }

    @Test
    public void addFractionsToGiveZero(){
        FractionImpl f = new FractionImpl(3, -6);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.add(g).toString(), is("0/1"));
    }

    @Test
    public void subractTwoPostitiveFractionsSameDenominator(){
        FractionImpl f = new FractionImpl(1, 4);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.subtract(g).toString(), is("-1/4"));
    }

    @Test
    public void subtractOneNegativeOnePostiveFraction(){
        FractionImpl f = new FractionImpl(3, -6);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.subtract(g).toString(), is("-1"));
    }

    @Test
    public void subtractTwoNegativeFractions(){
        FractionImpl f = new FractionImpl(-7, 10);
        FractionImpl g = new FractionImpl(2, -15);
        assertThat(f.subtract(g).toString(), is("-17/30"));
    }

    @Test
    public void multiplyTwoPositiveFractions(){
        FractionImpl f = new FractionImpl(2, 3);
        FractionImpl g = new FractionImpl(5, 8);
        assertThat(f.multiply(g).toString(), is("5/12"));
        FractionImpl h = new FractionImpl(4, 3);
        FractionImpl j = new FractionImpl(5, 10);
        assertThat(h.multiply(j).toString(), is("2/3"));
    }
    @Test
    public void multiplyANegativeFractionByPositiveFraction(){
        FractionImpl f = new FractionImpl(2, 3);
        FractionImpl g = new FractionImpl(3, -8);
        assertThat(f.multiply(g).toString(), is("-1/4"));
    }
    @Test
    public void multiplyTwoNegativeFractions(){
        FractionImpl f = new FractionImpl(-6, 8);
        FractionImpl g = new FractionImpl(4, -5);
        assertThat(f.multiply(g).toString(), is("3/5"));
    }
    @Test
    public void multiplyAFractionByZero(){
        FractionImpl f = new FractionImpl(2, 3);
        FractionImpl g = new FractionImpl(0);
        assertThat(f.multiply(g).toString(), is("0/1"));
    }

    @Test
    public void multiplyTwoLargeNumeratorFrations(){
        FractionImpl f = new FractionImpl(81, 9);
        FractionImpl g = new FractionImpl(36, 12);
        assertThat(f.multiply(g).toString(), is("27"));
        FractionImpl h = new FractionImpl(14, 3);
        FractionImpl j = new FractionImpl(25, 10);
        assertThat(h.multiply(j).toString(), is("35/3"));
    }

    @Test
    public void divideWholeNumByAFraction(){
        FractionImpl f = new FractionImpl(5);
        FractionImpl g = new FractionImpl(1,2);
        assertThat(f.divide(g).toString(), is("10"));
    }

    @Test
    public void divideFractionByAFraction(){
        FractionImpl f = new FractionImpl(3, 5);
        FractionImpl g = new FractionImpl(1,4);
        assertThat(f.divide(g).toString(), is("12/5"));
    }

    @Test(expected = ArithmeticException.class)
    public void divideFractionZero(){
        FractionImpl f = new FractionImpl(3, 5);
        FractionImpl g = new FractionImpl(0);
        f.divide(g);
    }

    @Test(expected = ArithmeticException.class)
    public void divideFractionByZeroFraction(){
        FractionImpl f = new FractionImpl(3, 5);
        FractionImpl g = new FractionImpl(0, 1);
        f.divide(g);
    }

    @Test
    public void divideFractionWithZeroNumeratorByAnotherFraction(){
        FractionImpl f = new FractionImpl(0, 5);
        FractionImpl g = new FractionImpl(3, 1);
        assertThat(f.divide(g).toString(), is("0/1"));
    }

    @Test
    public void divideFractionByNegativeFraction(){
        FractionImpl f = new FractionImpl(3, 5);
        FractionImpl g = new FractionImpl(7, -8);
        assertThat(f.divide(g).toString(), is("-24/35"));
    }

    @Test
    public void negativeNumeratorNegativeDenominatorToString(){
        FractionImpl n = new FractionImpl(-2, -3);
        assertThat(n.toString(), is("2/3"));
    }

    @Test
    public void divideNegativeFractionByNegativeFraction(){
        FractionImpl f = new FractionImpl(3, -5);
        FractionImpl g = new FractionImpl(-5, 8);
        assertThat(f.divide(g).toString(), is("24/25"));
    }

    @Test
    public void absOfPositiveFraction(){
        Fraction f = new FractionImpl(7,8);
        assertThat(f.abs().toString(), is("7/8"));
    }

    @Test
    public void absOfNegativeFraction(){
        Fraction f = new FractionImpl(-7,8);
        assertThat(f.abs().toString(), is("7/8"));
    }

    @Test
    public void absOfTwoNegativesMakeAPositiveFraction(){
        Fraction f = new FractionImpl(-5,-9);
        assertThat(f.abs().toString(), is("5/9"));
    }


    @Test
    public void negatePositiveFraction(){
        Fraction f = new FractionImpl(5,9);
        assertThat(f.negate().toString(), is("-5/9"));
    }

    @Test
    public void negateNegativeFraction(){
        Fraction f = new FractionImpl(-6,9);
        assertThat(f.negate().toString(), is("2/3"));
        Fraction g = new FractionImpl(3,-5);
        assertThat(g.negate().toString(), is("3/5"));
    }

    @Test
    public void negateDoubleNegativePositiveFraction(){
        Fraction f = new FractionImpl(-3,-5);
        assertThat(f.negate().toString(), is("-3/5"));
    }

    @Test
    public void inversePositiveFraction(){
        Fraction f = new FractionImpl(3,5);
        assertThat(f.inverse().toString(), is("5/3"));
    }

    @Test
    public void inverseNegativeNumeratorFraction(){
        Fraction f = new FractionImpl(-3,6);
        assertThat(f.inverse().toString(), is("-2"));
    }

    @Test
    public void inverseNegativeDenominatorFraction(){
        Fraction f = new FractionImpl(3,-4);
        assertThat(f.inverse().toString(), is("-4/3"));
    }

    @Test
    public void inverseNegativeNumeratorAndDenominatorFraction(){
        Fraction f = new FractionImpl(-3,-4);
        assertThat(f.inverse().toString(), is("4/3"));
    }

    @Test
    public void compareToSomethingLarger(){
        FractionImpl f = new FractionImpl(1,5);
        FractionImpl g = new FractionImpl(3, 7);
        assertThat(f.compareTo(g), is(-1));
    }

    @Test
    public void compareToSomethingSmaller(){
        FractionImpl f = new FractionImpl(4,5);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.compareTo(g), is(1));
    }

    @Test
    public void compareToSomethingTheSame(){
        FractionImpl f = new FractionImpl(3,6);
        FractionImpl g = new FractionImpl(4, 8);
        assertThat(f.compareTo(g), is(0));
    }

    @Test
    public void equalsSomethingTheSame(){
        FractionImpl f = new FractionImpl(3,6);
        FractionImpl g = new FractionImpl(4, 8);
        assertEquals(true, f.equals(g));
        FractionImpl h = new FractionImpl(9,3);
        FractionImpl j = new FractionImpl(3);
        assertEquals(true, h.equals(j));
    }

    @Test
    public void equalsSomethingNotTheSame(){
        FractionImpl f = new FractionImpl(3);
        FractionImpl g = new FractionImpl(4, 9);
        assertTrue(!f.equals(g));
    }

    @Test(expected = ClassCastException.class)
    public void compareFractionsToStrings(){
        FractionImpl f = new FractionImpl(3,5);
        f.compareTo("abc");
    }

    @Test
    public void compareToInteger(){
        FractionImpl f = new FractionImpl(3,6);
        assertThat(f.compareTo(6), is(-1));
    }

    @Test
    public void stringConstructorWithSpaces(){
        FractionImpl f = new FractionImpl(" 3 / 4 ");
        assertThat(f.toString(), is("3/4"));
    }

    @Test
    public void stringConstructorWithSpacesAndNeedsReducing(){
        FractionImpl f = new FractionImpl(" 2/4");
        assertThat(f.toString(),is("1/2"));
    }

    @Test
    public void stringConstructorWithDoubleSpacesAndNeedsReducing(){
        FractionImpl f = new FractionImpl(" 6 / 9");
        assertThat(f.toString(),is("2/3"));
    }
}
