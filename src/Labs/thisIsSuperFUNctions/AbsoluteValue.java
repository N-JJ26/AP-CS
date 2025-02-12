package src.Labs.thisIsSuperFUNctions;

public class AbsoluteValue extends Function
{
    private double a;
    private Point vertex;

    public AbsoluteValue( double a, Point vertex )
    {
        this.a = a;
        this.vertex = vertex;
    }

    public AbsoluteValue( double a, double h, double k )
    {
        vertex = new Point( h, k );
        this.a = a;
    }

    
}
