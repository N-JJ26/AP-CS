package src.Labs.thisIsSuperFUNctions;

public class Tester {
    public static void main(String[] args) {
        Polynomial p = new Polynomial(new double[]{
            1,
            0,
            2
        });

        Polynomial q = new Polynomial(new double[]{
            2,
            4,
            Math.E,
            9
        });

        System.out.println(p);
        System.out.println(q);
    }
}
