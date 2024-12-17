package src.Labs.HailstoneSequence;

import java.util.ArrayList;

/**
 * The Hailstone sequence: recursively, check a number,
 *  if it is odd, multiply it by three and add 1, otherwise, divide by 2
 *
 * @author Nate Johnson
 * @version 12/16/24
 */
public class Sequence {
    private ArrayList<Integer> stones;

    public Sequence(int seed) {
        stones = new ArrayList<Integer>();
        generate(seed);
    }

    private void generate(int stone) {
        stones.add(stone);
        if(stone == 1)
            return;

        if(stone % 2 == 0)
            generate(stone / 2);
        else
            generate(3 * stone + 1);
    }

    public int getSeed() {
        return stones.get(0);
    }

    public int getLength() {
        return stones.size();
    }

    public int getLargestStone() {
        int largest = 0;

        for(int stone : stones)
            if(stone > largest)
                largest = stone;

        return largest;
    }
}
