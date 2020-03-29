package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public class BishopBlack implements Figure {

    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int index = 0;
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        int size = Math.abs(deltaX);
        deltaX = deltaX / size;
        deltaY = deltaY / Math.abs(deltaY);
        Cell[] steps = new Cell[size];
        for (int i = 1; i <= size; i++) {
            steps[index++] = Cell.findBy(i * deltaX + source.x , i * deltaY + source.y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y) ? true : false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
