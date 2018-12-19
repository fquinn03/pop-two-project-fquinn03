import fraction.Fraction;
import fraction.FractionImpl;

public class Main {

    public static void main(String[] args) {

        FractionImpl f = new FractionImpl(3, 5);
        FractionImpl g = new FractionImpl(0);
        f.divide(g).toString();


    }
}