package fraction;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class Tests {

    @Test(expected = ArithmeticException.class)
        public void zeroDenomiatorIsNotAllowed(){
        Fraction f = new fraction.FractionImpl(3,0);
    }

    @Test
        public void fractionsAsString() {
        Fraction f = new fraction.FractionImpl(3, 4);
        assertThat(f.toString(), is("3/4"));
    }

    @Test
        public void wholeNumFractionAsString(){
        Fraction g = new fraction.FractionImpl(7);
        assertThat(g.toString(), is("7"));
    }

    @Test
    public void negativeNumeratorToString(){
        Fraction n = new fraction.FractionImpl(-5, 6);
        assertThat(n.toString(), is("-5/6"));
    }

    @Test
    public void negativeDenominatorToString(){
        Fraction n = new fraction.FractionImpl(2, -3);
        assertThat(n.toString(), is("-2/3"));
    }

    @Test
    public void zeroAsAFraction(){
        Fraction f = new fraction.FractionImpl(0);
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
        Fraction f = new fraction.FractionImpl(18, -6);
        assertThat(f.toString(), is("-3"));
    }

}
