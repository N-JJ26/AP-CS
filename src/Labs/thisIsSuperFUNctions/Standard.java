package src.Labs.thisIsSuperFUNctions;

public class Standard extends Linear
{
    private int A, B, C;

    public Standard( int A, int B, int C )
    {
        this.A = A;
        this.B = B;
        this.C = C;

        super( ( double )( -A ) / B, ( ( double )C ) / B );
    }

    public String toString()
    {
        return "";
    }

    public String toString( boolean slopeIntercept )
    {
        if( slopeIntercept )
            return this.toString();
        else
            return super.toString();
    }
}
