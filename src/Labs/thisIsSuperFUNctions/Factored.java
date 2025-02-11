package src.Labs.thisIsSuperFUNctions;

public class Factored extends Quadratic
{
    //(x-p)(x-q)
    private int p, q;

    public Factored(int p, int q)
    {
        this.p = p;
        this.q = q;

        super(1, -( p + q ), p * q);
    }

    public String toString()
    {
        return String.format("( x-%f )*( x-%f )", p, q); //fix
    }

    public String toString( boolean generalForm )
    {
        if( generalForm )
            return super.toString();
        else
            return this.toString();
    }
}
