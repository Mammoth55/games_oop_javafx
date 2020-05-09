package job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {

    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        boolean rsl = this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
        for (int i = 0; i < this.table.length; i++) {
                rsl = this.fillBy(Figure3T::hasMarkX, i, 0, 0, 1)
                        || this.fillBy(Figure3T::hasMarkX, 0, i, 1, 0) || rsl;
        }
        return rsl;
    }

    public boolean isWinnerO() {
        boolean rsl = this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1 , 0, -1, 1);
        for (int i = 0; i < this.table.length; i++) {
            rsl = this.fillBy(Figure3T::hasMarkO, i, 0, 0, 1)
                    || this.fillBy(Figure3T::hasMarkO, 0, i, 1, 0) || rsl;
        }
        return rsl;
    }

    public boolean hasGap() {
        boolean rsl = false;
        for (Figure3T[] row : table) {
            for (Figure3T cell : row) {
                if (cell.hasMarkX() == cell.hasMarkO()) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
}