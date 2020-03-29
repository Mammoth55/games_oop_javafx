package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionValid() {
        Figure figure = new BishopBlack(Cell.F8);
        Cell rsl = figure.position();
        assertThat(rsl, is(Cell.F8));
    }

    @Test
    public void whenCopyValid() {
        Figure figure1 = new BishopBlack(Cell.F8);
        Figure figure2 = figure1.copy(Cell.C5);
        assertThat(figure2.position(), is(Cell.C5));
    }

    @Test
    public void whenWayValid() {
        Figure figure1 = new BishopBlack(Cell.C1);
        Cell[] cells = figure1.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWayInvalid() {
        Figure figure1 = new BishopBlack(Cell.C1);
        Cell[] cells = figure1.way(Cell.C1, Cell.G6);
    }
}