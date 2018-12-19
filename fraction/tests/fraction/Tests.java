package fraction;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class Tests {

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

    @Test(expected = ArithmeticException.class)
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
    public void addTwoPostiveFractionsDifferentDenominator(){
        FractionImpl f = new FractionImpl(1, 3);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.add(g).toString(), is("5/6"));
    }
    @Test
    public void addOneNegativeOnePostiveFraction(){
        FractionImpl f = new FractionImpl(1, -3);
        FractionImpl g = new FractionImpl(2, 4);
        assertThat(f.add(g).toString(), is("1/6"));
    }
    @Test
    public void addOneNegativeOnePostiveFractionLargeNumerator(){
        FractionImpl f = new FractionImpl(10, 2);
        FractionImpl g = new FractionImpl(9, -3);
        assertThat(f.add(g).toString(), is("2"));
    }
}
