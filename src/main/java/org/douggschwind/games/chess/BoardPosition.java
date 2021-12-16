package org.douggschwind.games.chess;

/**
 * Represents the physical location of a square on the Chess board.
 * @author Doug Gschwind
 */
public class BoardPosition {
    public static final int MAX_ROW = 8;
    public static final int MIN_ROW = 1;

    public enum Row {
        R8(MAX_ROW),
        R7(7),
        R6(6),
        R5(5),
        R4(4),
        R3(3),
        R2(2),
        R1(MIN_ROW);

        private final int id;

        public static Row getById(int idSought) {
            for (Row row : Row.values()) {
                if (row.getId() == idSought) {
                    return row;
                }
            }
            return null;
        }

        Row(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public enum Column {
        a(1),
        b(2),
        c(3),
        d(4),
        e(5),
        f(6),
        g(7),
        h(8);

        private final int id;

        public static Column getById(int idSought) {
            for (Column column : Column.values()) {
                if (column.getId() == idSought) {
                    return column;
                }
            }
            return null;
        }

        Column(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    private final Row row;
    private final Column column;

    public BoardPosition(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }
}
