import fraction.Fraction;
import fraction.FractionImpl;

public class Main {

    public static void main(String[] args) {

        FractionImpl f = new FractionImpl("3/4");
        System.out.println(f.getDenominator());
        System.out.println(f.getNumerator());

    }
}