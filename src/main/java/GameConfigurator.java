import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameConfigurator {

    //ustawiane przez checkbox
    private int targetNumberOfShips;
    private int targetNumberOfFields;
    private Set<Field> bannedFields = new HashSet<>();

    public void setTargetNumberOfShips(int targetNumberOfShips) {
        this.targetNumberOfShips = targetNumberOfShips;
    }

    public boolean checkIfShipCanBeAddedToSet(Player player) {

        if (player != null) {

            Set<ShipInterface> shipSet = player.getShipSet().stream()
                    .filter(shipInterface -> shipInterface.getMastNumber() == targetNumberOfShips)
                    .collect(Collectors.toSet());

            if (shipSet.size() < targetNumberOfShips) {

                return true;
            } else {

                return false;
            }
        } else {

            return false;
        }
    }

    public void setTargetNumberOfFields(int targetNumberOfFields) {
        this.targetNumberOfFields = targetNumberOfFields;
    }

    public boolean checkIfCorrectNumberOfFields(Field[] fields) {

        if (fields.length == targetNumberOfFields) {

            return true;
        } else {

            return false;
        }

    }

    public boolean checkIfThereIsNoShipOnField(Field field, Player player) {

        return player.getShipSet().stream()
                .flatMap(shipInterface -> shipInterface.getFieldList().stream())
                .noneMatch(i -> i.equals(field));
    }

    public boolean checkIfFieldsAroundTheShipAreFreeVERTICAL(Ship ship, Player player) {

        boolean shipCanBeAddedToSet = true;


        int rowBannedField = ship.getFieldList().get(0).getRow() - 1;
        int columnBannedField = ship.getFieldList().get(0).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow() - 1;
        columnBannedField = ship.getFieldList().get(0).getColumn();
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow() - 1;
        columnBannedField = ship.getFieldList().get(0).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow();
        columnBannedField = ship.getFieldList().get(0).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow();
        columnBannedField = ship.getFieldList().get(0).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));
        //powyzej wszystkie wokol pierwszego pola

        for(int i = 1; i < ship.getFieldList().size() - 1; i++) {

            rowBannedField = ship.getFieldList().get(i).getRow();
            columnBannedField = ship.getFieldList().get(i).getColumn() - 1;
            bannedFields.add(new Field(rowBannedField, columnBannedField));

            rowBannedField = ship.getFieldList().get(i).getRow();
            columnBannedField = ship.getFieldList().get(i).getColumn() + 1;
            bannedFields.add(new Field(rowBannedField, columnBannedField));
        }
        //powyzej wszystkie poza pierwszym i ostatnim

        int lastIndex = ship.getFieldList().size() - 1;

        rowBannedField = ship.getFieldList().get(lastIndex).getRow();
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() + 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() + 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn();
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() + 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow();
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));
        //powyzej wszystkie wokol ostatniego pola


        for (Field bannedField : bannedFields) {
            if (!(checkIfThereIsNoShipOnField(bannedField, player))) {

                shipCanBeAddedToSet = false;
            }
        }
        return shipCanBeAddedToSet;
    }

    public boolean checkIfFieldsAroundTheShipAreFreeHORIZONTAL(Ship ship, Player player) {

        boolean shipCanBeAddedToSet = true;


        int rowBannedField = ship.getFieldList().get(0).getRow() - 1;
        int columnBannedField = ship.getFieldList().get(0).getColumn();
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow() - 1;
        columnBannedField = ship.getFieldList().get(0).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow();
        columnBannedField = ship.getFieldList().get(0).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow() + 1;
        columnBannedField = ship.getFieldList().get(0).getColumn() - 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(0).getRow() + 1;
        columnBannedField = ship.getFieldList().get(0).getColumn();
        bannedFields.add(new Field(rowBannedField, columnBannedField));
        //powyzej wszystkie wokol pierwszego pola

        for(int i = 1; i < ship.getFieldList().size() - 1; i++) {

            rowBannedField = ship.getFieldList().get(i).getRow() - 1;
            columnBannedField = ship.getFieldList().get(i).getColumn();
            bannedFields.add(new Field(rowBannedField, columnBannedField));

            rowBannedField = ship.getFieldList().get(i).getRow() + 1;
            columnBannedField = ship.getFieldList().get(i).getColumn();
            bannedFields.add(new Field(rowBannedField, columnBannedField));
        }
        //powyzej wszystkie poza pierwszym i ostatnim

        int lastIndex = ship.getFieldList().size() - 1;

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() - 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn();
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() - 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow();
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() + 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn() + 1;
        bannedFields.add(new Field(rowBannedField, columnBannedField));

        rowBannedField = ship.getFieldList().get(lastIndex).getRow() + 1;
        columnBannedField = ship.getFieldList().get(lastIndex).getColumn();
        bannedFields.add(new Field(rowBannedField, columnBannedField));
        //powyzej wszystkie wokol ostatniego pola


        for (Field bannedField : bannedFields) {
            if (!(checkIfThereIsNoShipOnField(bannedField, player))) {

                shipCanBeAddedToSet = false;
            }
        }
        return shipCanBeAddedToSet;
    }

    public boolean checkIfShipIsStraight(Ship ship) {

        int column = ship.getFieldList().get(0).getColumn();
        int row = ship.getFieldList().get(0).getRow();

        boolean verticalShip = ship.getFieldList().stream()
                .allMatch(i -> i.getColumn() == column);

        boolean horizontalShip = ship.getFieldList().stream()
                .allMatch(i -> i.getRow() == row);

        if (verticalShip || horizontalShip) {

            return true;
        } else {

            return false;
        }
    }
}