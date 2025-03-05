package src.Labs.thisIsSuperFUNctions;

public class Tester {
    public static void main(String[] args) {
        Rational r = new Rational(new Polynomial(new double[]{
            6,
            -1,
            -6,
            1
        }), new Polynomial(new double[]{
            -2,
            -1,
            1
        }));

        for(Point p : r.holes()) {
            System.out.println(p);
        }
    }
}
