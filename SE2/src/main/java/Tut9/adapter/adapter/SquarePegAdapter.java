package Tut9.adapter.adapter;

import Tut9.adapter.round.RoundPeg;
import Tut9.adapter.square.SquarePeg;

/**
 * Adapter allows fitting square pegs into round holes.
 */
public class SquarePegAdapter extends RoundPeg {
    //TODO: Declare an attribute: name = peg, type = SquarePeg
    private SquarePeg peg;

    //TODO: Declare the constructor with a parameter
    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    //TODO: Implement getRadius() method
    @Override
    public double getRadius() {
        double result = 0;
        // Calculate a minimum circle radius, which can fit this peg.
        //TODO: result = Square Root [(getWidth() of SquarePeg/2)^2) * 2)] -> x^2/2
        result = Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2);
        return result;
    }
}