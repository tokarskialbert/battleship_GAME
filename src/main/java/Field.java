import java.util.Objects;

public class Field {

    private final int row;
    private final int column;

    public Field(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return row == field.row && column == field.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
