package src.Labs.thisIsSuperFUNctions;

public class Vertex extends Quadratic
{
    public Vertex( double a, int h, int k )
    {
        super( a, -2 * h * a, a * h * h + k );
    }
}
