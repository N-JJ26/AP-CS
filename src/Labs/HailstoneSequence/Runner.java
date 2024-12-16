package src.Labs.HailstoneSequence;

/**
 * JAVADOC
 *
 * @author Nate Johnson
 * @version 12/16/24
 */
public class Runner {
    private static final int NUM_SEQUENCES_NORMAL = 1000;
    private static final int NUM_SEQUENCES_EXTENSION = 100000;

    private static Sequence[] sequences;

    // public static void main() {
    //     Sequence[] longest = new Sequence[5];
    //     Sequence[] largest = new Sequence[5];
    //     sequences = new Sequence[NUM_SEQUENCES_NORMAL];

    //     for(int i = 0; i < NUM_SEQUENCES_NORMAL; i++)
    //         sequences[i] = new Sequence(i + 1);

    //     for(int i = 0; i < 5; i++) {
    //         longest[i] = sequences[i];
    //         largest[i] = sequences[i];
    //     }

    //     longest = sortLongest(longest);
    //     largest = sortLargest(largest);

    //     for(Sequence sequence : sequences) {
    //         if(sequence.getLength() > longest[0].getLength()) {
    //             longest[0] = sequence;
    //             longest = sortLongest(longest);
    //         }

    //         if(sequence.getLargestStone() > largest[0].getLargestStone()) {
    //             largest[0] = sequence;
    //             largest = sortLargest(largest);
    //         }
    //     }

    //     for(int i = 4; i >= 0; i--) {
    //         System.out.printf("seed: %d  stone: %d\n", largest[i].getSeed(), largest[i].getLargestStone());
    //     }
    //     System.out.println();
    //     for(int i = 4; i >= 0; i--) {
    //         System.out.printf("seed: %d  longest: %d\n", longest[i].getSeed(), longest[i].getLength());
    //     }
    // }

    public static void main() {
        sequences = new Sequence[NUM_SEQUENCES_EXTENSION];

        for(int i = 0; i < NUM_SEQUENCES_EXTENSION; i++)
            sequences[i] = new Sequence(i + 1);
        
        System.out.println("EXT 1, 100000 Sequences, top 5 of length and largest stone");
        Sequence[] longest = new Sequence[5];
        Sequence[] largest = new Sequence[5];

        for(int i = 0; i < 5; i++) {
            longest[i] = sequences[i];
            largest[i] = sequences[i];
        }

        longest = sortLongest(longest);
        largest = sortLargest(largest);

        for(Sequence sequence : sequences) {
            if(sequence.getLength() > longest[0].getLength()) {
                longest[0] = sequence;
                longest = sortLongest(longest);
            }

            if(sequence.getLargestStone() > largest[0].getLargestStone()) {
                largest[0] = sequence;
                largest = sortLargest(largest);
            }
        }

        for(int i = 4; i >= 0; i--) {
            System.out.printf("seed: %d  stone: %d\n", largest[i].getSeed(), largest[i].getLargestStone());
        }
        System.out.println();
        for(int i = 4; i >= 0; i--) {
            System.out.printf("seed: %d  longest: %d\n", longest[i].getSeed(), longest[i].getLength());
        }

        System.out.println("\nEXT 2 and 3, top 3 most occurring length and largest stone");
        int[] mostOccurringLength = new int[3];
        int[] mostOccurringLargest = new int[3];

        int longestCount, largestCount;
        
        for(Sequence sequence : sequences) {
            
        }
    }

    private static Sequence[] sortLongest(Sequence[] arr) {
        for(int i = 1; i < arr.length - 1; i++) {
            boolean changed = false;
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j].getLength() > arr[j + 1].getLength()) {
                    Sequence temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changed = true;
                }
            }
            if(!changed) {
                break;
            }
        }
        return arr;
    }

    private static Sequence[] sortLargest(Sequence[] arr) {
        for(int i = 1; i < arr.length - 1; i++) {
            boolean changed = false;
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j].getLargestStone() > arr[j + 1].getLargestStone()) {
                    Sequence temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changed = true;
                }
            }
            if(!changed) {
                break;
            }
        }
        return arr;
    }

    private static boolean isFibonacci(int stone) {

        return false;
    }
}
