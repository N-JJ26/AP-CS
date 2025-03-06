package src.Labs.thisIsSuperFUNctions;

public class Tester {
    public static void main(String[] args) {
        Rational r = new Rational(new Polynomial(new double[]{
            1
        }), new Polynomial(new double[]{
            4,
            -4,
            1
        }));

        for(double d : r.asymptotes()) {
            System.out.println(d);
        }
    }
}
