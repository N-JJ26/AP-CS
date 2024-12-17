package src.Labs.HailstoneSequence;

/**
 * Runner does a bunch of tests with the Sequence class,
 *  such as finding the top 1000 and 100000 largest and longest seeds,
 *  the largest powers of 2 and 5, and the largest fibonacci numbers and factorials
 *
 * @author Nate Johnson
 * @version 12/16/24
 */
public class Runner {
    private static final int NUM_SEQUENCES_NORMAL = 1000;
    private static final int NUM_SEQUENCES_EXTENSION = 100000;

    private static Sequence[] sequences;

    public static void main() {
        Sequence[] longest = new Sequence[5];
        Sequence[] largest = new Sequence[5];
        sequences = new Sequence[NUM_SEQUENCES_NORMAL];

        for(int i = 0; i < NUM_SEQUENCES_NORMAL; i++)
            sequences[i] = new Sequence(i + 1);

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
    }

    public static void extMain() {
        sequences = new Sequence[NUM_SEQUENCES_EXTENSION];

        for(int i = 0; i < NUM_SEQUENCES_EXTENSION; i++)
            sequences[i] = new Sequence(i + 1);
        
        System.out.println("EXT 1, 100000 Sequences, top 5 of length and largest stone\n");
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

        System.out.println("\nEXT 4 and 5, highest power of 4 and power of 5\n");

        Sequence highest2 = sequences[0];
        Sequence highest5 = sequences[0];

        for(Sequence sequence : sequences) {
            if(isPowerN(2, sequence.getLargestStone())
                && sequence.getLargestStone() > highest2.getLargestStone())
                highest2 = sequence;

            if(isPowerN(5, sequence.getLargestStone())
                && sequence.getLargestStone() > highest5.getLargestStone())
                highest5 = sequence;
        }

        System.out.printf("POWER OF 2\nseed: %d  stone: %d\n\nPOWER OF 5\nseed: %d  stone: %d\n",
                            highest2.getSeed(), highest2.getLargestStone(),
                            highest5.getSeed(), highest5.getLargestStone());

        System.out.println("\nEXT 7 and 8, highest fibonacci and factorial stones\n");

        Sequence highestFib = sequences[0];
        Sequence highestFac = sequences[0];

        for(Sequence sequence : sequences) {
            if(isFibonacci(sequence.getLargestStone()) &&
                sequence.getLargestStone() > highestFib.getLargestStone())
                highestFib = sequence;

            if(isFactorial(sequence.getLargestStone()) &&
                sequence.getLargestStone() > highestFac.getLargestStone())
                highestFac = sequence;
        }

        System.out.printf("Fibonacci\nseed: %d  stone: %d\n\nFactorial\nseed:%d  stone: %d\n",
                            highestFib.getSeed(), highestFib.getLargestStone(),
                            highestFac.getSeed(), highestFac.getLargestStone());
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

    private static boolean isPowerN(int base, int value) {
        int count = 0;
        while(Math.pow(base, count) <= value) {
            if(Math.pow(base, count) == value)
                return true;
            count++;
        }
        return false;
    }

    private static int fibonacci(int n) {
        final int OFFSET = 3;

        int first = 1;
        int second = 2;
        int next = 0;

        for(int i = 0; i < n - OFFSET; i++) {
            next = first + second;

            first = second;
            second = next;
        }

        return next;
    }

    private static int factorial(int n) {
        int result = n;

        for(int i = 1; i < n; i++) {
            result *= n - i;
        }
        return result;
    }

    private static boolean isFibonacci(int value) {
        int count = 0;
        while(fibonacci(count) <= value) {
            if(fibonacci(count) == value)
                return true;
            count++;
        }
        return false;
    }

    private static boolean isFactorial(int value) {
        int count = 0;
        while(factorial(count) <= value) {
            if(factorial(count) == value)
                return true;
            count++;
        }
        return false;
    }
}
