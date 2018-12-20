import fraction.Fraction;
import fraction.FractionImpl;

public class Main {

    public static void main(String[] args) {

        FractionImpl f = new FractionImpl(3, 5);
        FractionImpl g = new FractionImpl(0);
        f.divide(g).toString();

        Fraction j = new FractionImpl("3");
        System.out.println(g.clone());
        System.out.println(g.hashCode());
        System.out.println(f.hashcode());



    }
}