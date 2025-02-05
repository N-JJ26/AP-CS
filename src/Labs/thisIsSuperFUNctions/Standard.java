package src.Labs.thisIsSuperFUNctions;

public class Standard extends Linear
{
    private int A, B, C;

    public Standard( int A, int B, int C )
    {
        this.A = A;
        this.B = B;
        this.C = C;

        super( ( double )( -A ) / B, ( ( double )C ) / B ); //y = -A/B x + C/B
    }

    public String toString()
    {
        return null;
    }

    public String toString( boolean slopeIntercept )
    {
        return null;
    }
}
