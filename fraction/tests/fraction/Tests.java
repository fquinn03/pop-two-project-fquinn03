package fraction;
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
    @Test
    public void stringToFraction(){
        FractionImpl f = new FractionImpl("7/8");
        assertThat(f.getNumerator(), is(7));
        assertThat(f.getDenominator(), is(8));
    }

    @Test
    public void stringToNegativeNumeratorFraction(){
        FractionImpl f = new FractionImpl("-5/6");
        assertThat(f.getNumerator(), is(-5));
        assertThat(f.getDenominator(), is(6));
    }

    @Test
    public void stringToNegativeDenominatorFraction(){
        FractionImpl f = new FractionImpl("5/-6");
        assertThat(f.getNumerator(), is(-5));
        assertThat(f.getDenominator(), is(6));
    }

    @Test(expected = ArithmeticException.class)
    public void stringToFractionZeroDenominator(){
        FractionImpl f = new FractionImpl("3/0");
    }
}
