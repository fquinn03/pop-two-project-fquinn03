package fraction;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;


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
}
