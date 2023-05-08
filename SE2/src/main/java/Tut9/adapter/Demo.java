package Tut9.adapter;

import Tut9.adapter.adapter.SquarePegAdapter;
import Tut9.adapter.round.RoundHole;
import Tut9.adapter.round.RoundPeg;
import Tut9.adapter.square.SquarePeg;

/**
 * Somewhere in client code... ^_^
 */
public class Demo {
    public static void main(String[] args) {
        //TODO: Create 2 instances of RoundHole and RoundPeg with same radius
        RoundHole roundHole1 = new RoundHole(5);
        RoundPeg roundPeg1 = new RoundPeg(5);

        //TODO: If RoundHole instance can "fit" with RoundPeg instance => show a message
        if (roundHole1.fits(roundPeg1)) {
            System.out.println("RoundHole r5 can fit with RoundPeg r5");
        }

        //TODO: Create 2 instances of SquarePeg with 2 different widths
        SquarePeg squarePeg1 = new SquarePeg(5);
        SquarePeg squarePeg2 = new SquarePeg(10);

        //Note: You can't make RoundHole instance "fit" with SquarePeg instance
        //Therefore, we need to use Adapter for solving the problem.

        //TODO: Create 2 corresponding instances of SquarePegAdapter
        SquarePegAdapter squarePegAdapter1 = new SquarePegAdapter(squarePeg1);
        SquarePegAdapter squarePegAdapter2 = new SquarePegAdapter(squarePeg2);

        //TODO: If the RoundHole instance can "fit" with "small" RoundPegAdapter instance
        //show a suitable message
        if (roundHole1.fits(squarePegAdapter1)) {
            System.out.println("RoundHole r5 can fit with SquarePeg w5");
        }

        //TODO: If the RoundHole instance can not "fits" with "big" RoundPegAdapter instance
        //show a suitable message
        if (!roundHole1.fits(squarePegAdapter2)) {
            System.out.println("RoundHole r5 can not fit with SquarePeg w10");
        }
    }
}