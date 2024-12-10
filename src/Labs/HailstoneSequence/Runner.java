package src.Labs.HailstoneSequence;

/**
 * JAVADOC
 *
 * @author Nate Johnson
 * @version 12/10/24
 */
public class Runner {
    private static final int NUM_SEQUENCES = 1000;
    private static final int TOP_FIVE = 5;

    private static Sequence sequence;
    private static Sequence[] sequences = new Sequence[NUM_SEQUENCES];

    private static int largestStone, longestSequence = 0;

    private static int[] seeds = new int[TOP_FIVE];

    public static void main(String[] args) {
        for(int i = 1; i <= NUM_SEQUENCES; i++) {
            sequence = new Sequence(i);
            sequences[i - 1] = sequence;

            for(Sequence sequence : sequences) {
                sequence = new Sequence(i);

                if(sequence.getLargestStone() > largestStone) {
                    largestStone = sequence.getLargestStone();
                    seeds[0] = sequence.getSeed();
                }
            }

            for(Sequence sequence : sequences) {
                sequence = new Sequence(i);

                if(sequence.getLength() > longestSequence) {
                    longestSequence = sequence.getLength();
                    seeds[1] = sequence.getSeed();
                }
            }
        }

        System.out.printf("\nseed = %d; stone = %d\n",
                            seeds[0], largestStone);
        System.out.printf("\nseed = %d; length = %d\n",
                                seeds[1], longestSequence);
    }
}
