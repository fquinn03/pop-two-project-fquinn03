package fraction;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class Tests {

    @Test
    public void isaFraction() {
        Fraction f = new fraction.FractionImpl(3, 4);
        assertTrue(f instanceof Fraction);
    }
    @Test
    public void wholeNumsAreFractions(){
        Fraction g = new fraction.FractionImpl(7);
        assertTrue(g instanceof Fraction);
    }

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

}
