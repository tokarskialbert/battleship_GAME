import java.util.Set;
import java.util.stream.Collectors;

public class GameConfigurator {

    //ustawiane przez checkbox
    private int targetNumberOfShips;
    private int targetNumberOfFields;

    public void setTargetNumberOfShips(int targetNumberOfShips) {
        this.targetNumberOfShips = targetNumberOfShips;
    }

    public boolean checkIfShipCanBeAddedToSet(Player player) {

        if(player != null) {

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

        if(fields.length == targetNumberOfFields) {

            return true;
        } else {

            return false;
        }

    }

    public boolean checkIfFieldIsAvailable(Field field, Player player) {

        return player.getShipSet().stream()
                .flatMap(shipInterface -> shipInterface.getFieldSet().stream())
                .noneMatch(i -> i.equals(field));
    }
}
